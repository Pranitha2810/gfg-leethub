class Solution:
    def findMissingAndRepeatedValues(self, grid: List[List[int]]) -> List[int]:
        n = len(grid)
        N = n * n
        sn = (N * (N + 1)) // 2
        s2n = (N * (N + 1) * (2 * N + 1)) // 6

        sum1 = 0
        sum2 = 0

        for i in range(n):
            for j in range(n):
                sum1 += grid[i][j]
                sum2 += grid[i][j] ** 2

        val1 = sn - sum1
        val2 = (s2n - sum2) // val1
        x = (val1 + val2) // 2
        y = x - val1

        return [int(y), int(x)]
