package class_04;
/**
 * @Title : 判断一棵树是否是平衡树
 * @Author : garen_hou
 * @Email : garen2994@hotmail.com
 * @Date :  2020/4/30 12:37 上午
 */
public class Code_06_IsBalancedTree {

	public static class Node {
		public int value;
		public Node left;
		public Node right;
		public Node(int data) {
			this.value = data;
		}
	}

	public static boolean isBalance(Node head) {
		boolean[] res = new boolean[1];
		res[0] = true;
		getHeight(head, 0, res);
		return res[0];
	}
	/**
	 * @description 递归获取树的高度
	 * @param head
	 * @param level
	 * @param res
	 * @return int
	 */
	public static int getHeight(Node head, int level, boolean[] res) {
		if (head == null) {
			return level;
		}
		int lH = getHeight(head.left, level + 1, res);
		if (!res[0]) {
			return level;
		}
		int rH = getHeight(head.right, level + 1, res);
		if (!res[0]) {
			return level;
		}
		if (Math.abs(lH - rH) > 1) {
			res[0] = false;
		}
		return Math.max(lH, rH);
	}
	public static void main(String[] args) {
		Node head = new Node(3);
		head.left = new Node(9);
		head.right = new Node(20);
		head.left.left = null;
		head.left.right = null;
		head.right.left = new Node(5);
		head.right.right = new Node(7);

		System.out.println(isBalance(head));

	}

}
