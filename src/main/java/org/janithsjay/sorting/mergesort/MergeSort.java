package org.janithsjay.sorting.mergesort;

import org.janithsjay.sorting.Sorter;

public class MergeSort extends Sorter {
    @Override
    public int[] sort(int[] arr) {
        double startMils = System.currentTimeMillis();
        int[] res=sort(arr, 0, arr.length-1);
        double endMils = System.currentTimeMillis();
        printResults(res,startMils,endMils);
        return arr;
    }

    public int[] sort(int[] arr, int firstIndex, int lastIndex) {
        if(firstIndex < lastIndex){
            int middle = (firstIndex + lastIndex)/2;
            sort(arr, firstIndex, middle);
            sort(arr, middle+1, lastIndex);
            return merge(arr,firstIndex,lastIndex,middle);
        }else {
            return arr;
        }
    }

    private int[] merge(int[] arr, int firstIndex, int lastIndex, int middle) {
        int leftArrSize = (middle - firstIndex) + 1;
        int rightArrSize = lastIndex - middle;

        int[] leftArr = new int[leftArrSize];
        int[] rightArr = new int[rightArrSize];


        for (int i=0; i<leftArrSize; i++) {
            leftArr[i] = arr[firstIndex + i];
        }

        for (int i=0; i<rightArrSize; i++) {
            rightArr[i] = arr[middle + i + 1];
        }

        log.info("{} {}", leftArr, rightArr);

        int i = 0, j = 0, k = firstIndex;

        while(i < leftArrSize && j < rightArrSize){
            if(leftArr[i] < rightArr[j] && i < leftArrSize){
                arr[k] = leftArr[i];
                i++;
            }else{
                arr[k] = rightArr[j];
                j++;
            }
            k++;
        }
        while (i < leftArrSize) {
            arr[k] = leftArr[i];
            i++;
            k++;
        }

        /* Copy remaining elements of R[] if any */
        while (j < rightArrSize) {
            arr[k] = rightArr[j];
            j++;
            k++;
        }
        log.info("{}", arr);
        return arr;
    }
}
