import java.util.*;

class Solution {
    public int maxTaskAssign(int[] tasks, int[] workers, int pills, int strength) {
        Arrays.sort(tasks);
        Arrays.sort(workers);

        int left = 0, right = Math.min(tasks.length, workers.length);
        int ans = 0;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (canAssign(tasks, workers, pills, strength, mid)) {
                ans = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return ans;
    }

    private boolean canAssign(int[] tasks, int[] workers, int pills, int strength, int k) {
        Deque<Integer> availableWorkers = new ArrayDeque<>();
        int m = workers.length;

        // Take the last k workers (strongest ones)
        for (int i = m - k; i < m; i++) {
            availableWorkers.addLast(workers[i]);
        }

        int remainingPills = pills;
        for (int i = k - 1; i >= 0; i--) {
            int task = tasks[i];
            if (!availableWorkers.isEmpty() && availableWorkers.peekLast() >= task) {
                availableWorkers.pollLast();
            }
            else if (!availableWorkers.isEmpty() && availableWorkers.peekFirst() + strength >= task && remainingPills > 0) {
                availableWorkers.pollFirst();
                remainingPills--;
            }
            else {
                return false;
            }
        }

        return true;
    }
}
