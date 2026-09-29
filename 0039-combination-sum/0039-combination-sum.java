class Solution {

    public static void fun(int arr[] , int n , int idx , ArrayList<Integer>temp , ArrayList<List<Integer>> result ,int sum , int target){

        if(idx == n){
            if(sum == target){                  // store only if sum == target
                result.add(new ArrayList<>(temp));
            }
            return;
        }                                   // without take number
            fun(arr , n , idx + 1, temp , result , sum , target);
            if(sum < target){              // take number
                temp.add(arr[idx]);        // store in temp
                sum += arr[idx];           // add the sum
                fun(arr , n , idx , temp ,result , sum , target);// take same number again
                temp.remove(temp.size() - 1);           // remove the number
                sum -= arr[idx];                        // sub the number
            }
        return;                             // reutrn to check other choice(backtracking)
    }
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        
        int sum = 0;
        int n = candidates.length;
        ArrayList<Integer> temp = new ArrayList<>();
        ArrayList<List<Integer>> result = new ArrayList<>();  // list of array
        int idx = 0;

        fun(candidates , n , idx , temp , result ,sum , target);
        return result;
    }
}