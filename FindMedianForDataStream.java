/*
295. Find Median from Data Stream

Median is the middle value in an ordered integer list. If the size of the list is even, there is no middle value. So the median is the mean of the two middle value.
For example,

[2,3,4], the median is 3

[2,3], the median is (2 + 3) / 2 = 2.5

Design a data structure that supports the following two operations:

    void addNum(int num) - Add a integer number from the data stream to the data structure.
    double findMedian() - Return the median of all elements so far.

Example:

addNum(1)
addNum(2)
findMedian() -> 1.5
addNum(3) 
findMedian() -> 2


*/

class MedianFinder {
    List<Integer> data;
    /** initialize your data structure here. */
    public MedianFinder() {
        data=new ArrayList<>();//Using ArrayList as the amortised insertion time is O(1)
    }
    
    public void addNum(int num) {
        if(data.size()==0)
            data.add(num);
        else if(num<data.get(0))//if num<1st element in list.. add at beginning
        {
            data.add(0,num);
        }
        else if(num>data.get(data.size()-1))// if num>last element i list, then add at end
        {
            data.add(data.size(),num);
        }
        else //find the index at which the new element can be inserted. Using binary search approach here.
        {
            int low=0,high=data.size()-1;
            int mid=low+(high-low)/2;
            while(low<=high)
            {
                mid=low+(high-low)/2;
                if(num<=data.get(mid))
                {
                    high=mid-1;
                }
                else
                {
                    low=mid+1;
                }
            }
            data.add(low,num);
        }
        // for(int i=0;i<data.size();i++)//Displating elements in the array
        // {
        //     System.out.print(data.get(i)+" ");
        // }
        // System.out.println();
    }
    
    public double findMedian() {
        //Collections.sort(data);
        if(data.size()%2==0)
        {
            return (double)(data.get(data.size()/2)+data.get((data.size()/2)-1))/2;
        }
        else
        {
            return (double)data.get((data.size()-1)/2);
        }
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */


/*
Time Complexity - O(log(n)*1)= (log(n)) - log(n) for finding the index for insertion, 1 is amortized insertion time for ArrayList
Space Complexity - O(n) - All the elements will be stored in the array

*/
