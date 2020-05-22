package class_04;

/**
 * @Title : Morris遍历的
 * @Author : garen_hou
 * @Email : garen2994@hotmail.com
 * @Date :  2020/5/21 1:44 上午
 */
public class MorrisTraversal {
    public static class Node {
        public Node left;
        public Node right;
        public int val;
        
        public Node(int val) {
            this.val = val;
        }
    }
    
    /**
     * @param
     * @return void
     * @description Morris 中序遍历
     */
    public static void morrisIn(Node head) {
        if (head == null) {
            throw new RuntimeException("Null tree");
        }
        Node cur = head;
        Node pre = null;
        while (cur != null) {
            pre = cur.left;
            if (pre != null) {
                //find the most right child
                while (pre.right != null && pre.right != cur) {
                    pre = pre.right;
                }
                if (pre.right == null) {
                    pre.right = cur;
                    cur = cur.left;
                    continue;
                } else {
                    pre.right = null;
                }
            }
            System.out.print(cur.val + " "); //中序的两个输出情况都在cur = cur.right之前
            cur = cur.right;
        }
        System.out.println();
    }
    
    public static void morrisPre(Node head) {
        if (head == null) {
            return;
        }
        Node cur = head;
        Node pre = null;
        while (cur != null) {
            pre = cur.left;
            if (pre != null) {
                while (pre.right != null && pre.right != cur) {
                    pre = pre.right;
                }
                if (pre.right == null) {
                    pre.right = cur;
                    System.out.print(cur.val + " ");
                    cur = cur.left;
                    continue;
                } else {
                    pre.right = null;
                }
            } else {
                System.out.print(cur.val + " ");
            }
            cur = cur.right;
        }
        System.out.println();
    }
    
    public static void morrisPost(Node head) {
        if (head == null) {
            return;
        }
        Node cur = head;
        Node pre = null;
        while (cur != null) {
            pre = cur.left;
            if (pre != null) {
                while (pre.right != null && pre.right != cur) {
                    pre = pre.right;
                }
                if(pre.right == null){
                    pre.right = cur;
                    cur = cur.left;
                    continue;
                }else{
                    pre.right = null;
                    printPath(cur.left);
                }
            }
            cur = cur.right;
        }
        printPath(head);
        System.out.println();
    }
    private static void printPath(Node head){
        Node end = reversePath(head);
        Node cur = end;
        while(cur != null){
            System.out.print(cur.val + " ");
            cur = cur.right;
        }
        reversePath(end);
    }
    private static Node reversePath(Node head){
        Node pre = null;
        Node next = null;
        while(head != null){
            next = head.right;
            head.right = pre;
            pre = head;
            head = next;
        }
        return pre;
    }
    public static void main(String[] args) {
        Node head = new Node(4);
        head.left = new Node(2);
        head.right = new Node(6);
        head.left.left = new Node(1);
        head.left.right = new Node(3);
        head.right.left = new Node(5);
        
        morrisIn(head);
        morrisPre(head);
        morrisPost(head);
    }
}
