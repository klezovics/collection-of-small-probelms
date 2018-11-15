package com.klezovich.small_problems.algorithms;
//package com.klezovich.algorithms;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
Task. The goal in this code problem is to implement the binary search algorithm.
* The first line of the input contains an integer n and a sequence
* a_0 < a_1 < . . . < a_n−1 of pairwise distinct positive integers in increasing order. 
* 
* The next line contains an integer k (key) and k positive integers k_0, k_1, . . . , k_n−1. 
* 
* Output the found element index or -1 if there's no such index for each of the keys
 */
public class BinarySearch {

    static final int NOT_FOUND = -1;

    static int calcNewHigh(int high, int midpoint, boolean keyGreaterThanMidpoint) {

        if (keyGreaterThanMidpoint) {
            return high;
        } else {
            // key smaller than midpoint
            return midpoint-1;
        }

    }

    static int calcNewLow(int low, int midpoint, boolean keyGreaterThanMidpoint) {

        if (keyGreaterThanMidpoint) {
            return midpoint+1;
        } else {
            // key is smaller than midpoint
            return low;
        }
    }

    static int calcMidpoint(int low, int high) {

        if (low > high) {
            System.out.println("Error: Low > High");
        }

        if (low == high) {
            return low;
        }

        // the fractional part is automatically dropped
        return low + (high - low)/2;

    }

    static int binarySearch(int[] A, int low, int high, int key) {

        //System.out.printf("Processing key:%d l:%d h:%d\n",key,low,high);
        
        if (A.length == 0) {
            return -1;
        }
        
        if ( low  == high) {
            if (A[low] == key) {
                return low;
            } else {
                return NOT_FOUND;
            }
        }
        
        if( low > high )
            return NOT_FOUND;
        
        int midpoint = calcMidpoint(low, high);
        
        int newLow = 0;
        int newHigh = 0;
        
        if( A[midpoint] == key )
            return midpoint;
        else if( key > A[midpoint] ){
            newLow = calcNewLow(low, midpoint, true);
            newHigh = calcNewHigh(high, midpoint, true);
        }else if( key < A[midpoint] ){
            newLow = calcNewLow(low, midpoint, false );
            newHigh = calcNewHigh(high, midpoint, false);
        }
        
        return binarySearch(A, newLow, newHigh, key);

    }

    static void testBinarySearchUtilityFunctions() {
        
        int[] lows     = {0 , 0, 0, 10, 7, 9  };
        int[] highs    = {0 , 3, 4, 20, 8, 11 };
        int[] midpoints ={0 , 1, 2, 15, 7, 10 };
        
        boolean errorInMidpointCalc = false;
        for( int ii=0; ii< lows.length; ii++ ){
           int midpoint = calcMidpoint(lows[ii], highs[ii] );
           if(  midpoints[ii] != midpoint  ){
               System.out.printf("Bad midpoint l:(%d) h:(%d) result:(%d) expected(:%d)\n",
                                 lows[ii],
                                 highs[ii],
                                 midpoint,
                                 midpoints[ii] );
           } 
        }
        
    }
    
    static void testBinarySearch(){
        
        List<int[]> arrays = new ArrayList<>();
        List<Integer> keys = new ArrayList<>();
        List<Integer> keyPositions = new ArrayList<>();
        
        arrays.add(  new int[] {0} );
        keys.add(0);
        keyPositions.add(0);
        
        arrays.add(  new int[] {0} );
        keys.add(-1);
        keyPositions.add(-1);
        
        arrays.add(  new int[] {0,1,2,3,4,5} );
        keys.add(1);
        keyPositions.add(1);
        
        arrays.add(  new int[] {100,101,102,103,104,105} );
        keys.add(102);
        keyPositions.add(2);
        
        arrays.add(  new int[] {-10,-5,-4,-3,-2,100} );
        keys.add(100);
        keyPositions.add(5);
        
        arrays.add(  new int[] {1,5,8,12,13} );
        keys.add(8);
        keyPositions.add(2);
        
        arrays.add(  new int[] {1,5,8,12,13} );
        keys.add(1);
        keyPositions.add(0);
        
        arrays.add(  new int[] {1,5,8,12,13} );
        keys.add(23);
        keyPositions.add(-1);
        
        arrays.add(  new int[] {1,5,8,12,13} );
        keys.add(1);
        keyPositions.add(0);
        
        arrays.add(  new int[] {1,5,8,12,13} );
        keys.add(11);
        keyPositions.add(-1);
        
        
        for( int ii=0; ii<arrays.size(); ii++ ){
            
            int[] array = arrays.get(ii);
            int key = keys.get(ii);
            int keyPosition = keyPositions.get(ii);
            
            int foundKeyPosition = binarySearch(array, 0, array.length - 1, key);
            if( foundKeyPosition != keyPosition )
                System.out.println("Error in test case:" + ii );
            
            
            
        }
        
        
        
        
        
        
    }

    static void solveProblem(){
        
        Scanner in = new Scanner(System.in);
        
        int arrayLen = in.nextInt();
        int[] array = new int[arrayLen];
        for( int ii=0; ii<arrayLen; ii++ ){
            array[ii] = in.nextInt();
        }
        
        int numKeys = in.nextInt();
        int keys[] = new int[numKeys];
        for (int ii = 0; ii < numKeys; ii++) {
            keys[ii] = in.nextInt();
        }
        
        for (int ii = 0; ii < numKeys; ii++) {
            int key = keys[ii];
            //System.out.println("Processing key with index:" + ii);
            int keyPos = binarySearch( array, 0, array.length - 1, key );
            System.out.printf("%d ", keyPos);
        }
        
        
    }
    
    public static void main(String[] args) {
       testBinarySearchUtilityFunctions();
       testBinarySearch();
       solveProblem();
       
    }
}
