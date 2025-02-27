import java.util.*;

class Solution {
    public int lenLongestFibSubseq(int[] arr) {
        int n = arr.length;
        HashSet<Integer> s = new HashSet<>();
        for (int x : arr) {
            s.add(x);
        }

        HashMap<Integer, Integer> mp = new HashMap<>();
        for (int i = 0; i < n; i++) {
            mp.put(arr[i], i);
        }

        HashMap<String, Integer> dp = new HashMap<>();
        int res = 0;

        for (int j = n - 1; j >= 0; j--) {
            for (int i = j - 1; i >= 0; i--) {
                int prev = arr[i];
                int cur = arr[j];
                int nxt = prev + cur;
                int len = 2;

                if (s.contains(nxt)) {
                    int k = mp.get(nxt);
                    String key = j + "," + k; // Using String key instead of int[]
                    len = 1 + dp.getOrDefault(key, 2);
                    res = Math.max(res, len);
                }

                dp.put(i + "," + j, len);
            }
        }

        return res > 2 ? res : 0;
    }
}
