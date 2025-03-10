class Solution:
    def countOfSubstrings(self, word: str, k: int) -> int:
        n = len(word)
        next_consonant = [0] * n
        self.nextConsonant(next_consonant, n, word)
        
        l, r, p, c = 0, 0, -1, 0
        mp = {}
        count = 0
        
        while r < n:
            if p != r:
                if self.isVowel(word[r]):
                    mp[word[r]] = mp.get(word[r], 0) + 1
                else:
                    c += 1
                p = r
            
            if r >= (5 + k - 1):
                if len(mp) == 5 and c == k:
                    count += next_consonant[r] - r
                
                if (len(mp) == 5 and c == k) or c > k:
                    if self.isVowel(word[l]):
                        mp[word[l]] -= 1
                        if mp[word[l]] == 0:
                            del mp[word[l]]
                    else:
                        c -= 1
                    l += 1
                else:
                    r += 1
            else:
                r += 1
        
        return count

    def nextConsonant(self, nc, n, s):
        next_idx = n
        for i in range(n - 1, -1, -1):
            nc[i] = next_idx
            if not self.isVowel(s[i]):
                next_idx = i
    
    def isVowel(self, ch):
        return ch in {'a', 'e', 'i', 'o', 'u'}