class Solution(object):
    def closestPrimes(self, left, right):
        limit = 10**6
        is_prime = [True] * (limit + 1)
        is_prime[0] = is_prime[1] = False 
        for i in range(2, int(limit**0.5) + 1):
            if is_prime[i]:
                for j in range(i * i, limit + 1, i):
                    is_prime[j] = False
        primes = [i for i in range(max(2, left), right + 1) if is_prime[i]]
        if len(primes) < 2:
            return [-1, -1]
        min_diff = float('inf')
        result = [-1, -1]
        for i in range(1, len(primes)):
            diff = primes[i] - primes[i - 1]
            if diff < min_diff:
                min_diff = diff
                result = [primes[i - 1], primes[i]]
        return result
            