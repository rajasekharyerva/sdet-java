package sdet.strings;

public class LongestCommonSubsequence {
    public static String findLCS(String X, String Y) {
        int m = X.length();
        int n = Y.length();
        int[][] dp = new int[m + 1][n + 1];

        // Fill the DP table
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (X.charAt(i - 1) == Y.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        // Corrected Traceback to find the LCS string
        StringBuilder lcs = new StringBuilder();
        int i = m, j = n;
        while (i > 0 && j > 0) {
            // Match: add character and move diagonally
            if (X.charAt(i - 1) == Y.charAt(j - 1)) {
                lcs.append(X.charAt(i - 1));
                i--;
                j--;
            }
            // Mismatch: move toward the larger DP value
            else if (dp[i - 1][j] > dp[i][j - 1]) {
                i--;
            } else {
                j--;
            }
        }

        return lcs.reverse().toString(); // Reverse to get the correct order
    }

    public static void main(String[] args) {
        String X = "ABCBDAB";
        String Y = "BDCAB";
        String lcs = findLCS(X, Y);
        System.out.println("Longest Common Subsequence: " + lcs);
    }
}