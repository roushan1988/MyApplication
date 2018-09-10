package com.example.DP;

/*
 row of houses, each house can be painted with three colors red, blue and green.
 The cost of painting each house with a certain color is different.
 You have to paint all the houses such that no two adjacent houses have the same color.
 You have to paint the houses with minimum cost. How would you do it?

Note: Painting house-1 with red costs different from painting house-2 with red.
The costs are different for each house and each color.


The solution is as folows (calc(int, int) function):
1. If a best solution was found, use it.
2. Select one color not forbiden;
3. Solve the problem for n-1 houses.
4. get the best result adding best result for n-1 to current cost.
5. see if it is the current minimum when you add current color cost
6. update minimum if needed.
7. save best result.

Time complexity: Colors*Houses.
Space complexity: Colors*Houses.
https://www.careercup.com/question?id=9941005
 */
public class PaintHousesWithMinCost {
    public class BestResult {
        public int[] colors;
        public int cost;
        public BestResult(int[] colors, int cost) {
            this.colors = colors;
            this.cost = cost;
        }

    }
    //  Input cost matrix
    private int[][] cost;
    //  best[i][j] is the bestResult given house j is colored with color i, in the process of filling this matrix
    //just keep the track of the min cost and the best result pointing to it
    private BestResult[][] best;
    public PaintHousesWithMinCost(int[][] cost) {
        this.cost = cost;
        this.best = new BestResult[cost.length][cost[0].length];
    }
    public BestResult calc() {
        return calc(cost[0].length, -1);
    }
    private BestResult calc(int housesRemaining, int forbidden) {
        //Step 1
        if (forbidden >= 0 && best[forbidden][housesRemaining-1] != null)
            return best[forbidden][housesRemaining-1]; //Result with this forbiddenColor
        //Else Calculate
        BestResult min = null;
        for (int c = 0, h = cost[0].length - housesRemaining; c< cost.length; ++c) {
            if (c != forbidden) {
                if (housesRemaining == 1) {
                    if (min == null || min.cost > cost[c][h]) {
                        min = new BestResult(new int[] {c}, cost[c][h]);
                    }
                } else {
                    //Step 3 : Recurse to find min cost for 1 less houses
                    BestResult next = calc(housesRemaining-1, c);
                    if (min == null || min.cost > (next.cost + cost[c][h])) {
                        //If a new minimum is available, update it
                        min = new BestResult(new int[next.colors.length+1], next.cost + cost[c][h]);
                        min.colors[0] = c;
                        System.arraycopy(next.colors, 0, min.colors, 1, next.colors.length);
                    }
                }
            }
        }
        if (forbidden >= 0)
            best[forbidden][housesRemaining-1] = min;
        return min;
    }


/*public class PaintHouseTest {
    @Test
    public void testCalc() {
        int[][] cost = new int[][] {
                new int[] { 7, 3, 8, 6, 1, 2},
                new int[] { 5, 6, 7, 2, 4, 3},
                new int[] {10, 1, 4, 9, 7, 6}
        };
        PaintHouse calc = new PaintHouse(cost);
        PaintHousesWithMinCost.BestResult bestResult = calc.calc();
        System.out.println("Colors: " + Arrays.toString(bestResult.colors));
        System.out.println("Cost: " + bestResult.cost);
        assertEquals(bestResult.cost, 18);
    }*/

}
