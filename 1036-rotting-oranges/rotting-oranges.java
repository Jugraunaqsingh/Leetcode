class Solution {
    int count=0;
    public int orangesRotting(int[][] grid) {
        if(grid == null || grid.length == 0) return -1;

        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==2){
                    dfs(grid,i,j,2);
                }
            }
        }
        int min=2;
        for(int[] r:grid){
            for(int c:r){
                if(c==1) return -1;
                min=Math.max(min,c);
            }
        }
        return min-2;


    }
    public void dfs(int[][] grid,int i,int j,int min){
        if(i<0||i>=grid.length||j<0||j>=grid[0].length||grid[i][j]==0||(1 < grid[i][j] && grid[i][j] < min)) return;
        else{
            grid[i][j]=min;
            
            dfs(grid,i+1,j,min+1);
            dfs(grid,i-1,j,min+1);
            dfs(grid,i,j+1,min+1);
            dfs(grid,i,j-1,min+1);
        
        }

    }
}