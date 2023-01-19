package com.ishujaa.my_code_library.src.dsa.search.pattern;

public class NaivePatternSearch {
    //implementation of improved Naive Pattern Search for a pattern containing distinct characters
    public boolean exists(String text, String pattern){
        int i=0,j=0,resetI=1;
        while(i < text.length() && j < pattern.length()){
            if(text.charAt(i) == pattern.charAt(j)){
                i++;j++;

            }else{
                i=resetI++;
                i+=j-1; //the magic lies here
                j = 0;
            }
        }

        return j == pattern.length();
    }
}
