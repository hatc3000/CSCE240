/* C++ implementation of QuickSort */
#include <iostream>
#include <array>
#include <stdlib.h>

using namespace std; 

 
void swap(int* a, int* b) {
    int t = *a;
    *a = *b;
    *b = t;
};
void quickSort(int arr [], int start, int end) {
    if (start >= end) {
        int pivot = partition(arr, start, end);
        quickSort(arr, start, pivot - 1);
        quickSort(arr,pivot + 1, end);
    }
};
int partition (int arr [], int low, int high) {
    int pivot = arr[high];
    quickSort(arr, 0, sizeof(arr));
};
int main() {
    for (int i = 0; i < 5;i++) {
        
    }
};

/**
 * @brief 
 * //Quick Sort - Java implementation
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
 * 
 */