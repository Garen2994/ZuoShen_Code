package class_01;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
/**
 * @Title : 逆序对问题的变形（输出每个元素对应的逆序对个数）---索引数组
 * @Author : garen_hou
 * @Email : garen2994@hotmail.com
 * @Date :  2020/4/30 12:21 上午
 */
public class ReverseNum {
    /**
     * @param nums
     * @return java.util.List<java.lang.Integer>
     * @description //逆序对的拓展-（关键问题在于如何定位元素）
     */
    public List<Integer> countSmaller(int[] nums) {
        int[] res = new int[nums.length];
        if (nums == null) {
            return Arrays.stream(res).boxed().collect(Collectors.toList());
        }
        
        int[] indexs = IntStream.range(0, nums.length).toArray(); //索引数组
        int[] count = new int[nums.length];
        
        mergeSort(nums, 0, nums.length - 1, indexs, res);
        return Arrays.stream(res).boxed().collect(Collectors.toList()); //费时？
    }
    
    private void mergeSort(int[] nums, int l, int r, int[] indexs, int[] count) {
        if (l == r) {
            return;
        }
        int mid = l + ((r - l) >> 1);
        mergeSort(nums, l, mid, indexs, count);
        mergeSort(nums, mid + 1, r, indexs, count);
        merge(nums, l, mid, r, indexs, count);
    }
    
    private void merge(int[] nums, int l, int m, int r, int[] indexs, int[] count) {
        int[] temp = new int[indexs.length];
        int[] copy = new int[nums.length];
        int p1 = l;
        int p2 = m + 1;
        int i = l;
        while (i <= r) {
            while (p1 <= m && p2 <= r) {
                if (nums[p1] > nums[p2]) {
                    //update index array
                    temp[i] = indexs[p2];
                    copy[i++] = nums[p2++];
                } else {
                    count[indexs[p1]] += p2 - m - 1;
                    temp[i] = indexs[p1];
                    copy[i++] = nums[p1++];
                }
            }
            while (p2 <= r) {
                count[indexs[p2]] += p1 - m - 1;
                temp[i] = indexs[p2];
                copy[i++] = nums[p2++];
            }
            while (p1 <= m) {
                count[indexs[p1]] += p2 - m - 1;
                temp[i] = indexs[p1];
                copy[i++] = nums[p1++];
            }
        }
        System.arraycopy(temp, l, indexs, l, r - l + 1);
        System.arraycopy(copy, l, nums, l, r - l + 1);
    }
}