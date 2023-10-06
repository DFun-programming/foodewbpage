

class Solution {
    int solveMem(  int index,int buy , int limit, int[] prices , int[][][] dp)
    {
        int profit = 0;
        if(index >= prices.length)
            return 0;
        if(limit == 0)
            return 0;
        if(dp[index][buy][limit] != -1)
            return dp[index][buy][limit];
        if(buy == 1)
        {
            int buyKar = -prices[index] + solveMem(index + 1 , buy - 1 , limit , prices , dp);
            int ignore = 0 + solveMem(index + 1 , buy , limit , prices , dp );
            profit = Math.max(buyKar , ignore);  
        }
        else
        {
            int sellKar= prices[index] + solveMem(index + 1 , buy + 1 , limit - 1 , prices , dp );
            int ignore = 0 +  solveMem(index + 1 , buy , limit  , prices , dp );
            profit = Math.max(sellKar , ignore);

        }
        return dp[index][buy][limit] = profit;
    }
    public int maxProfit(int k, int[] prices) {
        int[][][] dp = new int[prices.length + 1][2][k+1];
    for(int[][] row : dp) 
    {
        for(int[] col : row) 
            Arrays.fill(col, -1);
    }
    return solveMem(0 , 1 , k , prices , dp );

    }
    
}
