package com.example.Backtracking;

/**
 * Created by shwetatrivedi1 on 2/9/17.
 */
/*
The set [1,2,3,…,n] contains a total of n! unique permutations.

By listing and labeling all of the permutations in order,
We get the following sequence (ie, for n = 3 ) :

1. "123"
2. "132"
3. "213"
4. "231"
5. "312"
6. "321"
Given n and k, return the kth permutation sequence.

For example, given n = 3, k = 4, ans = "231"

 Good questions to ask the interviewer :
What if n is greater than 10. How should multiple digit numbers be represented in string?
> In this case, just concatenate the number to the answer.
> so if n = 11, k = 1, ans = "1234567891011"
Whats the maximum value of n and k?
> In this case, k will be a positive integer thats less than INT_MAX.
> n is reasonable enough to make sure the answer does not bloat up a lot.
 */
public class KthPermutation {
    public String getPermutation(int n, int k) {
        int p = k-1;
        int[] numbers = new int[n];
        int[] indices = new int[n];
        for (int i = 0; i < n; i++)
            numbers[i] = i + 1;

        int divisor = 1;
        for (int place = 1; place <= n; place++)
        {
            if((p / divisor) == 0)
                break;  // all the remaining indices will be zero

            // compute the index at that place:
            indices[n-place] = (p / divisor) % place;
            divisor *= place;
        }

        for (int i = 0; i < n; i++)
        {
            int index = indices[i] + i;

            if(index != i)
            {
                int temp = numbers[index];
                for(int j = index; j > i; j--)
                    numbers[j] = numbers[j-1];
                numbers[i] = temp;
            }
        }

        StringBuilder builder = new StringBuilder();
        for(int i=0; i<numbers.length; i++)
            builder.append(numbers[i]);
        return builder.toString();
    }
}
