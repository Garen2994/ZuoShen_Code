package class_04;
/**
 * @Title : 平衡二叉树验证的两种解法
 * @Author : garen_hou
 * @Email : garen2994@hotmail.com
 * @Date :  2020/5/12 3:44 下午
 */
public class isBalanceTree {
//    static boolean isBalance = true;    //尽量不用全局变量
    public static class Node {
        public int value;
        public Node left;
        public Node right;
        public Node(int data) {
            this.value = data;
        }
    }
    /**
     * @description 时间复杂度为O(NlogN)的解法
     * @param head
     * @return boolean
     */
    public static boolean isBalanced(Node head) {
        if(head == null){
            return true;
        }
        int lH = getHeight(head.left);
        int rH = getHeight(head.right);
        System.out.println(lH);
        System.out.println(rH);
        int diff = lH - rH;
        System.out.println(diff);
        if(Math.abs(diff) > 1){
            return false;
        }
        return isBalanced(head.left) && isBalanced(head.right);
    }
    
    private static int getHeight(Node head){
        if(head == null){
            return 0;
        }
        
        int lH = getHeight(head.left);
        int rH = getHeight(head.right);
        
        return lH > rH ? lH + 1 : rH + 1;
    }
    /**
     * @description 改进：在遍历每一个节点的同时就记录其深度;时间复杂度：O(logN)
     * @param
     * @return boolean
     */
    public static boolean isBalancedPro(Node head){
        boolean[] res =  new boolean[1];
        res[0] = true;
        getHeightPro(head,0,res);
        return res[0];
//        return isBalance; //在getHeightPro中赋值
    }
    
    public static int getHeightPro(Node head,int level, boolean[] res){
        if(head == null){
            return level;}
        int lH = getHeightPro(head.left,level+1,res);
        if(!res[0]){
            return level;
        }
        int rH = getHeightPro(head.right,level,res);
        if(!res[0]){
            return level;
        }
        if(Math.abs(lH - rH) > 1){
            res[0] = false;
            
        }
        return Math.max(lH, rH) + 1;
    }
    
    public static void main(String[] args) {
        Node head = new Node(3);
        head.left = null;
//        head.left = new Node(9);
        head.right = new Node(20);
//        head.left.right = null;
//        head.left.left = null;
        head.right.left = new Node(9);
        head.right.right = new Node(5);
        head.right.right.right = new Node(7);
    
        System.out.println(isBalancedPro(head));
    }
}
