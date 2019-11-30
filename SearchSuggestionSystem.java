/*
1268. Search Suggestions System
Idea: The approach is to sort the products array to get lexographical order. Iterate over the substrings of searchword(start with first character, then first two characters, and so on).During each iteration,create a List<String> and check if the product[i] substring matches the substring of the searchword.If yes, add it to the list.At the end of iteration,add the list to the res list. Also note that during each iteration we can have atmost three results, Hence using count variable to make that sure.
*/
class Solution {
    public List<List<String>> suggestedProducts(String[] products, String searchWord) { 
        List<List<String>> res=new ArrayList<>();
        Arrays.sort(products);
        for(int i=1;i<=searchWord.length();i++){
            List<String> s=new ArrayList<>();
            int count=0;
            String str=searchWord.substring(0,i);
            for(int j=0;j<products.length;j++){
                if(products[j].length()>=str.length() && products[j].substring(0,i).equals(str)){
                    s.add(products[j]);
                    count++;
                }
                if(count>=3){
                    break;
                }
            }
            res.add(s);
        }
        return res;
        
    }
}
/*
Time Complexity: O(nlogn+nm) where n=length of products array,m=length of the string searchWord, nlogn because products array is sorted and nm since we have two for loops
Space Complexity: O(m) if including the res list into the space complexity, else O(1)
*/
