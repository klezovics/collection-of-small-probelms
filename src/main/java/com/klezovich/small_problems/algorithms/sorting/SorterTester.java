package com.klezovich.small_problems.algorithms.sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

/**
 *
 * @author artur.klezovics
 */
public class SorterTester {

    // assumes ascending sort order
    static boolean isSorted(int a[]) {
        for (int i = 0; i < a.length - 1; i++) {
            if (a[i] > a[i + 1]) {
                return false;
            }
        }

        return true;
    }

    static boolean isSortedAsc(int a[]) {
        return isSorted(a);
    }

    static int[] createRandArray(int len) {

        Random rand = new Random();

        int a[] = new int[len];
        for (int i = 0; i < len; i++) {
            a[i] = rand.nextInt();
        }

        return a;
    }

    static boolean isSortedDesc(int a[]) {
        for (int i = 0; i < a.length - 1; i++) {
            if (a[i] < a[i + 1]) {
                return false;
            }
        }

        return true;
    }

    static void printFailMessage(int a[], String s) {
        System.out.println("FAIL!:" + s + ":" + Arrays.toString(a));
    }

    static void runIsSortedTests() {
        int a[] = {1, 2, 3};

        if (!isSorted(a)) {
            printFailMessage(a, "test1");
        }

        int[] a1 = {2, 3, 5, 10, 11, 22};
        if (!isSorted(a1)) {
            printFailMessage(a1, "test2");
        }

        int[] a2 = {3, 2, 1};
        if (isSorted(a2)) {
            printFailMessage(a2, "test3");
        }

        int[] a3 = {0, 0, 0};
        if (!isSorted(a3)) {
            printFailMessage(a3, "test4");
        }

        if (!isSortedAsc(a1)) {
            printFailMessage(a1, "test5");
        }

        if (isSortedAsc(a2)) {
            printFailMessage(a1, "test6");
        }

        if (!isSortedDesc(a2)) {
            printFailMessage(a1, "test7");
        }

        if (!isSortedDesc(a3)) {
            printFailMessage(a1, "test8");
        }

        if (isSortedDesc(a1)) {
            printFailMessage(a1, "test9");
        }

    }

    static void addRandArraysToList(int arrNum, List<int[]> list) {
        for (int i = 1; i <= arrNum; i++) {
            Random rand = new Random();
            int newArrLen = rand.nextInt(100) + 1;
            list.add(SorterTester.createRandArray(newArrLen));
        }
    }

    public static void easyTest(Sorter s) {
        int a[] = {1, 3, 4, 2, 5};

        System.out.printf("Sorting %s:\n", Arrays.toString(a));
        a = s.sort(a);
        if (!isSorted(a)) {
            System.out.printf("FAIL! Result %s\n", Arrays.toString(a));
        } else {
            System.out.printf("Sorted OK:" + Arrays.toString(a));
        }
        System.out.println("");
        
        int b[] = {0, 0, 0};
        System.out.printf("Sorting %s:\n", Arrays.toString(b));
        b = s.sort(b);
        if (!isSorted(b)) {
            System.out.printf("FAIL! Result %s\n", Arrays.toString(b) );
        } else {
            System.out.println("Sorted OK:" + Arrays.toString(b));
        }
    }

    static void testSorter(Sorter s) {

        int a[] = {9, 3, 4, 2, 1, 8, 3, 5, 7, 6};
        System.out.printf("========== %s ============\n", s.getName());
        System.out.println("Unsorted:" + Arrays.toString(a));
        a = s.sort(a);
        System.out.println("Sorted:" + Arrays.toString(a));

        // Manually written test cases
        List<int[]> arraysToSort = new LinkedList<>();
        arraysToSort.add(new int[]{7, 1, 3, 2, 5, 6});
        arraysToSort.add(new int[]{0, 0, 0, 0, 0});
        arraysToSort.add(new int[]{1, 2, 3, 4, 5});
        arraysToSort.add(new int[]{5, 4, 3, 2, 1});
        arraysToSort.add(new int[]{-1, 1, -1, 1});
        arraysToSort.add(new int[]{100, 1, -100, -1});
        arraysToSort.add(new int[]{-2, 22, 1, 2, 3, 4, 17, -55});
        arraysToSort.add(new int[]{-1, 1, 2, 3, -1});
        arraysToSort.add(new int[]{1, 1, -1, 1, -1});

        // Adding a 100 random arrays to the list
        addRandArraysToList(100, arraysToSort);

        // Checking if all the arrays are sorted correctly
        boolean failFlag = false;
        for (int[] array : arraysToSort) {
            int[] arrayBeforeSort = Arrays.copyOf(array, array.length);
            array = s.sort(array);
            if (!SorterTester.isSorted(array)) {
                System.out.println("Failed to sort:" + Arrays.toString(arrayBeforeSort));
                System.out.println("Output:" + Arrays.toString(array));
                failFlag = true;
            }
        }

        if (!failFlag) {
            System.out.println("All tests cases PASSED");
        }

        System.out.println("================================");
    }

    static void testAllSorters() {

        List<Sorter> li = new ArrayList<>();
        li.add(new Quicksort());
        li.add( new MergeSort() );

        for (Sorter s : li) {
            testSorter(s);
        }
    }

    public static void main(String[] args) {
        runIsSortedTests();
        testAllSorters();
    }

}
