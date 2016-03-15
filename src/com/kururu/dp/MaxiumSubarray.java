package com.kururu.dp;

/**
 * Created by Ellery Queen on 2016/3/15.
 */
public class MaxiumSubarray {

    public int maxSubarrayUsingDP(int[] array){
        int n = array.length;
        int[] dp = new int[n];
        dp[0] = array[0];
        int max = dp[0];
        for(int i = 1;i < n;i++){
            dp[i] = array[i] + (dp[i-1]>0?dp[i-1]:0);
            max = Math.max(max,dp[i]);
        }
        return max;
    }

    public static void main(String[] args) {
        int[] array = {-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(new MaxiumSubarray().maxSubarrayUsingDP(array));
    }
}
