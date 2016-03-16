package com.kururu.dp;

import org.w3c.dom.ls.LSException;

/**
 * Created by Ellery Queen on 2016/3/16.
 */
public class LCS {

    final static int MaxNum = 100;

    public int LCSlength[][];
    public int problemNote[][];

    public void setLCSlength(int[][] LCSlength) {
        this.LCSlength = LCSlength;
    }

    public void setProblemNote(int[][] problemNote) {
        this.problemNote = problemNote;
    }

    public void LcsLength(String str1,String str2){
        for(int i = 0;i < str1.length()+1;i++)
            this.LCSlength[i][0] = 0;
        for(int i = 0;i < str2.length()+1;i++)
            this.LCSlength[0][i] = 0;
        for(int i = 1;i < str1.length()+1;i++){
            for(int j = 1;j < str2.length()+1;j++){
                if(str1.charAt(i-1) == str2.charAt(j-1)){
                    this.LCSlength[i][j] = LCSlength[i-1][j-1] +1;
                    this.problemNote[i][j] = 0;
                }else if(this.LCSlength[i-1][j] >= this.LCSlength[i][j-1]){
                    this.LCSlength[i][j] = this.LCSlength[i-1][j];
                    this.problemNote[i][j] = 1;
                }else{
                    this.LCSlength[i][j] = this.LCSlength[i][j-1];
                    this.problemNote[i][j] = -1;
                }
            }
        }
    }

    public void printLcs(String str1,int str1Length,int str2Length){
        if(str1Length == 0 || str2Length == 0)
            return;
        if(this.problemNote[str1Length][str2Length] == 0){
            printLcs(str1,str1Length-1,str2Length-1);
            System.out.print(str1.charAt(str1Length-1));
        }else if(this.problemNote[str1Length][str2Length] == 1)
            printLcs(str1,str1Length-1,str2Length);
        else
            printLcs(str1,str1Length,str2Length-1);


    }

    public static void main(String[] args) {
        String str1 = "ABCBDAB";
        String str2 = "BDCABA";
        int[][] c = new int[MaxNum][MaxNum];
        int[][] b = new int[MaxNum][MaxNum];
        LCS test = new LCS();
        test.setLCSlength(c);
        test.setProblemNote(b);
        test.LcsLength(str1,str2);
        test.printLcs(str1,str1.length(),str2.length());
    }
}
