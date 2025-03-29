import heapq
from collections import deque

MOD = 10**9 + 7

class Solution:
    def calculateScore(self, nums):
        score = []
        for ele in nums:
            count = 0
            i = 2
            while i * i <= ele:
                if ele % i == 0:
                    count += 1
                    while ele % i == 0:
                        ele //= i
                i += 1
            if ele > 1:
                count += 1
            score.append(count)
        return score

    def calculateSubarrayCountPerScore(self, score):
        n = len(score)
        pge = [-1] * n
        nge = [n] * n  # Next Greater Element
        stack = deque()

        # Calculate Previous Greater Element (PGE)
        for i in range(n):
            while stack and score[stack[-1]] < score[i]:
                stack.pop()
            if stack:
                pge[i] = stack[-1]
            stack.append(i)

        # Calculate Next Greater Element (NGE)
        stack.clear()
        for i in range(n - 1, -1, -1):
            while stack and score[stack[-1]] <= score[i]:
                stack.pop()
            if stack:
                nge[i] = stack[-1]
            stack.append(i)

        # Compute subarray counts
        subarray_count = [(nge[i] - i) * (i - pge[i]) for i in range(n)]
        return subarray_count

    def binaryExponentiation(self, a, b):
        res = 1
        a %= MOD
        while b > 0:
            if b & 1:
                res = (res * a) % MOD
            a = (a * a) % MOD
            b >>= 1
        return res

    def maximumScore(self, nums, k):
        n = len(nums)
        score = self.calculateScore(nums)
        subarray_count = self.calculateSubarrayCountPerScore(score)

        # Use a max-heap to prioritize the largest numbers
        max_heap = []
        for i in range(n):
            heapq.heappush(max_heap, (-nums[i], subarray_count[i]))

        res = 1
        while k > 0 and max_heap:
            num, cnt = heapq.heappop(max_heap)
            num = -num
            use_cnt = min(k, cnt)  # Ensure we do not exceed k
            res = (res * self.binaryExponentiation(num, use_cnt)) % MOD
            k -= use_cnt

        return res   