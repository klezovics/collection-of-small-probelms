package com.klezovich.small_problems.olympiad.greedy;

import java.util.*;
/*
Task. The goal of this problem is to represent a given positive integer n as a sum of as many pairwise
distinct positive integers as possible. That is, to find the maximum k such that n can be written as
a_1 + a_2 + · · · + a_k where a1, . . . , a_k are positive integers and a_i != a_j for all 1 ≤ i < j ≤ k.

Input Format. The input consists of a single integer n.

Constraints. 1 ≤ n ≤ 10^9.

Output Format. In the first line, output the maximum number k such that n can be represented as a sum
of k pairwise distinct positive integers. In the second line, output k pairwise distinct positive integers
that sum up to k (if there are many such representations, output any of them).

*/
public class DifferentSummands {
    private static List<Integer> optimalSummands(int n) {
        List<Integer> summands = new ArrayList<Integer>();
        
        int S_aUpperBound = 0;
        int i=1;
        for (i = 1; S_aUpperBound <= n; i++ ) {
            S_aUpperBound = getS_a(i);
        }
        
        //At the end of the loop we've found the smallest k such that S_a(k) is bigger than n
        // and the value of i is equal to the relevant 
        int kUpperBound=i-1;
        int kLowerBound=kUpperBound-1;
        
        //System.out.println("Lower Bound" + kLowerBound );
        //System.out.println("Upper Bound" + kUpperBound );
        
        // It can be proven that the maximum number of summands for the initial n
        // is equal to the kLowerBound;
        int numSummands = kLowerBound;
        
        // The summands themselves are 1+2+3...+( kLowerBound + n - S_a(kLowerBound) ) 
        for (int j = 1; j <=kLowerBound; j++) {
            
            if( j<kLowerBound)
              summands.add(j);
            else
              summands.add(kLowerBound + n - getS_a(kLowerBound));
        }
        
        return summands;
    }
    
    
    private static int getS_a( int k ){
    // S_a(k) is the summ of the integer sequence of the form S_a(k) = 1+2+3+4+5+...+k
        int summ=0;
        for (int i = 1; i <= k; i++) {
            summ+=i;
        }
        return summ;
    }
    
    
    private static void test(){
        if( getS_a(1) != 1 )
            System.out.println("S_a(1) != 1 ");
        
        if( getS_a(2) != 3 )
            System.out.println("S_a(2) != 3 ");
        
        if( getS_a(3) != 6 )
            System.out.println("S_a(3) != 6 ");
        
        if( getS_a(4) != 10 )
            System.out.println("S_a(4) != 100 ");
        
        if( getS_a(100) != 5050 )
            System.out.println("S_a(100) != 5050 ");
        
        
    }
    
    public static void main(String[] args) {
        
        test();
        
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        
        List<Integer> summands = optimalSummands(n);
        
        System.out.println(summands.size());
        for (Integer summand : summands) {
            System.out.print(summand + " ");
        }
        
    }
}

