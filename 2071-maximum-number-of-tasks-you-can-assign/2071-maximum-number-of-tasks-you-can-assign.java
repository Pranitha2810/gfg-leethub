class Solution {
    public int maxTaskAssign(int[] tasks, int[] workers, int pills, int strength) {
        Arrays.sort(tasks);
        Arrays.sort(workers);
        
        int low = 0;
        int high = Math.min(tasks.length, workers.length);
        int assigned = 0;
        
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (canAssign(mid, workers, tasks, pills, strength)) {
                assigned = mid;
                low = mid + 1;
            } else
                high = mid - 1;
        }
        return assigned;
    }
    private boolean canAssign(int mid, int[] workers, int[] tasks, int pills, int strength)
    {
        TreeMap<Integer, Integer> usableWorkers = new TreeMap<>();
        int n = workers.length;
        for (int i = n - mid; i < n; i++)
            usableWorkers.put(workers[i], usableWorkers.getOrDefault(workers[i], 0) + 1);

        for (int i = mid - 1; i >= 0; --i)
        {
            int task = tasks[i];
            Integer currWorker = usableWorkers.lastKey();
            
            if (currWorker < task)
            {
                if (pills <= 0)
                    return false;
                
                // Find the weakest worker who can do the task with pill
                Integer weakestWorker = usableWorkers.ceilingKey(task - strength);
                if (weakestWorker == null)
                    return false;
                
                pills--;

                usableWorkers.put(weakestWorker, usableWorkers.get(weakestWorker) - 1);
                if (usableWorkers.get(weakestWorker) == 0)
                    usableWorkers.remove(weakestWorker);

            } 
            else
            {
                usableWorkers.put(currWorker, usableWorkers.get(currWorker) - 1);
                if (usableWorkers.get(currWorker) == 0)
                    usableWorkers.remove(currWorker);
            }
        }
        return true;
    }
}