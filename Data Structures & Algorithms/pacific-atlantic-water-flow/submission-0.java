class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> result = new ArrayList<>();

        if(heights == null || heights.length == 0 || heights[0].length == 0) {
            return List.of();
        }

        int rows = heights.length;
        int cols = heights[0].length;

        boolean[][] pacific = new boolean[rows][cols];
        boolean[][] atlantic = new boolean[rows][cols];

        // start search from left (pacific) and right (atlantic)
        for(int r=0; r < rows; r++) {
            dfs(r, 0, pacific, heights, heights[r][0]); // left border
            dfs(r, cols-1, atlantic, heights, heights[r][cols-1]); // right border
        }
        // start search from top (pacific) and bottom (atlantic)
        for(int c=0; c < cols; c++) {
            dfs(0, c, pacific, heights, heights[0][c]); // top border
            dfs(rows-1, c, atlantic, heights, heights[rows-1][c]); // bottom border
        }

        // collect result
        for(int r=0; r<rows; r++) {
            for(int c = 0; c<cols; c++) {
                if(pacific[r][c] && atlantic[r][c]) {
                    result.add(Arrays.asList(r, c));
                }
            }
        }

        return result;
    }

    private void dfs(int r, int c, boolean[][] ocean, int[][] heights, int prevHeight) {

        if(r < 0 || r >= heights.length || c < 0 || c >= heights[0].length || ocean[r][c] || heights[r][c] < prevHeight) {
            return;
        }

        // mark as visited/reachable 
        ocean[r][c] = true;

        dfs(r+1, c, ocean, heights, heights[r][c]); // down
        dfs(r-1, c, ocean, heights, heights[r][c]); // up
        dfs(r, c+1, ocean, heights, heights[r][c]); // right
        dfs(r, c-1, ocean, heights, heights[r][c]); // left
    }
}
