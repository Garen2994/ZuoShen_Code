package class_07;

import java.util.Arrays;
import java.util.Comparator;
/**
 * @Title : 排项目(贪心)
 * @Author : Garen Hou
 * @Email : garen2994@hotmail.com
 * @Date : 2020/7/6 14:51
 */
public class Code_06_BestArrange {

	public static class Program {
		public int start;
		public int end;

		public Program(int start, int end) {
			this.start = start;
			this.end = end;
		}

		public void addPro(int start, int end){
			this.start = start;
			this.end = end;
		}
	}
	/**
    * @description 每次找到最早结束时间的项目
    * @param null
    * @return
    */
	public static class ProgramComparator implements Comparator<Program> {

		@Override
		public int compare(Program o1, Program o2) {
			return o1.end - o2.end;
		}
	}

	public static int bestArrange(Program[] programs, int start) {
		Arrays.sort(programs, new ProgramComparator());
		int result = 0;
		for (int i = 0; i < programs.length; i++) {
			if (start <= programs[i].start) {
				result++;
				start = programs[i].end;
			}
		}
		return result;
	}

	public static void main(String[] args) {
		Program[] pros = new Program[5];
		pros[0] = new Program(1,3);
		pros[1] = new Program(2,4);
		pros[2] = new Program(4,7);
		pros[3] = new Program(6,8);
		pros[4] = new Program(8,10);
		int maxArrange = bestArrange(pros, 0);
		System.out.println("最大项目数: " + maxArrange);
	}

}
