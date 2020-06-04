package class_04;

import java.util.LinkedList;
import java.util.Queue;
/**
 * @Title : 验证二叉搜索树以及完全二叉树
 * @Author : garen_hou
 * @Email : garen2994@hotmail.com
 * @Date :  2020/5/14 2:03 上午
 */
public class Code_07_IsBSTAndCBT {

	public static class Node {
		public int value;
		public Node left;
		public Node right;

		public Node(int data) {
			this.value = data;
		}
	}
	/**
	 * @description 是否是二叉搜索树
	 * @param head
	 * @return boolean
	 */
	public static boolean isBST(Node head) {
		if (head == null) {
			return true;
		}
		//Morris遍历方法
		boolean res = true;
		Node pre = null;
		Node cur1 = head;
		Node cur2 = null;
		while (cur1 != null) {
			cur2 = cur1.left;
			if (cur2 != null) {
				while (cur2.right != null && cur2.right != cur1) {
					cur2 = cur2.right;
				}
				if (cur2.right == null) {
					cur2.right = cur1;
					cur1 = cur1.left;
					continue;
				} else {
					cur2.right = null;
				}
			}
			if (pre != null && pre.value > cur1.value) {
				res = false;
			}
			pre = cur1;
			cur1 = cur1.right;
		}
		return res;
	}

	public static boolean isCBT(Node head) {
		if (head == null) {
			return true;
		}
		Queue<Node> queue = new LinkedList<>();//层序遍历
		boolean leaf = false; //开启验证是否叶节点阶段
		Node lNode = null;
		Node rNode = null;
		queue.offer(head);
		while (!queue.isEmpty()) {
			head = queue.poll();
			lNode = head.left;
			rNode = head.right;
			if((leaf && (lNode != null || rNode != null ))
				|| (lNode == null && rNode != null)){
				return false;
			}
			if(lNode != null){
				queue.offer(lNode);
			}
			if(rNode != null){
				queue.offer(rNode);
			}else{	//这种情况只能是(lNode != null && rNode == null)
				leaf = true; //开启叶节点验证
			}
		}
		return true;
	}

	// for test -- print tree
	public static void printTree(Node head) {
		System.out.println("Binary Tree:");
		printInOrder(head, 0, "H", 17);
		System.out.println();
	}

	public static void printInOrder(Node head, int height, String to, int len) {
		if (head == null) {
			return;
		}
		printInOrder(head.right, height + 1, "v", len);
		String val = to + head.value + to;
		int lenM = val.length();
		int lenL = (len - lenM) / 2;
		int lenR = len - lenM - lenL;
		val = getSpace(lenL) + val + getSpace(lenR);
		System.out.println(getSpace(height * len) + val);
		printInOrder(head.left, height + 1, "^", len);
	}

	public static String getSpace(int num) {
		String space = " ";
		StringBuffer buf = new StringBuffer("");
		for (int i = 0; i < num; i++) {
			buf.append(space);
		}
		return buf.toString();
	}

	public static void main(String[] args) {
		Node head = new Node(4);
		head.left = new Node(2);
		head.right = new Node(6);
		head.left.left = new Node(1);
		head.left.right = new Node(3);
		head.right.right = new Node(5);

		printTree(head);
		System.out.println(isBST(head));
		System.out.println(isCBT(head));

	}
}