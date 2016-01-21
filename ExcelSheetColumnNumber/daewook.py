class Solution(object):
    def titleToNumber(self, s):
        """
        :type s: str
        :rtype: int
        """
        res = 0
        for idx in range(len(s)):
            res += pow(26,len(s)-idx-1)*(ord(s[idx])-ord('A')+1)
        return res
