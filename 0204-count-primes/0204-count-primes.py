import math
class Solution:
    def countPrimes(self, n: int) -> int:
        if n <= 2:
            return 0
        primes=[1]*(n)
        primes[0]=0
        primes[1]=0
        for i in range(2,int(math.sqrt(n))+1):
            if primes[i]==1:
                for j in range(i*i,n,i):
                    primes[j]=0
        return sum(primes)