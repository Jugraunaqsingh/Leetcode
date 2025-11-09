class Solution {
    public int maximumDetonation(int[][] bombs) {
        int max=1;

        for(int i=0;i<bombs.length;i++){
            boolean[] vis=new boolean[bombs.length];
            int nmax=dfs(bombs,i,vis);
            max=Math.max(nmax,max);
        }
        return max;

    }
    public int dfs(int[][] bombs,int i,boolean[] vis){
        vis[i]=true;
        int count=1;
        for(int j=0;j<bombs.length;j++){
            if(vis[j]!=true){
                double dist=Math.sqrt(Math.pow(bombs[i][0]-bombs[j][0],2)+Math.pow(bombs[i][1]-bombs[j][1],2));
                if(dist<=bombs[i][2]){
                    count+=dfs(bombs,j,vis);
                }
            }
        }
        return count;

    }
}