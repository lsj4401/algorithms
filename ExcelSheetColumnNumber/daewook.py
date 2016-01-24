class Solution(object):
    def titleToNumber(self, s):
        """
        :type s: str
        :rtype: int
        """
        res = 0
        strLen = len(s)
        for idx in range(strLen):
            res += pow(26,strLen-idx-1)*(ord(s[idx])-ord('A')+1)
        return res
