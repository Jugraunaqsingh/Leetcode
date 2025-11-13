class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int[][] dir={{0,1},{0,-1},{1,0},{-1,0}};
        int m=image.length;
        int n=image[0].length;
        Queue<int[]> q=new LinkedList<>();
        q.add(new int[]{sr,sc});
        boolean[][] vis=new boolean[m][n];

        while(!q.isEmpty()){
            int[] temp=q.poll();
            int cr=temp[0];
            int cc=temp[1];
            vis[cr][cc]=true;
            int col=image[cr][cc];
            for(int[] d:dir){
                int pr=cr+d[0];
                int pc=cc+d[1];
                if(pr>=0&&pr<m&&pc>=0&&pc<n&&!vis[pr][pc]&&col==image[pr][pc]){
                    q.add(new int[]{pr,pc});
                }
            }
            image[cr][cc]=color;
        }
        return image;

    }
}