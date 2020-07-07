package class_08;
/**
 * @Title : 牛的数量
 * @Author : Garen Hou
 * @Email : garen2994@hotmail.com
 * @Date : 2020/7/7 10:58
 */
public class Code_05_Cow {
	/**
	 * @description 递归 O(N)
	 * @param n
	 * @return int
	 */
	public static int cowNumber1(int n) {
		if (n < 1) {
			return 0;
		}
		if (n == 1 || n == 2 || n == 3) {
			return n;
		}
		return cowNumber1(n - 1) + cowNumber1(n - 3);
	}
	/**
	 * @description
	 * @param n
	 * @return int
	 */
	public static int cowNumber2(int n) {
		if (n < 1) {
			return 0;
		}
		if (n == 1 || n == 2 || n == 3) {
			return n;
		}
		int res = 3;
		int pre = 2;
		int prepre = 1;
		int tmp1 = 0;
		int tmp2 = 0;
		for (int i = 4; i <= n; i++) {
			tmp1 = res;
			tmp2 = pre;
			res = res + prepre;
			pre = tmp1;
			prepre = tmp2;
		}
		return res;
	}

	public static void main(String[] args) {
		int n = 20;
		System.out.println(cowNumber1(n));
		System.out.println(cowNumber2(n));
	}

}
