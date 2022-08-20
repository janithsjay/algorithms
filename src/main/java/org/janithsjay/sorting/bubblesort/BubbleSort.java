package org.janithsjay.sorting.bubblesort;

import org.janithsjay.sorting.Sorter;
import org.slf4j.LoggerFactory;

public class BubbleSort extends Sorter {

    public BubbleSort(){
        log = LoggerFactory.getLogger(BubbleSort.class);
    }

    @Override
    public int[] sort(int[] arr){
        return sortByMax(arr);
    }

    @SuppressWarnings("DuplicateBranchesInSwitch")
    public int[] sort(int[] arr, String sortBy){
        switch (sortBy){
            case SORT_BY_MAX: return sortByMax(arr);
            case SORT_BY_MIN: return sortByMin(arr);
            default: return sortByMax(arr);
        }
    }

    private int[] sortByMax(int[] arr) {
        double startMils = System.currentTimeMillis();

        log.debug("{}: {}", "Original", arr);
        for(int i=0; i <= arr.length-2; i++){
            for (int j=0; j <= arr.length-2-i; j++){
                if( arr[j] > arr[j+1] ){
                    arr = super.swap(arr,j,j+1);
                }
            }
            log.debug("Step {}: {}", i+1, arr);
        }

        double endMils = System.currentTimeMillis();
        printResults(arr, startMils, endMils);
        return new int[0];
    }


    private int[] sortByMin(int[] arr){
        double startMils = System.currentTimeMillis();

        log.debug("{}: {}", "Original", arr);
        for(int i=0; i <= arr.length-2; i++){
            for(int j = arr.length-1; j >= 1 + i; j--){
                if(arr[j] < arr[j-1]){
                    arr = super.swap(arr,j,j-1);
                }
            }
            log.debug("Step {}: {}", i+1, arr);
        }
        double endMils = System.currentTimeMillis();
        printResults(arr, startMils, endMils);
        return arr;
    }

}
