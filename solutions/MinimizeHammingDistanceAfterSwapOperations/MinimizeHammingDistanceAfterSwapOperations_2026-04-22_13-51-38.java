class Solution {
    public int minimumHammingDistance(int[] source, int[] target, int[][] allowedSwaps) {
        int n = source.length;
        DSU dsu = new DSU(n);

        // union
        for(int[] swap : allowedSwaps) {
            dsu.union(swap[0], swap[1]);
        }

        //Map
        Map<Integer, List<Integer>> mp = new HashMap<>();
        for(int i = 0; i < n; i++) {
            int parent = dsu.find(i);
            mp.computeIfAbsent(parent, k -> new ArrayList<>()).add(i);
        }

        int ans = 0;
        for(List<Integer> values : mp.values()) {
            //freq map
            Map<Integer, Integer> freq = new HashMap<>();

            for(int idx : values) {
                freq.put(source[idx], freq.getOrDefault(source[idx], 0) + 1);
            }

            for(int idx : values) {
                if(freq.getOrDefault(target[idx], 0) > 0) {
                    freq.put(target[idx], freq.get(target[idx]) - 1);
                } else {
                    ans++;
                }
            }
        }
        return ans;
    }
}

public class DSU {
    int[] parent;

    DSU(int n) {
        parent = new int[n];
        for(int i = 0; i < n; i++) parent[i] = i;
    }

    int find(int x) {
        if(parent[x] != x) {
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }

    void union(int a, int b) {
        parent[find(a)] = find(b);
    }
}