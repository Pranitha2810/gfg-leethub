class Solution {
    public long repairCars(int[] ranks, int cars) {
         Arrays.sort(ranks);
        long left = 1, right = (long) ranks[0] * (long) cars * cars;
        while (left < right) {
            long mid = left + (right - left) / 2;
            if (canRepairAllCars(ranks, cars, mid)) {
                right = mid; // Try to minimize time
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
    private boolean canRepairAllCars(int[] ranks, int cars, long time) {
        int repaired = 0;
        for (int rank : ranks) {
            repaired += (int) Math.sqrt(time / rank);
            if (repaired >= cars) return true; // No need to check further
        }
        return false;
    }
}