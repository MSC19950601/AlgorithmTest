package com.kururu.dp;

/**
 * Created by yhmsc on 2016/3/16.
 */
public class KMP {

    public static void KMPsearch(String origin, String target, int[] next){
        int j = 0;
        for(int i = 0;i < origin.length();i++){
            while(j > 0 && origin.charAt(i) != target.charAt(j))
                j = next[j];
            if(origin.charAt(i) == target.charAt(j))
                j++;
            if(j == target.length()){
                    System.out.println("find at position " + (i-j));
                    System.out.println(origin.substring(i-j+1,i+1));
                    j = next[j];
            }

        }
    }

    public static void main(String[] args) {
        int[] next = new int[100];
        String origin = "jnfkaehbfgniouqwhbiufgoqhbergiu";
        String target = "bfgni";
        KMPsearch(origin,target,next);
    }
}
