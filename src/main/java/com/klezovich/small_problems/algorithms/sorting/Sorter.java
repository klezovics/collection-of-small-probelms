package com.klezovich.small_problems.algorithms.sorting;

/**
 *
 * @author artur.klezovics
 */
public abstract class Sorter {
    
   abstract int[] sort( int[] a);
   
   String getName(){
       return this.getClass().getSimpleName();
   }
   
}
