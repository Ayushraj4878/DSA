class Solution {
    public int maximumSum(int[] arr) {

        int result = arr[0];
        int nodelete = arr[0];
        int onedelete = Integer.MIN_VALUE / 2;    // let minimum
        for(int i = 1; i < arr.length; i++){
            
            int prevnodelete = nodelete;      // store the value
            int prevonedelete = onedelete;
                                            
                                            // compare in no deletion
            nodelete = Math.max(prevnodelete + arr[i] , arr[i]);

                                        // compare in one deletion
            onedelete = Math.max(prevonedelete + arr[i] , prevnodelete);
                                        // campare in both nodelete and onedelete
            result = Math.max(result ,Math.max(nodelete , onedelete));
        }
        return result;
    }
}