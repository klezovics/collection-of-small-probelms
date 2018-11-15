package com.klezovich.small_problems.olympiad;


import java.util.*;
import java.io.*;

/* Given a sequence of non-negative integers a0,…,an−1, find the maximum pairwise product, that is, 
the largest integer that can be obtained by multiplying two different elements from the sequence */

/* Input: first line - number of elements in the sequence, second line - elements of the sequence */ 
public class MaxPairwiseProduct {

    static long getMaxPairwiseProduct(int[] numbers) {
        long result = 0;
        int n = numbers.length;
        
        /* Given that the integers are non-negative - the maximum pairwise product
           will be equal to the product of the largest integer and the second largest integer*/ 
        
        
        /* Looking for the largest integer*/ 
        int maxInt = numbers[0];
        int maxIntInd = 0;
        for( int ii=0; ii<n; ii++ )
        {
            if( numbers[ii] > maxInt )
            {
                maxInt = numbers[ii];
                maxIntInd = ii;
            }
        }
        
        /* Looking for the second largest integer*/ 
        int secondMaxInt = -1;
        for( int ii=0; ii<n; ii++ )
        {
            /* Skipping the max integer - we've already found it */ 
            if( ii == maxIntInd )
                continue;
            
            if( numbers[ii] > secondMaxInt )
                secondMaxInt = numbers[ii];
            
        }
        
        
        result = (long)maxInt * (long)secondMaxInt;
        return result;
    }

    static int getMaxIntInArray(int[] numbers) {
        int maxInt = numbers[0];
        for (int n : numbers) {
            if (n > maxInt) {
                maxInt = n;
            }
        }
        return maxInt;
    }

    

    public static void main(String[] args) {
        FastScanner scanner = new FastScanner(System.in);
        int n = scanner.nextInt(); /* number of elements in sequence */ 
        int[] numbers = new int[n];
        for (int i = 0; i < n; i++) {
            numbers[i] = scanner.nextInt(); /* the sequence */ 
        }
        System.out.println(getMaxPairwiseProduct(numbers));
    }

    static class FastScanner {

        BufferedReader br;
        StringTokenizer st;

        FastScanner(InputStream stream) {
            try {
                br = new BufferedReader(new InputStreamReader(stream));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        String next() {
            while (st == null || !st.hasMoreTokens()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }
    }

}
