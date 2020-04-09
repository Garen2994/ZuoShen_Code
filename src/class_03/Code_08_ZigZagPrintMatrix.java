package class_03;
	/**
	 * @Title : 宏观调度思想的问题之四：之字形打印矩阵
	 * @Author : Garen Hou
	 * @Email : garen2994@hotmail.com
	 * @Date :  2020/4/3 23:51
	 */
public class Code_08_ZigZagPrintMatrix {
	

	public static void printMatrixZigZag(int[][] matrix) {
		//初始化两个点 A,B
		int tR = 0;
		int tC = 0;
		int dR = 0;
		int dC = 0;
		int endR = matrix.length - 1;
		int endC = matrix[0].length - 1;
		//从上往下还是从下往上打印 每次反转
		boolean fromUp = false;
		while (tR != endR + 1) {
			printLevel(matrix, tR, tC, dR, dC, fromUp);
			//A行数变化
			tR = tC == endC ? tR + 1 : tR;
			//A列数变化
			tC = tC == endC ? tC : tC + 1;
			//B行数变化
			dC = dR == endR ? dC + 1 : dC;
			//B列数变化
			dR = dR == endR ? dR : dR + 1;
			//反转打印顺序
			fromUp = !fromUp;
		}
		System.out.println();
	}

	public static void printLevel(int[][] m, int tR, int tC, int dR, int dC,
			boolean f) {
		if (f) {
			while (tR != dR + 1) {
				System.out.print(m[tR++][tC--] + " ");
			}
		} else {
			while (dR != tR - 1) {
				System.out.print(m[dR--][dC++] + " ");
			}
		}
	}

	public static void main(String[] args) {
		int[][] matrix = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 } };
		printMatrixZigZag(matrix);

	}

}
