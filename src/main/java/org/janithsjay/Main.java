package org.janithsjay;

import org.janithsjay.sorting.bubblesort.BubbleSort;
import org.janithsjay.sorting.insertionsort.InsertionSort;
import org.janithsjay.sorting.selectionsort.SelectionSort;

public class Main {
    public static void main(String[] args) {
        BubbleSort sorter = new BubbleSort();
        sorter.sort(new int[]{11,1,2,5,3,6,4,-4,0,-15});
        sorter.sort(new int[]{11,1,2,5,3,6,4,-4,0,-15}, BubbleSort.SORT_BY_MIN);

        SelectionSort selectionSort = new SelectionSort();
        selectionSort.sort(new int[]{11,1,2,5,3,6,4,-4,0,-15});
        selectionSort.sort(new int[]{11,1,2,5,3,6,4,-4,0,-15}, SelectionSort.SORT_BY_MAX);

        InsertionSort insertionSort = new InsertionSort();
        insertionSort.sort(new int[]{11,1,2,5,3,6,4,-4,0,-15});
    }
}