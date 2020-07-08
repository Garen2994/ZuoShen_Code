package class_01;
/**
 * @Title : 7.7手撸快排
 * @Author : garen_hou
 * @Email : garen2994@hotmail.com
 * @Date :  2020/7/7 8:59 下午
 */
public class QuickSort_1 {
    public static void quickSort_1(int[] arr){
        if(arr == null || arr.length <= 2) {
            return;
        }
        quickSort(arr,0,arr.length - 1);
    }
    public static void quickSort(int[] arr,int l,int r){
        if(l < r){
//            int p = partition(arr, l, r);
            int p = partitionTwoWay(arr, l, r);
            quickSort(arr,l,p - 1);
            quickSort(arr,p + 1, r);
        }
    }
    public static int partition(int[] arr, int l ,int r){
        swap(arr,l,l +(int)(Math.random()*(r - l + 1)));
        int j = l;
        int v = arr[l];
        for(int i = j + 1; i <= r; i++){
            if(arr[i] < v){
                j++;
                swap(arr,j,i);
            }
        }
        swap(arr,l,j);
        return j;
    }
    public static int partitionTwoWay(int[] arr, int l, int r){
        swap(arr,l,l + (int) Math.random() * (r-l+1));
        int v = arr[l];
        while(l < r){
            while(l < r && arr[l] < v){
                l++;
            }
            arr[r] = arr[l];
            while(l < r && arr[r] > v){
                r--;
            }
            arr[l] = arr[r];
        }
        arr[l] = v;
        return l;
    }
    private static void swap(int[] arr, int i, int j){
//        arr[i] = arr[i] ^ arr[j];
//        arr[j] = arr[i] ^ arr[j];
//        arr[i] = arr[i] ^ arr[j];
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
    
    public static void main(String[] args) {
        int[] arr = {4,6,2,3,1,10,7,8};
        quickSort_1(arr);
        for (int i : arr) {
            System.out.print(i+" ");
        }
    }
}
