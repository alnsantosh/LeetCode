/*
1093. Statistics from a Large Sample

Logic :Calculating min,max,mean,mode is straight forward.
For median calculation, algorithm is as follows
Let c be the sample count i.e., the total number of samples
if (c%2==0), then median is average of middle two elements. else median is the middle element
*/
class Solution {
    public double[] sampleStats(int[] count) {
        double[] res=new double[5];
        double min=-1,max=-1,mean=0,sum=0,mode=-1,modeCount=0,median=-1;
        int c=0;        
        for(int i=0;i<count.length;i++){
            if(count[i]>0){
                if(min==-1){
                    min=i;
                }
                max=i;
                sum+=i*count[i];
                c+=count[i];
                if(count[i]>modeCount){
                    modeCount=count[i];
                    mode=i;
                }
            }
            
        }
        
        int temp=0;
        for(int i=0;i<count.length;i++){
            if(count[i]>0){
                temp+=count[i];
            if(c%2==0){
                if(temp==c/2){//this is the first element of the two elements that needs to be averaged
                    median=i;
                }
                else
                {
                    if(temp>c/2){
                        if(median==-1){//It means that both the elements are i. Hence, the median will be (i+i)/2 which is equal to i
                            median=i;
                        }
                        else{//This is the second element of the median
                            median=(median+i)/2;
                        }
                        break;
                    }
                }
            }
            else{//In this case, median is the middle element in the sorted sample
                if(temp>c/2){
                    median=i;
                    break;
                }
            }
                
            }
        }
        mean=sum/c;
        res[0]=min;
        res[1]=max;
        res[2]=mean;
        res[3]=median;
        res[4]=mode;
        return res;
    }
}

/*
Time Complexity: O(2n)=O(n)
Space Complexity: O(1)
*/
