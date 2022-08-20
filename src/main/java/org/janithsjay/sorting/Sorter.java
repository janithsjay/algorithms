package org.janithsjay.sorting;

import org.janithsjay.sorting.bubblesort.BubbleSort;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class Sorter {
    public Logger log = LoggerFactory.getLogger(Sorter.class);

    public static final String SORT_BY_MAX = "SORT_BY_MAX";
    public static final String SORT_BY_MIN = "SORT_BY_MIN";
    public abstract int[] sort(int[] arr);

    protected int[] swap(int[] ar, int index, int secondIndex){
        int temp = ar[index];
        ar[index] = ar[secondIndex];
        ar[secondIndex] = temp;
        return ar;
    }

    protected void printResults(int[] arr, double startMils, double endMils) {
        System.out.print("\n");
        log.info("===============================================================================================");
        log.info("Sorting completed. Total Element Count: {}, Time Taken: {}mils.", arr.length, endMils - startMils);
        log.info("Speed: {} elements/mils.", arr.length/(endMils - startMils));
        log.info("Result: {}", arr);
        log.info("===============================================================================================");
        System.out.print("\n\n");
    }
}
