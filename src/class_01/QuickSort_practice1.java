package class_01;

public class QuickSort_practice1 {
    public void quickSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        quickSort(arr, 0, arr.length - 1);
    }
    public void quickSort(int[] arr,int l, int r){
        if(l < r) {
//            int p = partition2Way(arr, l, r);
            int p = partition(arr, l, r);
            quickSort(arr, l, p - 1);
            quickSort(arr, p + 1, r);
        }
    }
    public int partition(int[] arr,int l,int r){
        swap(arr, l, l + (int)(Math.random() * (r - l + 1)));
        int key = arr[l];
        int j = l;
        for (int i = j + 1; i <= r ; i++) {
            if(arr[i] < key){
                j++;
                swap(arr, i, j);//直接与边界交换
            }
        }
        swap(arr,l,j);
        return j;
    }

    public int partition2Way(int[] arr, int l, int r){
        swap(arr, l, l + (int)(Math.random()*(r - l + 1)));
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
        arr[l] = key;
        return l ;
    }
//    public int partition3Way(int[] arr, int l,int r){
//        swap(arr,l,l+(int)(Math.random() * (r - l + 1)));
//        int less =
//    }
    public void swap(int[] arr, int i, int j){
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
