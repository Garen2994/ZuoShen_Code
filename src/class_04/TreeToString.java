package class_04;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Title : 搞懂序列化与反序列化
 * @Author : garen_hou
 * @Email : garen2994@hotmail.com
 * @Date :  2020/5/5 11:51 下午
 */
public class TreeToString {
    public static class TreeNode{
        public int value;
        public TreeNode right;
        public TreeNode left;
    
        public TreeNode(int data) {
            this.value = data;
        }
    }
    public String toString(TreeNode root){
        StringBuilder sb = new StringBuilder("");
        this.preOrder(root,sb);
        return sb.toString();
    }
    private void preOrder(TreeNode root,StringBuilder sb){
        if(root == null){
            sb.append("null,");
            return;
        }
        sb.append(root.value+",");
        this.preOrder(root.left, sb);
        this.preOrder(root.right, sb);
    }
    public TreeNode deSerialize(String data){
        String[] values = data.split(",");
        Queue<String> queue = new LinkedList<>();
        for (int i = 0; i != values.length ; i++) {
            queue.offer(values[i]);
        }
        return deSerializePreOder(queue);
    }
    
    private TreeNode deSerializePreOder(Queue<String> queue) {
        String value = queue.poll();
        if("null".equals(value)){
            return null;
        }
        TreeNode root = new TreeNode(Integer.parseInt(value));
        root.left = deSerializePreOder(queue);
        root.right = deSerializePreOder(queue);
        return root;
        
    }
}
