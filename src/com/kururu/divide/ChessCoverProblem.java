package com.kururu.divide;

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
/*
input the power k:
4
input the special case row number:
12
input the special case col number:
13
4	4	5	5	9	9	10	10	25	25	26	26	30	30	31	31
4	3	3	5	9	8	8	10	25	24	24	26	30	29	29	31
6	3	7	7	11	11	8	12	27	24	28	28	32	32	29	33
6	6	7	2	2	11	12	12	27	27	28	23	23	32	33	33
14	14	15	2	19	19	20	20	35	35	36	36	23	40	41	41
14	13	15	15	19	18	18	20	35	34	34	36	40	40	39	41
16	13	13	17	21	18	22	22	37	37	34	38	42	39	39	43
16	16	17	17	21	21	22	1	1	37	38	38	42	42	43	43
46	46	47	47	51	51	52	1	67	67	68	68	72	72	73	73
46	45	45	47	51	50	52	52	67	66	66	68	72	71	71	73
48	45	49	49	53	50	50	54	69	66	70	70	74	74	71	75
48	48	49	44	53	53	54	54	69	69	70	65	65	74	75	75
56	56	57	44	44	61	62	62	77	77	78	65	82	0	83	83
56	55	57	57	61	61	60	62	77	76	78	78	82	82	81	83
58	55	55	59	63	60	60	64	79	76	76	80	84	81	81	85
58	58	59	59	63	63	64	64	79	79	80	80	84	84	85	85
 */
