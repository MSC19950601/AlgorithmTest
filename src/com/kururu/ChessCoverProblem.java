package com.kururu;

import java.util.Scanner;

import static java.lang.StrictMath.pow;

public class ChessCoverProblem {

    static int gowCount;
    static int Matrix[][] = new int[100][100];

    //topLeftCornerRow每个棋盘左上角的横坐标，topLeftCornerCol每个棋盘左上角的纵坐标
    //specialRow特殊位的横坐标，specialCol特殊位的纵坐标
    //size棋盘规模
    public static void chessBoard(int topLeftCornerRow,int topLeftCornerCol,int specialRow,int specialCol,int size){
        int temporarySize;//每一次的迭代的棋盘大小
        int temporaryGowCount;//每次覆盖所用的骨牌编号
        //棋盘只有一个方格的话那必然只有一个特殊方格
        if(size == 1)
            return;

        temporaryGowCount = ++gowCount;
        temporarySize = size/2;
        //初始棋盘平均分成四份后特殊格在左上角的情况
        if(specialRow < topLeftCornerRow + temporarySize && specialCol < topLeftCornerCol + temporarySize){
            chessBoard(topLeftCornerRow,topLeftCornerCol,specialRow,specialCol,temporarySize);
        }else{
            Matrix[topLeftCornerRow + temporarySize - 1][topLeftCornerCol + temporarySize - 1] = temporaryGowCount;
            chessBoard(topLeftCornerRow,topLeftCornerCol,topLeftCornerRow + temporarySize - 1,topLeftCornerCol + temporarySize - 1,temporarySize);
        }
        //初始棋盘平均分成四份后特殊格在右上角的情况
        if(specialRow < topLeftCornerRow + temporarySize && specialCol >= topLeftCornerCol + temporarySize){
            chessBoard(topLeftCornerRow,topLeftCornerCol + temporarySize,specialRow,specialCol,temporarySize);
        }else{
            Matrix[topLeftCornerRow + temporarySize - 1][topLeftCornerCol + temporarySize] = temporaryGowCount;
            chessBoard(topLeftCornerRow,topLeftCornerCol + temporarySize,topLeftCornerRow + temporarySize - 1, topLeftCornerCol + temporarySize,temporarySize);
        }
        //初始棋盘平均分成四份后特殊格在左下角的情况
        if(specialRow >= topLeftCornerRow + temporarySize && specialCol < topLeftCornerCol + temporarySize){
            chessBoard(topLeftCornerRow + temporarySize,topLeftCornerCol,specialRow,specialCol,temporarySize);
        }else{
            Matrix[topLeftCornerRow + temporarySize][topLeftCornerCol + temporarySize - 1] = temporaryGowCount;
            chessBoard(topLeftCornerRow + temporarySize,topLeftCornerCol,topLeftCornerRow + temporarySize,topLeftCornerCol + temporarySize - 1,temporarySize);
        }
        //初始棋盘平均分成四份后特殊格在右下角的情况
        if(specialRow >= topLeftCornerRow + temporarySize && specialCol >= topLeftCornerCol + temporarySize){
            chessBoard(topLeftCornerRow + temporarySize,topLeftCornerCol + temporarySize,specialRow,specialCol,temporarySize);
        }else{
            Matrix[topLeftCornerRow + temporarySize][topLeftCornerCol + temporarySize] = temporaryGowCount;
            chessBoard(topLeftCornerRow + temporarySize,topLeftCornerCol + temporarySize,topLeftCornerRow + temporarySize,topLeftCornerCol + temporarySize,temporarySize);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("input the power k:");
        int k = scanner.nextInt();
        int size = (int)pow(2,k);
        System.out.println("input the special case row number:");
        int row = scanner.nextInt();
        System.out.println("input the special case col number:");
        int col = scanner.nextInt();
        chessBoard(0,0,row,col,size);
        for(int i = 0;i<size;i++){
            for(int j = 0;j<size;j++){
                System.out.printf("%d\t",Matrix[i][j]);
            }
            System.out.println();
        }

    }
}
