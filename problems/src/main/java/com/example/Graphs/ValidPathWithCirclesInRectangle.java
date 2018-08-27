package com.example.Graphs;
/*
There is a rectangle with left bottom as  (0, 0) and right up as (x, y). There are N circles such that their centers are inside the rectangle.
Radius of each circle is R. Now we need to find out if it is possible that we can move from (0, 0) to (x, y) without touching any circle.

Note : We can move from any cell to any of its 8 adjecent neighbours and we cannot move outside the boundary of the rectangle at any point of time.


https://www.geeksforgeeks.org/path-rectangle-containing-circles/

Algorithm :

1. Take an array of size m*n. Initialize all the cells to 0.
2. For each cell of the rectangle check whether it comes within any circle or not (by calculating the distance of that cell from each circle). If it comes within any circle then change the value of that cell to -1(‘blocked’).
3. Now, apply BFS from the starting cell and if a cell can be reached then change the value of that cell to 1.
4. If the value of the ending cell is 1, then return ‘Possible’, otherwise return ‘Not Possible’.

 */
public class ValidPathWithCirclesInRectangle {
}
