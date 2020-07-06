package class_08;
/**
 * @Title : Hanota 汉诺塔问题
 * @Author : Garen Hou
 * @Email : garen2994@hotmail.com
 * @Date : 2020/7/6 21:35
 */
public class Code_02_Hanota {

	public static void hanota(int n) {
		if (n > 0) {
			process(n, n, "left", "mid", "right");
		}
	}

	public static void process(int rest, int down, String from, String help, String to) {
		if (rest == 1) {
			System.out.println("move " + down + " from " + from + " to " + to);
		} else {
			process(rest - 1, down - 1, from, to, help); // 1~n-1移到help
			process(1,down, from, help, to);//n移到to
			process(rest - 1,down - 1, help, from, to);//1~n-1 移到to
		}
	}

	public static void moveLeftToRight(int N) {
		if (N == 1) {
			System.out.println("move 1 from left to right");
		}
		moveLeftToMid(N - 1);
		System.out.println("move " + N + "from left to right");
		moveMidToRight(N - 1);
	}

	public static void moveRightToLeft(int N) {

	}

	public static void moveLeftToMid(int N) {
		if (N == 1) {
			System.out.println("move 1 from left to mid");
		}
		moveLeftToRight(N - 1);
		System.out.println("move " + N + "from left to mid");
		moveRightToMid(N - 1);
	}

	public static void moveMidToLeft(int N) {

	}

	public static void moveRightToMid(int N) {

	}

	public static void moveMidToRight(int N) {
		if (N == 1) {
			System.out.println("move 1 from mid to right");
		}
		moveMidToLeft(N - 1);
		System.out.println("move " + N + "from mid to right");
		moveLeftToRight(N - 1);
	}

	public static void main(String[] args) {
		int n = 3;
		hanota(n);
	}

}
