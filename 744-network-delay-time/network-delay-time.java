class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        Map<Integer, List<int[]>> graph = new HashMap<>();
        for (int[] time : times) {
            int u = time[0];
            int v = time[1];
            int w = time[2];
            graph.putIfAbsent(u, new ArrayList<>());
            graph.get(u).add(new int[]{v, w});
        }

        int[] dist = new int[n + 1]; 
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[k] = 0; 

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        pq.add(new int[]{0, k}); 

        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int time = curr[0];
            int node = curr[1];

            if (time > dist[node]) continue;
            if (graph.containsKey(node)) {
                for (int[] neighbor : graph.get(node)) {
                    int nnode = neighbor[0];
                    int ttime = neighbor[1];
                    int ntime = time + ttime;
                    if (ntime < dist[nnode]) {
                        dist[nnode] = ntime;
                        pq.add(new int[]{ntime, nnode});
                    }
                }
            }
        }

        int min = 0;
        for (int i = 1; i <= n; i++) {
            if (dist[i] == Integer.MAX_VALUE) return -1; 
            min = Math.max(min, dist[i]);
        }

        return min;
    }
}
