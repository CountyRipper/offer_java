public class lc64 {
    public int minPathSum(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        // for(int i = 0;i<row;i++){
        //     for(int j = 0; j<col;j++){
        //         if(i==0&&j==0) continue;
        //         else if(i==0) grid[i][j]+=grid[i][j-1];
        //         else if(j==0) grid[i][j]+=grid[i-1][j];
        //         else grid[i][j] = Math.min(grid[i-1][j], grid[i][j-1])+grid[i][j];
        //     }
        // }
        // return grid[row-1][col-1];
        int [][]dp = new int[row+1][col+1];
        for(int i=1; i<col;i++){
            dp[i][0] = dp[i-1][0]+grid[i][0];
        }
        for(int j=1; j<row;j++){
            dp[0][j] = dp[0][j-1]+grid[0][j];
        }
        for(int i=1;i<row;i++){
            for(int j = 1; j<col;j++){
                dp[i][j] = Math.min(dp[i-1][j], dp[i][j-1])+grid[i-1][j-1];
            }
        }
        return dp[row-1][col-1];
    }
}
