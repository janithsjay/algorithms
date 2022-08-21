package org.janithsjay.sorting.mergesort;

import org.janithsjay.sorting.Sorter;

public class MergeSort extends Sorter {
    @Override
    public int[] sort(int[] arr) {
        sort(arr, 0, arr.length-1);
        return arr;
    }

    public void sort(int[] arr, int firstIndex, int lastIndex) {
        double startMils = System.currentTimeMillis();
        if(firstIndex < lastIndex){
            int middle = (firstIndex + lastIndex)/2;
            sort(arr, firstIndex, middle);
            sort(arr, middle+1, lastIndex);
            merge(arr,firstIndex,lastIndex,middle);
            double endMils = System.currentTimeMillis();
        }
    }

    private void merge(int[] arr, int firstIndex, int lastIndex, int middle) {
        int leftArrSize = middle - firstIndex + 1;
        int rightArrSize = lastIndex - middle;

        int[] leftArr = new int[leftArrSize];
        int[] rightArr = new int[rightArrSize];


        for (int i=0; i<leftArrSize; i++) {
            leftArr[i] = arr[firstIndex + i];
        }

        for (int i=0; i<rightArrSize; i++) {
            rightArr[i] = arr[middle + i + 1];
        }

        int i = 0, j = 0, k = 0;
        while(i < leftArrSize && j < rightArrSize){
            if(leftArr[i] < rightArr[j]){
                arr[k] = leftArr[i];
                i++;
            }else if(leftArr[i] > rightArr[j]){
                arr[k] = rightArr[j];
                j++;
            }
            k++;
        }
    }
}
