/*
89. Gray Code

https://leetcode.com/problems/gray-code/description/

The gray code is a binary numeral system where two successive values differ in only one bit.

Given a non-negative integer n representing the total number of bits in the code, print the sequence of gray code. A gray code sequence must begin with 0.

Example 1:

Input: 2
Output: [0,1,3,2]
Explanation:
00 - 0
01 - 1
11 - 3
10 - 2

For a given n, a gray code sequence may not be uniquely defined.
For example, [0,2,3,1] is also a valid gray code sequence.

00 - 0
10 - 2
11 - 3
01 - 1
Example 2:

Input: 0
Output: [0]
Explanation: We define the gray code sequence to begin with 0.
             A gray code sequence of n has size = 2n, which for n = 0 the size is 20 = 1.
             Therefore, for n = 0 the gray code sequence is [0].
*/
/*
Idea - For every bit, we either reverse the bit or not. Based on this idea, we can develop arecursive approach
*/
class Solution {
    List<Integer> res=new ArrayList<>();
    public List<Integer> grayCode(int n) {
        List<Integer> l=new ArrayList<>();//Using arraylist instead of a number as I need to know the current value at every moment for which I need a mutable storage. List is mutable.
        l.add(0);
        logic(n,l);
        return res;
        }
    public void logic(int n,List<Integer> num)
    {
        if(n==0)//base case
        {
            res.add(num.get(0));
            return;   
        }
        logic(n-1,num);//recursively call n-1
        int num2=num.get(0);
        num.remove(0);
        num2=num2^(1<<(n-1));//Invert the bits in num2.. Need to look into this in detail
        num.add(num2);
        logic(n-1,num);//Calling after reversing the bit
    }
}
/*
Time Complexity - O(2^n) - Consider generating a binary tree of height n
Space Complexity - O(n) - Considering length res as space. List l can be considered as O(1) space as it stores only 1 element no matter the value of n.
*/
