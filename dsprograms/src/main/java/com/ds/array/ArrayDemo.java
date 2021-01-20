package com.ds.array;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ArrayDemo {
    public static void main(String[] args) {
        List<String> mylist = new ArrayList<String>();
        mylist.add("hi");
        mylist.add("hello");
        //System.out.println(mylist.size());
        List<String> mylist1 = mylist.stream().filter(a -> a.equals("hi")).collect(Collectors.toList());
        //System.out.println(mylist1.size());
        ArrayDemo ad = new ArrayDemo();
        int count = ad.wordCount("hi i like you");
        System.out.println("no of words : "+count);
    }

    public int wordCount(String abc){
//        char[] chars = abc.toCharArray();String
        int i = abc.length();
        int j=0;
        int wc = 0;
        while(i < abc.length()){
            if(abc.charAt(i)==' '){
                wc++;
            }
            i++;
        }
        return wc;
    }
}
