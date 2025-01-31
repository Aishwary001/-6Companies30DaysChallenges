class Solution {
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        int floyd[][] = new int[n][n];
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(i==j){
                    floyd[i][j] = 0;
                }else{
                    floyd[i][j] = 100000;
                }
            }
        }
        for(int edge[] : edges){
            int u = edge[0];
            int v = edge[1];
            int wt = edge[2];
            floyd[u][v] = wt;
            floyd[v][u] = wt;
        }

        for(int via=0; via<n; via++){
            for(int j=0; j<n; j++){
                for(int k=0; k<n; k++){
                    floyd[j][k] = Math.min(floyd[j][k],floyd[j][via] + floyd[via][k]);
                }
            }
        }

        int countMin = Integer.MAX_VALUE;
        int city = 0;
        for(int i=0; i<n; i++){
            int count = 0;
            for(int j=0; j<n; j++){
                if(floyd[i][j] <= distanceThreshold){
                    count++;
                }
            }
            if(count <= countMin){
              countMin = count;
              city = Math.max(city,i);
            }
        }
        return city;
    }
}
