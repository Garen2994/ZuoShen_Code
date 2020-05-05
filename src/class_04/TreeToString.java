package class_04;

import javax.swing.tree.TreeNode;

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
}
