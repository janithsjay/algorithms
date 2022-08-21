package org.janithsjay.sorting.insertionsort;

import org.janithsjay.sorting.Sorter;
import org.slf4j.LoggerFactory;

public class InsertionSort extends Sorter {

    public InsertionSort(){
        log = LoggerFactory.getLogger(InsertionSort.class);
    }

    @Override
    public int[] sort(int[] arr) {
        log.debug("{}: {}", "Original", arr);
        double startMils = System.currentTimeMillis();
        for (int i=0; i<arr.length; i++){
            int current=arr[i];
            int j;
            for(j=i-1; j>=0 && arr[j] > current; j--){
                arr[j+1]=arr[j];
            }
            arr[j+1]=current;
            log.debug("Step {}: {}", i+1, arr);
        }
        double endMils = System.currentTimeMillis();
        printResults(arr, startMils, endMils);
        return arr;
    }
}
