class Solution {
    public int numIslands(char[][] grid) {
        if(grid == null || grid.length == 0) {
            return 0;
        }

        int rows = grid.length;
        int cols = grid[0].length;
        int islands = 0;

        for(int r = 0; r < rows; r++) {
            for(int c = 0; c < cols; c++) {
                if(grid[r][c] == '1') {
                    islands++;
                    depthFirstSearch(grid, r, c);
                }
            }
        }

        return islands;
    }

    private void depthFirstSearch(char[][] grid, int r, int c) {
        int rows = grid.length;
        int cols = grid[0].length;

        // Conditions for termination, including water (== 0)
        if(r < 0 || r >= rows || c < 0 || c >= cols || grid[r][c] == '0') {
            return;
        }

        // visited
        grid[r][c] = '0';

        depthFirstSearch(grid, r+1, c); // down
        depthFirstSearch(grid, r-1, c); // top
        depthFirstSearch(grid, r, c-1); // left
        depthFirstSearch(grid, r, c+1); // right
    }
}
