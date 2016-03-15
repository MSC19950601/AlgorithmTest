package com.kururu;

public class ChessCoverProblem {

    int gowCount;
    int Matrix[][] = new int[100][100];

    //topLeftCornerRow每个棋盘左上角的横坐标，topLeftCornerCol每个棋盘左上角的纵坐标
    //specialRow特殊位的横坐标，specialCol特殊位的纵坐标
    //size棋盘规模
    void chessBoard(int topLeftCornerRow,int topLeftCornerCol,int specialRow,int specialCol,int size){
        int temporarySize;//每一次的迭代的棋盘大小
        int temporaryGowCount;//每次覆盖所用的骨牌编号
        //棋盘只有一个方格的话那必然只有一个特殊方格
        if(size == 1)
            return;

        temporaryGowCount = ++gowCount;
        temporarySize = size/2;
        if(specialRow < topLeftCornerRow + temporarySize && specialCol < topLeftCornerCol + temporarySize){
            chessBoard(topLeftCornerRow,topLeftCornerCol,specialRow,specialCol,temporarySize);
        }else{

        }


    }



    public static void main(String[] args) {
	// write your code here
    }
}
