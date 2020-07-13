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
//            int p = partition(arr, l, r);
            int[] p = partition3Way(arr, l, r);
            quickSort(arr, l, p[0]);
            quickSort(arr, p[1], r);
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
    public int[] partition3Way(int[] arr, int l,int r){
        swap(arr,l,l+(int)(Math.random() * (r - l + 1)));
        int key = arr[l];
        int lt = l; // arr[l+1...lt] < v
        int gt = r + 1; //arr[gt...r] > v
        int i = l + 1;//arr[lt+1...i] = v
        while(i < gt){
            if(arr[i] < key){
                swap(arr, i++,++lt);
            } else if(arr[i] > key){
                swap(arr,i,--gt);
            } else{
                i++;
            }
        }
        swap(arr, l, lt);
        
        return new int[]{lt, gt};
    }
    public void swap(int[] arr, int i, int j){
        if(i == j){
            return;
        }
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
