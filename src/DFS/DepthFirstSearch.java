package DFS;

public class DepthFirstSearch {

    public static void main(String[] args) {

        char[][] grid = {
                {'1', '1', '0'},
                {'0', '1', '0'},
                {'1', '1', '1'}
        };

        char[][] grid2 = {
                {'1','1','0','0','0'},
                {'1','1','0','0','0'},
                {'0','0','1','0','0'},
                {'0','0','0','1','1'}
        };

        System.out.println(countOfIslands(grid));
        System.out.println(countOfIslands(grid2));

    }

    // O(N^2) Time
    // O(1) Space
    public static int countOfIslands(char[][] grid) {
        int cols = grid.length;
        int rows = grid[0].length;
        int countOfIslands = 0;

        for (int i = 0; i < cols - 1; i++) {
            for (int j = 0; j < rows - 1; j++) {
                if (grid[i][j] == '1') {
                    countOfIslands += 1;
                    dfs(grid, i, j);
                }
            }
        }
        return countOfIslands;
    }

    private static void dfs(char[][] grid, int i, int j) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] == '0') {
            return;
        }
        grid[i][j] = '0';
        dfs(grid, i + 1, j);
        dfs(grid, i - 1, j);
        dfs(grid, i, j + 1);
        dfs(grid, i, j - 1);
    }

}
