package com.kururu.dp;

import java.util.function.DoublePredicate;

/**
 * Created by Ellery Queen on 2016/3/17.
 */


public class KnapsackProblem {
    //测试参数设置
    final static int[] Val = {0,10,40,30,50};
    final static int[] Vol = {0,5,4,6,3};
    final static int PackageVol = 10;
    final static int Num = 4;
    //物件的价值和体积数组
    public int[] itemVal;
    public int[] itemVol;

    public int[][] DPsolution;

    public void setItemVal(int[] itemVal) {
        this.itemVal = itemVal;
    }

    public void setItemVol(int[] itemVol) {
        this.itemVol = itemVol;
    }

    public void setDPsolution(int[][] DPsolution) {
        this.DPsolution = DPsolution;
    }

    public void solution(int n, int v, int[][] dpSolution, int[] val, int[] vol){
        for(int i = 0;i < v;i++){
            dpSolution[0][i] = 0;
        }
        for(int i = 1;i <= n ;i++)
            for(int j = 0; j <= v ;j++)
                if(j >= vol[i])
                    dpSolution[i][j] = Math.max(dpSolution[i - 1][j], dpSolution[i - 1][j - vol[i]] + val[i]);
                else
                    dpSolution[i][j] = dpSolution[i-1][j];
    }

    public static void main(String[] args) {
        int[][] dpArray = new int[Num+1][PackageVol+1];
        KnapsackProblem test = new KnapsackProblem();
        test.setItemVal(Val);
        test.setItemVol(Vol);
        test.setDPsolution(dpArray);
        test.solution(Num,PackageVol,test.DPsolution,test.itemVal,test.itemVol);
        for(int i = 0;i <= Num;i++){
            for(int j = 0;j <= PackageVol;j++)
                System.out.print(test.DPsolution[i][j] + "\t");
            System.out.print("\n");
        }

    }
}
/*
0	0	0	0	0	0	0	0	0	0	0
0	0	0	0	0	10	10	10	10	10	10
0	0	0	0	40	40	40	40	40	50	50
0	0	0	0	40	40	40	40	40	50	70
0	0	0	50	50	50	50	90	90	90	90
 */