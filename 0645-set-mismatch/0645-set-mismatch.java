class Solution {
    public int[] findErrorNums(int[] nums) {
        int dup = -1, missing = -1;

        // First pass: find duplicate using sign marking
        for (int num : nums) {
            int index = Math.abs(num) - 1;
            if (nums[index] < 0) {
                dup = Math.abs(num);
            } else {
                nums[index] *= -1;
            }
        }

        // Second pass: find missing (index with positive value)
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                missing = i + 1;
                break;
            }
        }

        return new int[]{dup, missing};
    }
}
