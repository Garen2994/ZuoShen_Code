package class_04;
/**
 * @Title : 在二叉树中找到一个节点的前驱节点
 * @Author : garen_hou
 * @Email : garen2994@hotmail.com
 * @Date :  2020/4/23 1:00 上午
 */
public class Code_03_PrecursorNode {

	public static class Node {
		public int value;
		public Node left;
		public Node right;
		public Node parent;

		public Node(int data) {
			this.value = data;
		}
	}
	/**
	 * @description 获得前驱节点
	 * @param node
	 * @return class_04.Code_03_PrecursorNode.Node
	 */
	public static Node getPrecursorNode(Node node) {
		if (node == null) {
			return node;
		}
		//有左子树的情况：后继节点为左子树上最右节点
		if (node.left != null) {
			return getRightMost(node.left);
		} else {	//没有左子树的情况：向上遍历，直到当前节点是其父节点的左孩子时结束
			Node parent = node.parent;
			while (parent != null && parent.right != node) {
				node = parent;
				parent = node.parent;
			}
			return parent;
		}
	}
	/**
	 * @description 获取当前子树最右的节点
	 * @param node
	 * @return class_04.Code_03_SuccessorNode.Node
	 */
	public static Node getRightMost(Node node) {
		if (node == null) {
			return node;
		}
		while (node.right != null) {
			node = node.right;
		}
		return node;
	}

	public static void main(String[] args) {
		Node head = new Node(6);
		head.parent = null;
		head.left = new Node(3);
		head.left.parent = head;
		head.left.left = new Node(1);
		head.left.left.parent = head.left;
		head.left.left.right = new Node(2);
		head.left.left.right.parent = head.left.left;
		head.left.right = new Node(4);
		head.left.right.parent = head.left;
		head.left.right.right = new Node(5);
		head.left.right.right.parent = head.left.right;
		head.right = new Node(9);
		head.right.parent = head;
		head.right.left = new Node(8);
		head.right.left.parent = head.right;
		head.right.left.left = new Node(7);
		head.right.left.left.parent = head.right.left;
		head.right.right = new Node(10);
		head.right.right.parent = head.right;

		Node test = head.left.left;	//1's pre is null
		System.out.println(test.value + " pre: " + getPrecursorNode(test));
		test = head.left.left.right;
		System.out.println(test.value + " pre: " + getPrecursorNode(test).value);
		test = head.left;
		System.out.println(test.value + " pre: " + getPrecursorNode(test).value);
		test = head.left.right;
		System.out.println(test.value + " pre: " + getPrecursorNode(test).value);
		test = head.left.right.right;
		System.out.println(test.value + " pre: " + getPrecursorNode(test).value);
		test = head;
		System.out.println(test.value + " pre: " + getPrecursorNode(test).value);
		test = head.right.left.left;
		System.out.println(test.value + " pre: " + getPrecursorNode(test).value);
		test = head.right.left;
		System.out.println(test.value + " pre: " + getPrecursorNode(test).value);
		test = head.right;
		System.out.println(test.value + " pre: " + getPrecursorNode(test).value);
		test = head.right.right;
		System.out.println(test.value + " pre: " + getPrecursorNode(test).value);
	}

}
