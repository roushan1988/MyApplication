package com.example.DP;

/**
 * Created by shwetatrivedi1 on 2/5/17.
 */
/*
Given a string s, partition s such that every substring of the partition is a palindrome.

Return the minimum cuts needed for a palindrome partitioning of s.

Example :
Given
s = "aab",
Return 1 since the palindrome partitioning ["aa","b"] could be produced using 1 cut.
 */
public class PalindromePartitions {
    public int minCut(String a) {
        if(a.length() == 1)
            return 0;
        int n = a.length();
        int[] cuts = new int[n];
        boolean[][] pallindrome = new boolean[n][n];
        for(int i=0;i<n;i++)
            pallindrome[i][i] = true;

        for(int l=2; l<=n; l++){
            for(int i=0; i<n-l+1; i++){
                int j = i + l-1;
                if(l ==2){
                    pallindrome[i][j] = a.charAt(i) == a.charAt(j);
                }else{
                    pallindrome[i][j] = a.charAt(i) == a.charAt(j) && pallindrome[i+1][j-1];
                }
            }
        }

        for(int i=0; i<n; i++){
            if(pallindrome[0][i])
                cuts[i] = 0;
            else{
                cuts[i] = Integer.MAX_VALUE;
                for(int j=0; j<i; j++){
                    if(pallindrome[j+1][i] && cuts[j] + 1 < cuts[i])
                        cuts[i] = cuts[j] + 1;
                }
            }
        }
        return cuts[n-1];
    }
}
