//Quick Sort - Java implementation
public class QuickSort {
    //Quick Sort
    public void quickSort(int[] arr){
        int[] cArr = arr.clone();
        quickSort(arr,0,cArr.length-1);
    }
    public void quickSort(int[] arr, int start, int end){
        if(start >= end)
            return;
        int pivot = partition(arr,start,end);
        quickSort(arr,start,pivot-1);
        quickSort(arr,pivot+1,end);

    }
    public int partition(int[] arr, int start, int end){
        int pivot = arr[end];
        int i = start;
        for(int j = start;j<=end;j++){
            if(arr[j] < pivot){
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                i++;
            }
        }
        int temp = arr[i];
        arr[i] = arr[end];
        arr[end] = temp;
        return i;
    }
}