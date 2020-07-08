package class_01;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class quickSort_Test {
    @Test
    public void Test(){
        QuickSort_practice1 sort1 = new QuickSort_practice1();
        int[] arr = {4,8,12,5,9,32,-5};
        sort1.quickSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
