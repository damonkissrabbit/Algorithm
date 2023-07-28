package DynamicProgramming;



public class MinimumCostClimbStairs {

    public static int minCostClimbingStairs (int[] cost) {
        int[] dp = new int[cost.length + 1];
        for(int i = 2; i <= cost.length; i++)
            //每次选取最小的方案
            dp[i] = Math.min(dp[i - 1] + cost[i - 1], dp[i - 2] + cost[i - 2]);
        return dp[cost.length];
    }

    public static void main(String[] args) {
        int[] a = {1,100,1,1,1,90,1,1,80,1};
        int result = minCostClimbingStairs(a);
        System.out.println(result);
    }
}
