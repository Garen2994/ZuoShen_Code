package class_04;

import org.junit.jupiter.api.Test;

public class SerialTest {
    @Test
    public void TreeToStringTest(){
        TreeToString tree = new TreeToString();
        TreeToString.TreeNode root = new TreeToString.TreeNode(1);
        root.left = new TreeToString.TreeNode(2);
        root.right = new TreeToString.TreeNode(3);
        root.left.left = new TreeToString.TreeNode(4);
        root.right.right = new TreeToString.TreeNode(5);
        String s = tree.toString(root);
        System.out.println(s);
        TreeToString.TreeNode treeNode = tree.deSerialize(s);
        System.out.println(treeNode.left);
        System.out.println(treeNode.right);
    }
}
