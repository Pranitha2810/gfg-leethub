class Solution:
    def queryResults(self, limit: int, queries: List[List[int]]) -> List[int]:
        from collections import defaultdict

class Solution:
    def queryResults(self, limit: int, queries: list[list[int]]) -> list[int]:
        res = []
        d = {}  
        color_count = defaultdict(int)  
        unique = set()  
        
        for key, val in queries:
            if key in d:
                old_color = d[key]
                color_count[old_color] -= 1
                if color_count[old_color] == 0:  
                    unique.discard(old_color)
            d[key] = val
            color_count[val] += 1
            unique.add(val)
            res.append(len(unique))
        
        return res