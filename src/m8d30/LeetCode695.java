package m8d30;

/**
 * 岛屿的最大面积
 * 思路：
 *  盲猜DP，猜错了，是dfs，因为这个即使dp判断的不是相邻的，而是连接的
 * @author clearlove3
 */
public class LeetCode695 {
    public  int maxAreaOfIsland(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        int max = 0;
        for(int i=0; i<row; i++) {
            for(int j=0; j<col; j++) {
                // 深度优先遍历
                max = Math.max(max, dfs(grid, i, j));
            }
        }
        return max;
    }
    private static int dfs(int[][] grid,int x,int y){
        // 边界检查
        // 数组为0 直接返回
        if(x < 0 || x >= grid.length || y < 0 || y >= grid[0].length || grid[x][y] == 0) {
            return 0;
        }
        // 不为0 即为1  修改成0 避免下次再计算到
        grid[x][y] = 0;

        // 当前出发， 向上下左右四个方向出发
        return 1 + dfs(grid, x+1, y) + dfs(grid, x-1, y) + dfs(grid, x, y+1) + dfs(grid, x, y-1);

    }
}
