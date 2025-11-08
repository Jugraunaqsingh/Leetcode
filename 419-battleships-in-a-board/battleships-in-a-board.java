class Solution {
    int count=0;

    public int countBattleships(char[][] board) {
        int[][] dir={{1,0},{-1,0},{0,1},{0,-1}};
        
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                if(board[i][j]=='X'){
                    
                    dfs(board,i,j,dir);
                    count++;

                }
            }
        }
        return count;
    }
    public void dfs(char[][] board,int i,int j,int[][] dir){
        board[i][j]='.';
        for(int[] d:dir){
            int x=i+d[0];
            int y=j+d[1];
            if(x>=0&&x<board.length&&y>=0&&y<board[0].length&&board[x][y]=='X'){
                dfs(board,x,y,dir);
            }
        }

    }
}