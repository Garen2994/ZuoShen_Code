package class_01;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class quickSort_Test {
    @Test
    public void Test(){
        QuickSort_practice1 sort1 = new QuickSort_practice1();
        int[] arr = {11,8,12,5,9,32,6};
        sort1.quickSort(arr);
        System.out.println(Arrays.toString(arr));
    }
    @Test
    public void Test_2(){
        int[] arr = {3,8,6,-5,5,-4,5,-5,1,3,-1,6,-5,8,10,6};
        QuickSort qs = new QuickSort();
        qs.quickSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
