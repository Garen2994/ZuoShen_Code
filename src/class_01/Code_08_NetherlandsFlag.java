package class_01;

import java.util.Arrays;

/**
 * @Title : 荷兰国旗问题(Partition算法)
 * @Author : Garen Hou
 * @Email : garen2994@hotmail.com
 * @Date :  2020/3/20 21:07
 */
public class Code_08_NetherlandsFlag {
    
    public static int[] partition(int[] arr, int l, int r, int p) {
        int less = l - 1; //初始化less区域的边界
        int more = r + 1; //初始化more区域的边界
        while (l < more) {
            if (arr[l] < p) {
                swap(arr, ++less, l++);
            } else if (arr[l] > p) {
                swap(arr, --more, l);
            } else {
                l++;
            }
        }
        return new int[]{less + 1, more - 1};   //返回区域分界的数组
    }
    
    private static void swap(int[] arr, int i, int j) {
        arr[i] = arr[i]^arr[j];
        arr[j] = arr[i]^arr[j];
        arr[i] = arr[i]^arr[j];
    }
    
    // for test
    
    // for test
    public static int[] generateArray() {
        int[] arr = new int[10];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (Math.random() * 3);
        }
        return arr;
    }
    
    // for test
    public static void printArray(int[] arr) {
        if (arr == null) {
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
    
    public static void main(String[] args) {
        int[] test = generateArray();
        
        printArray(test);
        int[] res = partition(test, 0, test.length - 1, 1);
        printArray(test);
        System.out.println(Arrays.toString(res));
        System.out.println(res[0]);
        System.out.println(res[1]);
        
    }
}
