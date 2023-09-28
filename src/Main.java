import java.util.ArrayList;

public class Main {
    //What is complexity ==> All machines(fast and slow) have the same time
    // complexity.
    //Time complexity != time taken
    //Time complexity is therefore a function that details how the time will
    //grow as the input grows
    //For linear search T = O(N), and for binary search T = O(log(N))
    //Importance ==> time taken
    //What to consider ==> Always consider worst case complexity
    //                 ==> O(10) < O(Log N) < O(N)
    //                 ==> Always look for complexity for largest values
    //                 ==> Ignore less dominating terms

    //Big O notation ==> O(N) it details the upper bound, in the sense that
    //the algorithm will never exceed the said Big O
    //ArrayList<Integer> myArr = new ArrayList<>();
    public static void main(String[] args) {

        int[] arr = {45, 89, 96, 102, 256, 896, 7700, 9365};
        System.out.println(findTarget(arr, 26));
    }

    static int findTarget(int[] arr, int target) {
    int start = 0;
    int end = arr.length - 1;

    while(start <= end){
        int mid = start + (end - start) / 2;
        if(target == arr[mid]){
            return mid;
        }else if(target < arr[mid]){
            end = mid - 1;
        }else{
            start = mid + 1;
        }
    }
    return  -1;
    }
}