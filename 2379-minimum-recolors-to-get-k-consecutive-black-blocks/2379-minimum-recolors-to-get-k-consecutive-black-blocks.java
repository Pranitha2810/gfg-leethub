class Solution {
    public int minimumRecolors(String blocks, int k) {
        int n = blocks.length();
        int whiteCount = 0, minOps;

        for (int i = 0; i < k; i++) {
            if (blocks.charAt(i) == 'W') {
                whiteCount++;
            }
        }

        minOps = whiteCount;

        for (int i = k; i < n; i++) {
            if (blocks.charAt(i - k) == 'W') {
                whiteCount--;
            }
            if (blocks.charAt(i) == 'W') {
                whiteCount++;
            }
            minOps = Math.min(minOps, whiteCount);
        }

        return minOps;
    }
}