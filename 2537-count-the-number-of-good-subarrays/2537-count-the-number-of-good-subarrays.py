from collections import defaultdict
class Solution:
    def countGood(self, nums: List[int], k: int) -> int:
        n = len(nums)
        left = 0
        right = 0
        good_subarrays = 0
        freq = defaultdict(int)
        equal_pairs = 0
        while left < n:
            while right < n and equal_pairs < k:
                freq[nums[right]] += 1
                if freq[nums[right]] >= 2:
                    equal_pairs += freq[nums[right]] - 1
                right += 1
            
            if equal_pairs >= k:
                good_subarrays += n - right + 1

            # Removing left item
            freq[nums[left]] -= 1
            if freq[nums[left]] > 0:
                equal_pairs -= freq[nums[left]]
            left += 1
        return good_subarrays      