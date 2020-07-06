package class_08;

import java.util.ArrayList;
import java.util.List;
/**
 * @Title : 打印一个字符串的全部子序列，包括空字符串
 * @Author : Garen Hou
 * @Email : garen2994@hotmail.com
 * @Date : 2020/7/6 22:54
 */
public class Code_03_Print_All_Subsquences {

	public static void printAllSubsquence(String str) {
		char[] chs = str.toCharArray();
		process(chs, 0, "");
	}

	public static void process(char[] chs, int i, String str) {
		if (i == chs.length) {
			System.out.println(str);
			return;
		}
		process(chs, i + 1, str + String.valueOf(chs[i]));
		process(chs, i + 1, str);

//		if (i == chs.length) {
//			System.out.println(String.valueOf(chs));
//			return;
//		}
//		process(chs, i + 1);
//		char tmp = chs[i];
//		chs[i] = 0;
//		process(chs, i + 1);
//		chs[i] = tmp;
	}
	
	public static void function(String str) {
		char[] chs = str.toCharArray();
		process(chs, 0, new ArrayList<Character>());
	}
	
	public static void process(char[] chs, int i, List<Character> res) {
		if(i == chs.length) {
			printList(res);
		}
		List<Character> resKeep = copyList(res);
		resKeep.add(chs[i]);
		process(chs, i+1, resKeep);
		List<Character> resNoInclude = copyList(res);
		process(chs, i+1, resNoInclude);
	}
	
	public static void printList(List<Character> res) {
		// ...;
	}
	
	public static List<Character> copyList(List<Character> list){
		return null;
	}
	

	public static void main(String[] args) {
		String test = "abc";
		printAllSubsquence(test);
	}

}
