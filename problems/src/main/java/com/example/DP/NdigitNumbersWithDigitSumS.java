package com.example.DP;

public class NdigitNumbersWithDigitSumS {

    // A lookup table used for memoization
    static int lookup[][] ;

    // This is mainly a wrapper over countRec. It
    // explicitly handles leading digit and calls
    // countRec() for remaining n.
    public int solve(int A, int B) {
        lookup = new int[A+1][B+1];

        // Initialize all entries of lookup table
        for(int i = 0;i<=A;++i){
            for(int j=0;j<=B;++j){
                lookup[i][j] = -1;
            }
        }

        // Initialize final answer
        int ans = 0;

        // Traverse through every digit from 1 to
        // 9 and count numbers beginning with it
        for (int i = 1; i <= 9; i++)
            if (B-i >= 0)
                ans = Math.floorMod(ans + Math.floorMod(countRec(A-1, B-i), 1000000007),1000000007);
        return ans;
    }

    // Memoizatiob based implementation of recursive
    // function
    static int countRec(int n, int sum)
    {
        // Base case
        if (n == 0)
            return sum == 0 ? 1 : 0;

        // If this subproblem is already evaluated,
        // return the evaluated value
        if (lookup[n][sum] != -1)
            return lookup[n][sum];

        // Initialize answer
        int ans = 0;

        // Traverse through every digit and
        // recursively count numbers beginning
        // with it
        for (int i=0; i<10; i++)
            if (sum-i >= 0)
                ans = Math.floorMod(ans + Math.floorMod(countRec(n-1, sum-i), 1000000007), 1000000007);

        return lookup[n][sum] = ans;
    }
}

