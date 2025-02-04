class Solution:
    def findRestaurant(self, list1: List[str], list2: List[str]) -> List[str]:
        res=[] 
        mini=float('inf')
        index_map={word:idx for idx,word in enumerate(list2)}
        for i,word in enumerate(list1):
            if word in index_map:
                total_index=i+index_map[word]
                if total_index<mini:
                    res=[word]
                    mini=total_index
                elif total_index==mini:
                    res.append(word)
        return res    