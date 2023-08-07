package DynamicProgramming;

public class LongestCommonSubstring {

    public String LCS(String str1, String str2) {
        int maxLength = 0;
        int maxLastIndex = 0;

        int[][] dp = new int[str1.length() + 1][str2.length() + 1];
        for (int i = 0; i < str1.length(); i++) {
            for (int j = 0; j < str2.length(); j++) {
                if (str1.charAt(i) == str2.charAt(j)) {
                    dp[i + 1][j + 1] = dp[i][j] + 1;
                    if (dp[i + 1][j + 1] > maxLength) {
                        maxLength = dp[i + 1][j + 1];
                        maxLastIndex = i;
                    }
                } else {
                    dp[i + 1][j + 1] = 0;
                }
            }
        }
        return str1.substring(maxLastIndex - maxLength + 1, maxLastIndex + 1);
    }


    public static void main(String[] args) {

    }
}
