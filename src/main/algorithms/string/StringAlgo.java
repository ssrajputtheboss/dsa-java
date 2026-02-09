package main.algorithms.string;
import static java.lang.Math.*;

public class StringAlgo {
    public static int[] lps(char[] s){
        int n  = s.length;
        if(n == 0)return new int[]{};
        int[] lps = new int[n];
        int i = 1,l=0;
        lps[0] = 0;
        while (i < n){
            if(s[i] == s[l]){
                lps[i++] = ++l;
            }else if (l == 0){
                lps[i++] = 0;
            }else {
                l = lps[l-1];
            }
        }
        return lps;
    }

    // returns first index of text where pattern starts
    public static int kmp(String text, String pat){
        char[]  txt = text.toCharArray(),
                p = pat.toCharArray();
        int n = text.length(), m = pat.length();
        int i =0, j =0;
        int[] lps = lps(p);
        while(i<n){
            if(txt[i] == p[j]){
                i++;
                j++;
                if(j == m){
                    return i-j;
                    // In case wants to continue
                    // j = lps[j-1];
                }
            }else{
                i++;
                if(j!=0)
                    j=lps[j-1];
            }
        }
        return -1;
    }

    public static int lcsSubstring(String s1,String s2){
        int n = s1.length(), m = s2.length();
        int[] dp = new int[m+1], pre = new int[m+1];
        int ans = 0;
        for(int i = 1;i <= n; ++i){
            System.arraycopy(dp, 0 , pre, 0, m);
            for(int j = 1;j <= m; ++j){
                if(s1.charAt(i-1) == s2.charAt(j-1)){
                    dp[j] = pre[j-1] + 1;
                }else{
                    dp[j] = 0;
                }
                ans = max(ans, dp[j]);
            }
        }
        return ans;
    }

    public static int lcsSequence(String s1,String s2){
        int n = s1.length(), m = s2.length();
        int[][] dp = new int[n+1][m+1];
        for(int i = 1;i <= n; ++i){
            for(int j = 1;j <= m; ++j){
                if(s1.charAt(i-1) == s2.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1] + 1;
                }else{
                    dp[i][j] = max(dp[i-1][j] , dp[i][j-1]);
                }
            }
        }
        return dp[n][m];
    }
}
