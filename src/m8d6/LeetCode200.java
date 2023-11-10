package m8d6;

/**
 * 岛屿数量
 * 思路：将1附近的1都标注一下即可
 */
public class LeetCode200 {

    public static void main(String[] args) {
        int i = numIslands(new char[][]{
                {'1', '1', '1', '1', '0'},
                {'1', '1', '0', '1', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '0', '0', '0'}});
        System.out.println(i);
    }

    public static int numIslands(char[][] grid) {
        int num = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    expand(grid, i, j);
                    num++;
                }
            }
        }
        return num;
    }

    public static void expand(char[][] grid, int i, int j) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length ||
                grid[i][j] != '1') {
            return;
        }
        grid[i][j] = '2';
        expand(grid, i - 1, j);
        expand(grid, i + 1, j);
        expand(grid, i, j - 1);
        expand(grid, i, j + 1);
    }
}
