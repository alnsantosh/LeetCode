/*
Below content copied from the following link: 
https://stackoverflow.com/questions/12757841/are-arrays-passed-by-value-or-passed-by-reference-in-java

Everything in Java are passed-by value.. In case of Array(Which is nothing but an Object), array reference is passed by value.. (Just like an object reference is passed by value)..

When you pass an array to other method, actually the reference to that array is copied..

Any changes in the content of array through that reference will affect the original array..
But changing the reference to point to a new array will not change the existing reference in original method..
See this post..

Is Java "pass-by-reference" or "pass-by-value"?

See this working example:

*/

public static void changeContent(int[] arr) {

   // If we change the content of arr.
   arr[0] = 10;  // Will change the content of array in main()
}

public static void changeRef(int[] arr) {
   // If we change the reference
   arr = new int[2];  // Will not change the array in main()
   arr[0] = 15;
}

public static void main(String[] args) {
    int [] arr = new int[2];
    arr[0] = 4;
    arr[1] = 5;

    changeContent(arr);

    System.out.println(arr[0]);  // Will print 10.. 

    changeRef(arr);

    System.out.println(arr[0]);  // Will still print 10.. 
                                 // Change the reference doesn't reflect change here..
}
