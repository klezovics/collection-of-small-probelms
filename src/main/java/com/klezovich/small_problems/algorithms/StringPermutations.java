
package com.klezovich.small_problems.algorithms;
import java.util.*;

public class StringPermutations {
    // Input: Any string
    // Output: All of the permutations of the string's characters
     static List<String> getAllPerms(  String s ){
     
        List<String> strPermList = new ArrayList<>();
        if(  s.length() <= 1 )
        {
          strPermList.add(s);
          return strPermList; 
        }
         
        String firstChar = Character.toString(s.charAt(0));
        List<String> oneLessCharPermList = getAllPerms(s.substring(1));
        for( String str : oneLessCharPermList  )
        {
          for( int ii=0; ii<=str.length(); ii++  )
          {
            StringBuilder sb = new StringBuilder(str);
            strPermList.add( new String(sb.insert(ii, firstChar )) );
          }
        }
      
         return strPermList;    
     }
    
    public static void main(String[] args) {
        System.out.println(getAllPerms("123").size());
    }
}
