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
        System.out.println("请输入需要查询的斐波那契数列项：");
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        System.out.println("第" + n + "项为: " + getCount(n));
    }

        public static int getCount(int n) {
        if (n < 1) {
            return 0;
        } else if (n <= 2){
            return 1;
        } else {
            int[][] base = {{1, 1}, {1, 0}};    //基础矩阵
            int[][] res = matrixPower(base, n - 2); //斐波那契数列f(n)，f(n-1)是(1,1)与{{1，1}，{1，0}}的n-2次幂
            return res[0][0] + res[1][0];    //第一列的两项之和为f(n)的值
        }
    }

    public static int[][] matrixPower(int[][] m, int p) {
        if (p == 0) {    //异常情况，应该不存在
            return null;
        } else if (p == 1) {    //求矩阵m的一次方就是其本身
            return m;
        } else {    //到了这里意味着矩阵的幂不止2次，但是有可能是奇数也可能是偶数
            int[][] res = matrixPower(m, p >> 1);    //p>>1代表着左移一位，数值作用就是除以2，矩阵少平方了一次
            res = muliMatrix(res, res);        //前面除以2，这边就让自己与自己相乘以抵消之前的操作，也避免了重复的乘法
            if ((p % 2) == 1) { //如果p是个奇数，左移的过程中就使得乘法少了一次
                res = muliMatrix(res, m);
            }
            return res;
        }
    }

    public static int[][] muliMatrix(int[][] m1, int[][] m2) {
        int[][] res = new int[m1.length][m2[0].length];    //为了通用性，这里结果矩阵的行列都依据传进来的矩阵取值
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