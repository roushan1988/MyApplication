package com.example.Greedy;

/**
 * Created by shwetatrivedi1 on 2/5/17.
 */
/*
There is a row of seats. Assume that it contains N seats adjacent to each other. There is a group of people who are already seated in that row randomly. i.e. some are sitting together & some are scattered.

An occupied seat is marked with a character 'x' and an unoccupied seat is marked with a dot ('.')

Now your target is to make the whole group sit together i.e. next to each other, without having any vacant seat between them in such a way that the total number of hops or jumps to move them should be minimum.

Return minimum value % MOD where MOD = 10000003

Example
Here is the row having 15 seats represented by the String (0, 1, 2, 3, ......... , 14) -

              . . . . x . . x x . . . x . .

Now to make them sit together one of approaches is -
                  . . . . . . x x x x . . . . .

Following are the steps to achieve this -
1 - Move the person sitting at 4th index to 6th index -
    Number of jumps by him =   (6 - 4) = 2

2 - Bring the person sitting at 12th index to 9th index -
    Number of jumps by him = (12 - 9) = 3

So now the total number of jumps made =
    ( 2 + 3 ) % MOD =
    5 which is the minimum possible jumps to make them seat together.

There are also other ways to make them sit together but the number of jumps will exceed 5 and that will not be minimum.

For example bring them all towards the starting of the row i.e. start placing them from index 0.
In that case the total number of jumps will be
    ( 4 + 6 + 6 + 9 )%MOD
    = 25 which is very costly and not an optimized way to do this movement

 */
public class ClubSeatsWithMinHops {
    public int seats(String a) {
        int i = findMedian(a.toCharArray());
        if(i == -1)
            return 0;
        return shift(a.toCharArray(), i);
    }

    public static int findMedian(char[] s){
        long count1 = 0;
        for(int i = 0; i <s.length; i++){
            if(s[i] == 'x')
                count1 = Math.floorMod(count1 + 1, 10000003);
        }
        if(count1 == 0)
            return -1;

        count1 = Math.floorMod((count1 + 1)/2, 10000003);
        long count2 = 0;
        for(int i = 0; i <s.length; i++){
            if(s[i] == 'x'){
                count2 = Math.floorMod(count2 + 1, 10000003);
                if(count2 == count1)
                    return i;
            }
        }
        return -1;

    }

    public static int shift(char[] s, int median){
        long count = 0;
        int j = 0;
        int k = median;
        while(j < k){
            if(s[j] == '.'){
                j++;
            }
            else if(s[k] == 'x'){
                k--;
            }
            else{
                s[k] = s[j];
                s[j] = '.';
                count = Math.floorMod(count + k-j, 10000003);
                j++;
                k--;
            }
        }
        j = s.length - 1;
        k = median;
        while (j > k) {
            if (s[j] == '.') {
                j--;
            }
            else if (s[k] == 'x') {
                k++;
            }
            else {
                s[k] = s[j];
                s[j] = '.';
                count = Math.floorMod(count + j-k, 10000003);
                j--;
                k++;
            }
        }

        return (int)count;
    }
}
