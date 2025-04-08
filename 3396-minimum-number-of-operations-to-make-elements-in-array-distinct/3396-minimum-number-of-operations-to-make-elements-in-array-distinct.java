class Solution {
    public int minimumOperations(int[] nums) {
          List<Integer> list = new ArrayList<>();
        for (int num : nums) list.add(num);
        int ops = 0;
        
        while (hasDuplicates(list)) {
            int removeCount = Math.min(3, list.size());
            for (int i = 0; i < removeCount; i++) {
                list.remove(0);
            }
            ops++;
        }
        
        return ops;    
    }
    private boolean hasDuplicates(List<Integer> list) {
        Set<Integer> set = new HashSet<>(list);
        return set.size() < list.size();
    }
}

