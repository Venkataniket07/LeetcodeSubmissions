class Solution {
    public boolean isMatch(String s, String p) {
        return isMatchHelper(s, p, 0, 0);
    }

    private boolean isMatchHelper(String s, String p, int i, int j) {
        if (j == p.length()) {
            return i == s.length();
        }

        boolean firstMatch = (i < s.length()) && (s.charAt(i) == p.charAt(j) || p.charAt(j) == '.');

        if (j + 1 < p.length() && p.charAt(j + 1) == '*') {
            return (isMatchHelper(s, p, i, j + 2)) || (firstMatch && isMatchHelper(s, p, i + 1, j));
        } else {
            return firstMatch && isMatchHelper(s, p, i + 1, j + 1);
        }
    }
}