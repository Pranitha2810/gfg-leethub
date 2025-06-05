class Solution:
    def isSubsetSum (self, arr, sum):
        subsetSum=0
        return self.subsetSum(0,arr,sum,subsetSum)
            
    def subsetSum(self,index,arr,sum,subsetSum):
        if subsetSum>sum:
            return False
        if index==len(arr):
            if subsetSum==sum:
                return True
            return False
        
        subsetSum+=arr[index]
        if self.subsetSum(index+1,arr,sum,subsetSum):
            return True
        subsetSum-=arr[index]
        if self.subsetSum(index+1,arr,sum,subsetSum):
            return True
        return False
        
        