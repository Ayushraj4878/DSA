class Solution {

    public static void fun(int n , int k , int idx , ArrayList<Integer>temp , ArrayList<List<Integer>>result){

        if(temp.size() == k){
            result.add(new ArrayList<>(temp));
            return;
        }

        for(int i = idx; i <= n; i++){
          
            temp.add(i);
            fun(n , k , i + 1, temp , result);
            temp.remove(temp.size() - 1);
        }
        return;
    }
    public List<List<Integer>> combine(int n, int k) {
        ArrayList<Integer> temp = new ArrayList<>();
        ArrayList<List<Integer>> result = new ArrayList<>();
        int idx = 1;
        fun(n , k , idx , temp , result);
        return result;
    }
}