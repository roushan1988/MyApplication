package com.example.Hashing;

/**
 * Created by shwetatrivedi1 on 2/9/17.
 */
/*
Given a string,
find the length of the longest substring without repeating characters.

Example:

The longest substring without repeating letters for "abcabcbb" is "abc", which the length is 3.

For "bbbbb" the longest substring is "b", with the length of 1.
 */
public class LongestSubstringWithoutRepeats {
    public int lengthOfLongestSubstring(String a) {
        if(a == null || a.length() == 0)
            return 0;
        int[] visited = new int[256];
        int n = a.length(), cur_len = 1, max_len = 1, prev_index;

        for(int i=0; i<visited.length; i++)
            visited[i] = -1;
        visited[a.charAt(0)] = 0;
        for (int i = 1; i < n; i++){
            prev_index = visited[a.charAt(i)];
            if (prev_index == -1 || i - cur_len > prev_index)
                cur_len++;
            else{
                if (cur_len > max_len)
                    max_len = cur_len;
                cur_len = i - prev_index;
            }
            visited[a.charAt(i)] = i;
        }
        if (cur_len > max_len)
            max_len = cur_len;
        return max_len;
    }
}
