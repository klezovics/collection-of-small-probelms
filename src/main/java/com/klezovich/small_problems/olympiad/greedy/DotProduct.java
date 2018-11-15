package com.klezovich.small_problems.olympiad.greedy;


import java.math.BigInteger;
import java.util.*;

/*
Task. Given two sequences a_i( a_i is the profit per click of the i-th ad) and b_i ( b_i is
the average number of clicks per day of the i-th slot), we need to partition them into n pairs (a_i, b_j)
such that the sum of their products is maximized.

Input Format. The first line contains an integer n, the second one contains a sequence of integers
a_i i=1...n, the third one contains a sequence of integers b_j j=1...n.
Constraints. 1 ≤ n ≤ 10^3; −10^5 ≤ a_i, b_i ≤ 10^5 for all 1 ≤ i ≤ n.

Output Format. Output the maximum value of the dot product of the form Summ(a_i*c_i) for 1<=i<=n
where c_i is some persumatation of b_i;
 */
public class DotProduct {

    private static BigInteger maxDotProduct(int[] a, int[] b) {
        //write your code here
        BigInteger result = new BigInteger("0");
        
        
        //System.out.println("Unsorted:");
        //printArray(a);
        //printArray(b);
        Arrays.sort(a);
        Arrays.sort(b);
        
        int adNum = a.length;
        for (int i = 0; i < adNum; i++) {
        // This will give the maximum value by the rearrangement inequality
             Long mult = new Long( (long)a[i]*(long)b[i] );
             String numStr = mult.toString();
             //System.out.println("mult:" + numStr);
             result= result.add( new BigInteger(numStr) );
             //System.out.println(result);
        }
        
        //System.out.println("Sorted:");
        //printArray(a);
        //printArray(b);
        
        
        return result;
    }
    
    
    private static void printArray( int [] a )
    {
        System.out.println(Arrays.toString(a));
        return;
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
            //a[i] = 100000;//scanner.nextInt();
        }
        
        
        int[] b = new int[n];
        for (int i = 0; i < n; i++) {
            b[i] = scanner.nextInt();
            //b[i] = 100000;//scanner.nextInt();
        }
        
        
        
        System.out.println(maxDotProduct(a, b));
    }
}
