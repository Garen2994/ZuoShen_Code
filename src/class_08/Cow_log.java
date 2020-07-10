package class_08;

import java.util.Scanner;
/**
 * @Title : O(logn)复杂度 -- 矩阵乘法
 * @Author : Garen Hou
 * @Email : garen2994@hotmail.com
 * @Date : 2020/7/7 14:23
 */
public class Cow_log {
    public static void main(String[] args) {
        System.out.println("请输入要查询第几年牛的数量 ：");
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        System.out.println("第" + n + "年有牛: " + getCount(n) + " 头 ");
    }

        public static int getCount(int n) {
        if (n < 1) {
            return 0;
        } else if (n <= 3){
            return n;
        } else {
            int[][] base = {{1, 1, 0}, {0, 0, 1}, {1, 0, 0}};    //基础矩阵
            int[][] res = matrixPower(base, n - 3);
            return 3 * res[0][0] + 2 * res[1][0] + res[2][0];
        }
    }

    public static int[][] matrixPower(int[][] m, int p) {
        if (p == 0) {
            return null;
        } else if (p == 1) {
            return m;
        } else {
            int[][] res = matrixPower(m, p >> 1);
            res = muliMatrix(res, res);
            if ((p & 1) != 0) {
                res = muliMatrix(res, m);
            }
            return res;
        }
    }

    public static int[][] muliMatrix(int[][] m1, int[][] m2) {
        int[][] res = new int[m1.length][m2[0].length];
        for (int i = 0; i < m1.length; i++) {
            for (int j = 0; j < m2[0].length; j++) {
                for (int k = 0; k < m2.length; k++) {
                    res[i][j] += m1[i][k] * m2[k][j];
                }
            }
        }
        return res;
    }
}