class Router {
    private int limit;
    private Queue<int[]> q;
    private Set<String> seen;
    private Map<Integer, List<Integer>> timestamps;

    public Router(int memoryLimit) {
        limit = memoryLimit;
        q = new LinkedList<>();
        seen = new HashSet<>();
        timestamps = new HashMap<>();
    }

    public boolean addPacket(int source, int destination, int timestamp) {
        String key = source + "," + destination + "," + timestamp;

        if (seen.contains(key)) return false;

        if (q.size() == limit) {
            int[] old = q.poll();
            String oldKey = old[0] + "," + old[1] + "," + old[2];
            seen.remove(oldKey);

            List<Integer> list = timestamps.get(old[1]);
            list.remove(0); // remove from front
            if (list.isEmpty()) timestamps.remove(old[1]);
        }

        int[] packet = new int[]{source, destination, timestamp};
        q.offer(packet);
        seen.add(key);
        timestamps.computeIfAbsent(destination, k -> new ArrayList<>()).add(timestamp);

        return true;
    }

    public int[] forwardPacket() {
        if (q.isEmpty()) return new int[0];

        int[] packet = q.poll();
        String key = packet[0] + "," + packet[1] + "," + packet[2];
        seen.remove(key);

        List<Integer> list = timestamps.get(packet[1]);
        list.remove(0);
        if (list.isEmpty()) timestamps.remove(packet[1]);

        return packet;
    }

    public int getCount(int destination, int startTime, int endTime) {
        if (!timestamps.containsKey(destination)) return 0;

        List<Integer> list = timestamps.get(destination);
        int left = lowerBound(list, startTime);
        int right = upperBound(list, endTime);
        return right - left;
    }

    private int lowerBound(List<Integer> list, int target) {
        int l = 0, r = list.size();
        while (l < r) {
            int m = (l + r) / 2;
            if (list.get(m) < target) l = m + 1;
            else r = m;
        }
        return l;
    }

    private int upperBound(List<Integer> list, int target) {
        int l = 0, r = list.size();
        while (l < r) {
            int m = (l + r) / 2;
            if (list.get(m) <= target) l = m + 1;
            else r = m;
        }
        return l;
    }
}


/**
 * Your Router object will be instantiated and called as such:
 * Router obj = new Router(memoryLimit);
 * boolean param_1 = obj.addPacket(source,destination,timestamp);
 * int[] param_2 = obj.forwardPacket();
 * int param_3 = obj.getCount(destination,startTime,endTime);
 */