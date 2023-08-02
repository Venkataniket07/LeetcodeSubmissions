class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        int maxLength = 0;
        int start = 0;
        char[] charArray = s.toCharArray();

        for (int i = 0; i < n; i++) {
            for (int j = start; j < i; j++) {
                if (charArray[j] == charArray[i]) {
                    start = j + 1;
                    break;
                }
            }
            maxLength = Math.max(maxLength, i - start + 1);
        }

        return maxLength;
    }
}