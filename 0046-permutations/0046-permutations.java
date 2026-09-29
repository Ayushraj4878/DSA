class Solution {

    public static void fun(int arr[] , int n , ArrayList<Integer>temp , ArrayList<List<Integer>> result){

        if(temp.size() == n){
            result.add(new ArrayList<>(temp));
            return;
        }

       for(int i = 0; i < n; i++){
        if(temp.contains(arr[i])){             // check arr[i] is exist then move forward
            continue;
        }
        temp.add(arr[i]);                        // add arr[i]
        fun(arr , n ,temp , result);             // reverse and delete arr[i].
        temp.remove(temp.size() - 1);
       }
       
    }
    public List<List<Integer>> permute(int[] nums) {
        int n = nums.length;
        ArrayList<Integer> temp = new ArrayList<>();
        ArrayList<List<Integer>> result = new ArrayList<>();

        fun(nums , n , temp , result);

        return result;
    }
}