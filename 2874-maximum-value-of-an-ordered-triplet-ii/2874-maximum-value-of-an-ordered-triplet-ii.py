class Solution:
    def maximumTripletValue(self, nums: List[int]) -> int:
        n=len(nums)
        max_triplet=0
        max_difference=0
        max_left=0
        for i in range(n):
            max_triplet=max(max_triplet,max_difference*nums[i])
            max_difference=max(max_difference,max_left-nums[i])
            max_left=max(max_left,nums[i])
        return max_triplet
            

        