class Solution {
    public boolean splitArraySameAverage(int[] nums) {
        int n = nums.length;
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }

        // dp[i][j] represents whether it is possible to select j elements from nums to get the sum of i
        boolean[][] dp = new boolean[sum + 1][n + 1];
        dp[0][0] = true;

        for (int num : nums) {
            for (int i = sum; i >= num; i--) {
                for (int j = 1; j <= n / 2; j++) {
                    dp[i][j] |= dp[i - num][j - 1];
                }
            }
        }

        for (int lenA = 1; lenA <= n / 2; lenA++) {
            if (sum * lenA % n == 0 && dp[sum * lenA / n][lenA]) {
                return true;
            }
        }

        return false;
    }
}