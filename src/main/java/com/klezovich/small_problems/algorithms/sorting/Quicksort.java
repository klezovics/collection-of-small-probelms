package com.klezovich.small_problems.algorithms.sorting;

import java.util.List;
import java.util.Random;

public class Quicksort extends Sorter {
    
    public int[] sort( int a[] ){
        quickSort(a);
        return a;
    }

    static void shiftSubArrayByOneLeft(int a[], int firstInd, int lastInd) {

        if (firstInd > lastInd) {
            return;
        }

        if (firstInd == 0) {
            return;
        }

        for (int i = firstInd; i <= lastInd; i++) {
            a[i - 1] = a[i];
        }

    }

    static int partitionLastIndPivot(int a[], int firstInd, int lastInd) {
        if (a.length <= 1) {
            return 0;
        }

        if (firstInd >= lastInd) {
            return 0;
        }

        int pivotInd = lastInd;
        for (int i = lastInd - 1; i >= 0; i--) {
            if (a[i] > a[pivotInd]) {
                //System.out.println("Moving value: " + a[i] + "from pos:" + i + "to end" );
                //System.out.println( Arrays.toString(a));
                int tmp = a[i];                          // "picking up" the bigger element
                shiftSubArrayByOneLeft(a, i + 1, lastInd); // shifting the "tail" of the array by one 
                pivotInd--;                              // pivot has moved by 1 left
                a[lastInd] = tmp;                        // there is now a guaranteed spot at the end - place the bigger element there
            }
        }

        return pivotInd;
    }

    static void qsort(int a[], int firstInd, int lastInd) {

        //System.out.printf("Called qsort: a[%d]-a[%d]\n", firstInd, lastInd );
        if (a.length <= 1) {
            return;
        }

        if (firstInd >= lastInd) {
            return;
        }

        // Select the last element as the pivot
        int pivot = lastInd;

        // Move the pivot into the correct position 
        int newPivotInd = partitionLastIndPivot(a, firstInd, lastInd);
        //System.out.println( "Pivots pos " + newPivotInd + " " + Arrays.toString(a));

        //Recursively sort the remaining array
        qsort(a, 0, newPivotInd - 1);
        qsort(a, newPivotInd + 1, lastInd);

    }

    // Sorts in ascending order
    static void quickSort(int a[]) {
        qsort(a, 0, a.length - 1);
    }

    static void addRandArraysToList(int arrNum, List<int[]> list) {
        for (int i = 1; i <= arrNum; i++) {
            Random rand = new Random();
            int newArrLen = rand.nextInt(100) + 1;
            list.add(SorterTester.createRandArray(newArrLen));
        }
    }

    static void testQsort() {
 
        SorterTester.testSorter( new Quicksort() );
        
    }

    public static void main(String[] args) {
        testQsort();
    }
}
