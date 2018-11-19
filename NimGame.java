/*
292. Nim Game

https://leetcode.com/problems/nim-game/description/

You are playing the following Nim Game with your friend: There is a heap of stones on the table, each time one of you take turns to remove 1 to 3 stones. The one who removes the last stone will be the winner. You will take the first turn to remove the stones.

Both of you are very clever and have optimal strategies for the game. Write a function to determine whether you can win the game given the number of stones in the heap.

Example:

Input: 4
Output: false 
Explanation: If there are 4 stones in the heap, then you will never win the game;
             No matter 1, 2, or 3 stones you remove, the last stone will always be 
             removed by your friend.
*/
/*
Idea - Consider the following cases
n=1,n=2,n=3 -> Person who starts the game always win
n=4 -> Person who starts the game will loose as (1,3),(2,2),(3,1) will be course of action taken by both the players respectively and the second player is bound to win
Similarly, for n=5,n=6,n=7 first player will win but will loose for n=8
This pattrn continues indefinitely.
So the result totally depends on n. If n%4!=0, then the first player will win, else the first player will loose.
*/
class Solution {
    public boolean canWinNim(int n) {
        return n%4!=0;
    }
}
/*
Time Complexity - O(1)
Space Complexity - O(1)
*/
