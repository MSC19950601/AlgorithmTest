package com.kururu.divide;


import java.util.Scanner;

/**
 * Created by Ellery Queen on 2016/3/17.
 */
public class ChooseElement {

    private static void sort(Comparable[] a, int lo, int hi) {
        if (hi <= lo) return;
        int j = partition(a, lo, hi);
        sort(a, lo, j-1);
        sort(a, j+1, hi);
        assert isSorted(a, lo, hi);
    }

    private static int partition(Comparable[] a, int lo, int hi) {
        int i = lo;
        int j = hi + 1;
        Comparable v = a[lo];
        while (true) {
            while (less(a[++i], v))
                if (i == hi) break;
            while (less(v, a[--j]))
                if (j == lo) break;
            if (i >= j) break;
            exch(a, i, j);
        }
        exch(a, lo, j);
        return j;
    }

    private static boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }

    private static void exch(Object[] a, int i, int j) {
        Object swap = a[i];
        a[i] = a[j];
        a[j] = swap;
    }

    private static boolean isSorted(Comparable[] a) {
        return isSorted(a, 0, a.length - 1);
    }

    private static boolean isSorted(Comparable[] a, int lo, int hi) {
        for (int i = lo + 1; i <= hi; i++)
            if (less(a[i], a[i-1])) return false;
        return true;
    }

    private static void print(Comparable[] a){
        for(int i = 0;i < a.length;i++){
            System.out.print(a[i] + "\t");
            if(i%10 == 9){
                System.out.print("\n");
            }
        }
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Integer[] array = new Integer[100];
        for(int i = 0;i < 100;i++){
            array[i] = (int)(Math.random()*(100) + 13);
        }
        print(array);
        sort(array,0,array.length-1);
        System.out.print("\n");
        print(array);
        int k = scanner.nextInt();
        System.out.println("第"+k+"小元素为："+array[k-1]);
    }
}
