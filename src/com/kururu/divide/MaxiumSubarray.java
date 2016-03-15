package com.kururu.divide;

/**
 * Created by yhmsc on 2016/3/15.
 */
public class MaxiumSubarray {

    public static int max_left_index = 0;
    public static int max_right_index = 0;

    public int bynarySearchSumForCross(int array[],int left,int mid,int right){
        int leftSum = Integer.MIN_VALUE;
        int sum = 0;
        for(int i = mid; i > left - 1;i--){
            sum += array[i];
            if(sum > leftSum){
                leftSum = sum;
                max_left_index = i;
            }
        }

        sum = 0;
        int rightSum = Integer.MIN_VALUE;
        for(int i = mid + 1; i < right + 1;i++){
            sum += array[i];
            if(sum > rightSum){
                rightSum = sum;
                max_right_index = i;
            }
        }
        return leftSum + rightSum;
    }

    public int bynarySearchSum(int array[],int left,int right){
        int leftMaxSum, rightMaxSum, crossMaxSum;
        if(left == right)   return array[left];
        int mid = (left + right)/2;
        leftMaxSum = bynarySearchSum(array,left,mid);
        rightMaxSum = bynarySearchSum(array,mid+1,right);
        crossMaxSum = bynarySearchSumForCross(array,left,mid,right);
        return leftMaxSum > rightMaxSum ?
                (leftMaxSum > crossMaxSum ? leftMaxSum : crossMaxSum) : (rightMaxSum > crossMaxSum ? rightMaxSum : crossMaxSum);
    }

    public static void main(String[] args) {
        int[] array = {-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(new MaxiumSubarray().bynarySearchSum(array,0,array.length-1));
        System.out.println(max_left_index + 1);
        System.out.println(max_right_index + 1);
    }
}
