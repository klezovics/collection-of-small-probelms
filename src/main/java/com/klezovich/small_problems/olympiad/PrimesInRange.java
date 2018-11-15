package com.klezovich.small_problems.olympiad;


import java.util.LinkedList;
import java.util.Scanner;


/* Input:   Two numbers M and N. 2<=M <= N <= 3000
   Output:  All of the prime numbers between M and N inclusive are printed out to console. 
            If no primes are found the word "Absent" is prited out to console. 
*/


public class PrimesInRange {

    static int[] GetLowerAndUpperBound(){
        int[] Arr = new int[2];
        Scanner Sc = new Scanner(System.in);
        int min = Sc.nextInt();
        int max = Sc.nextInt();
        Arr[0]=min;
        Arr[1]=max;
        
        return Arr; 
    }
    
    static boolean isPrime( int n ){
        
        if( n == 1 )
            return false;
        
        if( n == 2 )
            return true;
        
        for (int candDiv = 2; candDiv <= Math.sqrt(n)+1 ; candDiv++) {
            if( n % candDiv == 0 )
                return false;
        }
        
        return true;
        
    }
    
    public static void main(String[] args) {
        
        int[] Bounds = GetLowerAndUpperBound();
        int min = Bounds[0];
        int max = Bounds[1];
        LinkedList<Integer> primes = new LinkedList<Integer>();
        
        
        for (int ii = min; ii <= max; ii++) {
            if( isPrime(ii) )
              primes.add(ii);   
        }
        
        boolean primesFoundInRange = ( primes.size() > 0);
        if(primesFoundInRange)
        {
            for (Integer prime : primes ) {
                System.out.println(prime);
            }
        }
        else
            System.out.println("Absent");
        
    }
    
}
