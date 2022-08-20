package org.janithsjay.sorting.selectionsort;

import org.janithsjay.sorting.Sorter;

public class SelectionSort extends Sorter {
    @Override
    public int[] sort(int[] arr) {
        return sortByMin(arr);
    }
    @SuppressWarnings("DuplicateBranchesInSwitch")
    public int[] sort(int[] arr, String sortBy){
        switch (sortBy){
            case SORT_BY_MAX: return sortByMax(arr);
            case SORT_BY_MIN: return sortByMin(arr);
            default: return sortByMax(arr);
        }
    }

    private int[] sortByMin(int[] arr){
        double startMils = System.currentTimeMillis();
        log.debug("{}: {}", "Original", arr);
        for(int i=0; i<=arr.length-2; i++){
            int minIndex=i;
            for (int j=i+1; j<=arr.length-1; j++){
                if(arr[j]<arr[minIndex]){
                    minIndex=j;
                }
            }
            arr=swap(arr, i, minIndex);
            log.debug("Step {}: {}", i+1, arr);
        }
        double endMils = System.currentTimeMillis();
        printResults(arr, startMils, endMils);
        return arr;
    }

    private int[] sortByMax(int[] arr){
        double startMils = System.currentTimeMillis();
        log.debug("{}: {}", "Original", arr);
        for (int i=0; i<=arr.length-2; i++){
            int maxIndex= arr.length-1-i;
            for (int j=0; j<=arr.length-2-i; j++){
                if(arr[maxIndex]<arr[j]){
                    maxIndex=j;
                }
            }
            swap(arr, maxIndex, arr.length-1-i);
            log.debug("Step {}: {}", i+1, arr);
        }
        double endMils = System.currentTimeMillis();
        printResults(arr, startMils, endMils);
        return arr;
    }
}
