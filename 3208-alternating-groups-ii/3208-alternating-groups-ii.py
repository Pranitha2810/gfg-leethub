class Solution:
    def numberOfAlternatingGroups(self, colors: List[int], k: int) -> int:
        n=len(colors)
        ans=0
        l=0
        limit=n+k-1
        while l<n:
            r=l+1
            while r<limit and colors[(r-1)%n] != colors[r%n]:
                r+=1
            if (r-l)>=k:
                ans+=(r-l)-k+1
            l=r
        return ans