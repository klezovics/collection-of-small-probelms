// Implements the synchronous sortation of two integer arrays by the element of the first one
// To be extended to collections ... 


package com.klezovich.small_problems.algorithms;
import java.util.Arrays;

// An interface is used here to later make use of the Strategy design pattern.
interface TwoArraySyncSorter {

    void syncSort(int[] first, int[] second);
}

class SyncBubleSorter implements TwoArraySyncSorter {

    int[] first;
    int[] second;

    boolean shouldSort() {
        if (first == null || second == null) {
            return false;
        }

        if (first.length != second.length) {
            return false;
        }

        if (first.length == 1) {
            return false;
        }

        return true;
    }

    boolean isSortedAsc(int a[]) {

        for (int ii = 0; ii < a.length - 1; ii++) {
            if (a[ii] > a[ii + 1]) {
                return false;
            }
        }

        return true;
    }
    
    void swapArrCells( int a[], int firstInd, int secondInd ){
        int tmp = a[firstInd];
        a[firstInd] = a[secondInd];
        a[secondInd] = tmp;
    }
    
    @Override
    public void syncSort(int[] first, int[] second) {

        this.first = first;
        this.second = second;

        if (!shouldSort()) {
            return;
        }

        while (!isSortedAsc(first)) {
            for (int ii = 0; ii < first.length - 1; ii++) {
               if(  first[ii] > first[ii+1] )
               {
                  swapArrCells( first, ii, ii+1 );
                  swapArrCells(second, ii, ii+1); // key step -we always make the same change in the second as we did in the first
               }
                
            }

        }

    }

}

/**
 *
 * @author artur.klezovics
 */
public class SynchronousSort {

    // Strategy design pattern - the first argument determines the sorting algorithm
    static void syncSort(TwoArraySyncSorter sorter, int first[], int second[]) {
        sorter.syncSort(first, second);
    }

    static void showArrays(int[] a, int[] b) {
        System.out.format("First:  %s\n", Arrays.toString(a));
        System.out.format("Second: %s\n", Arrays.toString(b));
    }

    public static void main(String[] args) {
        int[] a = new int[]{5,4,3, 2, 1};
        int[] b = new int[]{1, 2, 3,4,5};
        System.out.println("==== Before sort ===");
        showArrays(a, b);
        syncSort(new SyncBubleSorter(), a, b);
        System.out.println("==== After sort ==== ");
        showArrays(a, b);

    }
}
