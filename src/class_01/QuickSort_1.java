package class_01;
/**
 * @Title : 7.7手撸快排
 * @Author : garen_hou
 * @Email : garen2994@hotmail.com
 * @Date :  2020/7/7 8:59 下午
 */
public class QuickSort_1 {
    public static void quickSort_1(int[] arr){
        if(arr == null || arr.length < 2){
            throw new RuntimeException("Wrong array");
        }
        quickSort(arr, 0 ,arr.length - 1);
    }
    public static void quickSort(int[] arr, int l , int r){
        if(l < r){
//            int p = partition(arr, l, r);
//            int p = partition2Way(arr, l, r);
            int[] p = partition3Way(arr, l, r);
            quickSort(arr,l,p[0]);
            quickSort(arr,p[1], r);
            
//            quickSort(arr,l,p - 1);
//            quickSort(arr,p + 1, r);
        }
    }
    private static int partition(int[] arr,int l, int r){
        swap(arr,l,l+(int)(Math.random()*(r - l + 1)));
        int key = arr[l];
        int j = l;
        for (int i = j + 1; i <= r; i++) {
            if(arr[i] < key){
                swap(arr, i, ++j);
            }
        }
        swap(arr, j, l);
        return j;
    }
    public static int partition2Way(int[] arr,int l, int r){
        swap(arr,l,l+(int)(Math.random() * (r - l + 1)));
        int key = arr[l];
        while(l < r){
            while(l < r && arr[r] >= key){
                r--;
            }
            arr[l] = arr[r];
            while(l < r && arr[l] <= key){
                l++;
            }
            arr[r] = arr[l];
        }
        //此时l和r相遇
        arr[l] = key;
        return l;
    }
    public static int[] partition3Way(int[] arr,int l, int r){
        swap(arr,l,l + (int)(Math.random() * (r - l + 1)));
        int key = arr[l];
        int lt = l;  //arr[l+1 , lt] < key
        int gt = r + 1; // arr[gt + 1,r] > key
        int i = l + 1; // arr[lt+1, i] = key
        while(i < gt){
            if(arr[i] < key){
                swap(arr,i++,++lt);
            }else if(arr[i] > key){
                swap(arr, i, --gt);
            }else{
                i++;
            }
        }
        swap(arr,l,lt);
        return new int[]{lt, gt};
    }
    private static void swap(int[] arr, int i ,int j){
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    
    }
    public static void main(String[] args) {
        int[] arr = {4,6,4,5,6,-2,1,7,-2,3,1,10,7,8};
        quickSort_1(arr);
        for (int i : arr) {
            System.out.print(i+" ");
        }
    }
}
