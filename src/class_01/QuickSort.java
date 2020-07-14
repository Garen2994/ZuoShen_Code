package class_01;
/**
 * @Title : ****快速排序****
 * @Author : Garen Hou
 * @Email : garen2994@hotmail.com
 * @Date :  2020/3/13 19:02
 */
public class QuickSort {
    public void quickSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        quickSort(arr, 0, arr.length - 1);
    }
    
    /**
     * @param arr
     * @param l
     * @param r
     * @return void
     * @description 随机快排
     */
    public void quickSort(int[] arr, int l, int r) {
        if (l < r) {
            swap(arr, l + (int) (Math.random() * (r - l + 1)), r);  //L到R随机选一个位置
            int[] p = partition(arr, l, r);
            quickSort(arr, l, p[0] - 1);
            quickSort(arr, p[1] + 1, r);
//            swap(arr, l, l + (int) (Math.random() * (r - l + 1)));  //L到R随机选一个位置
//            int p = partition2ways(arr, l, r);
//            quickSort(arr, l, p - 1);
//            quickSort(arr, p + 1, r);
        }
    }
    
    /**
     * @param arr
     * @param l
     * @param r
     * @return int
     * @description 二路快排（二分Partition）
     */
    public int partition2ways(int[] arr, int l, int r) {
//        int randomIndex = (int) (Math.random() * (r - l + 1) + l);
//        swap(arr, l, randomIndex);
        int key = arr[l];
        while (l < r) {
            // 当队尾的元素大于等于基准数据时,向前挪动high指针
            while (l < r && arr[r] > key) {
                r--;
            }
            // 如果队尾元素小于key了,需要将其赋值给low
            arr[l] = arr[r];
            // 当队首元素小于等于key时,向前挪动low指针
            while (l < r && arr[l] < key) {
                l++;
            }
            // 当队首元素大于key时,需要将其赋值给high
            arr[r] = arr[l];
        }
        // 跳出循环时low和high相等,此时的low或high就是tmp的正确索引位置
        arr[l] = key;
        return l;
    }
    
    /**
     * @description 三路快排（三分Partition）(这里将pivot放在了arr[r]的位置，移动时少用一个变量)
     * @param arr
     * @param l
     * @param r
     * @return int[]
     */
    public int[] partition(int[] arr, int l, int r) {
        int less = l - 1;
        int more = r;
        while (l < more) {
            if (arr[l] < arr[r]) {
                swap(arr, ++less, l++);
            } else if (arr[l] > arr[r]) {
                swap(arr, --more, l);
            } else {
                l++;
            }
        }
        swap(arr, more, r);
        return new int[]{less + 1, more};
    }
    
    private void swap(int[] arr, int i, int j) { //异或操作实现交换在两数相等时不适用
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
