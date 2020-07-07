package class_08;

import java.util.HashSet;
/**
 * @Title : 打印字符串的全部排列
 * @Author : Garen Hou
 * @Email : garen2994@hotmail.com
 * @Date : 2020/7/6 23:08
 */
public class Code_04_Print_All_Permutations {

	public static void printAllPermutations1(String str) {
		char[] chs = str.toCharArray();
		process1(chs, 0);
	}
	/**
	 * @Title : 有重复的排列
	 * @Author : Garen Hou
	 * @Email : garen2994@hotmail.com
	 * @Date : 2020/7/6 23:49
	 */
	public static void process1(char[] chs, int i) {
		if (i == chs.length) {
			System.out.println(String.valueOf(chs));
		}
		for (int j = i; j < chs.length; j++) {
			swap(chs, i, j);
			process1(chs, i + 1);
			//swap(chs, i, j);
		}
	}

	public static void printAllPermutations2(String str) {
		char[] chs = str.toCharArray();
		process2(chs, 0);
	}
	/**
	 * @description 带去重剪枝的全排列
	 * @param chs
	 * @param i
	 * @return void
	 */
	public static void process2(char[] chs, int i) {
		if (i == chs.length) {
			System.out.println(String.valueOf(chs));
		}
		//集合用来去除重复字符
		HashSet<Character> set = new HashSet<>();
		for (int j = i; j < chs.length; j++) {
			//去除重复字符-剪枝
			if (!set.contains(chs[j])) {
				set.add(chs[j]);
				swap(chs, i, j);
				process2(chs, i + 1);
				swap(chs, i, j);
			}
		}
	}

	public static void swap(char[] chs, int i, int j) {
		char tmp = chs[i];
		chs[i] = chs[j];
		chs[j] = tmp;
	}

	public static void main(String[] args) {
		String test1 = "abc";
		printAllPermutations1(test1);
		System.out.println("======");
		printAllPermutations2(test1);
		System.out.println("======");

		String test2 = "acc";
		printAllPermutations1(test2);
		System.out.println("======");
		printAllPermutations2(test2);
		System.out.println("======");
	}

}
