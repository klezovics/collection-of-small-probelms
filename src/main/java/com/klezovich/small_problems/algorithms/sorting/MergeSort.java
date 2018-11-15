package com.klezovich.small_problems.algorithms.sorting;

import java.util.Arrays;

/**
 *
 * @author artur.klezovics
 */
public class MergeSort extends Sorter {

    @Override
    int[] sort(int[] a) {
        return mergeSort(a);
    }

    int[] mergeSort(int a[]) {
        int[] res = mSortImplOne(a);
        return res;
    }

    static void copyArrayTail(int[] dest, int destStart, int[] src, int srcStart) {

        int srcElemInd = srcStart;
        for (int ii = destStart; ii <= dest.length - 1; ii++) {
            dest[ii] = src[srcElemInd];
            srcElemInd++;
        }

    }

    static int[] merge(int[] left, int[] right) {

        if (left.length == 0) {
            return right;
        }

        if (right.length == 0) {
            return left;
        }

        int ll = left.length;
        int rl = right.length;

        int mergedLen = ll + rl;

        int leftLastInd = 0;
        int rightLastInd = 0;

        int[] merged = new int[mergedLen];

        for (int ii = 0; ii < mergedLen; ii++) {

            // If one of the arrays has been exhausted,
            // append all the intergers from the other
            if (leftLastInd > left.length - 1) {
                copyArrayTail(merged, ii, right, rightLastInd);
                break;
            }

            if (rightLastInd > right.length - 1) {
                copyArrayTail(merged, ii, left, leftLastInd);
                break;
            }

            int fromLeft = left[leftLastInd];
            int fromRight = right[rightLastInd];

            if (fromLeft <= fromRight) {
                merged[ii] = fromLeft;
                leftLastInd++;
            } else if (fromLeft > fromRight) {
                merged[ii] = fromRight;
                rightLastInd++;
            }
        }

        return merged;

    }

    static int[] mSortImplOne(int a[]) {

        if (a.length == 1) {
            return a;
        }

        // Create subarrays
        int leftSubArrayMaxInd;
        int rightSubArrayMinInd;
        
        if (a.length == 2) {
            leftSubArrayMaxInd =0;
            rightSubArrayMinInd=1;
        }
        else{   
          leftSubArrayMaxInd = (int)Math.floor( a.length/2 );
          rightSubArrayMinInd = (int)Math.floor( a.length/2 )+1;
        }

        //System.out.printf("Array %s leftMax %d| rightMin %d\n", Arrays.toString(a), leftSubArrayMaxInd, rightSubArrayMinInd );
        int[] left;
        int[] right;
        if( 0 == leftSubArrayMaxInd ){
          left = new int[1];
          left[0] = a[0];
        }
        else
          left = Arrays.copyOfRange(a, 0, leftSubArrayMaxInd+1);
        
        
        if( a.length-1 == rightSubArrayMinInd){
          right = new int[1];
          right[0] = a[a.length-1];
        }
        else
          right = Arrays.copyOfRange(a, rightSubArrayMinInd, a.length);

        // Sort them
        int[] leftSorted = mSortImplOne(left);
        //System.out.println("lSort:" + Arrays.toString(leftSorted) );
        int[] rightSorted = mSortImplOne(right);
        //System.out.println("rSort:" + Arrays.toString(rightSorted));

        // Merge them
        int[] result = merge(leftSorted, rightSorted);
        return result;
    }

    static void testMergeSort() {
        MergeSort m = new MergeSort();
        SorterTester.easyTest(m);
        SorterTester.testSorter( new MergeSort() );
    }

    static void mergeStepTest() {

        int a[] = new int[]{1, 3, 4};
        int b[] = new int[]{2, 5};

        System.out.println("Merged:" + Arrays.toString(merge(a, b)));

    }

    public static void main(String[] args) {
        //mergeStepTest();
        testMergeSort();
    }

}
