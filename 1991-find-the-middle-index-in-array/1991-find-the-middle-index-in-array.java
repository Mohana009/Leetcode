class Solution {
    public int findMiddleIndex(int[] nums) {
        int n = nums.length;
        if(n == 1)  return 0;
        int[] PS = new int[n];
        PS[0] = nums[0];
        for(int i = 1; i < n; i++){
            PS[i] = PS[i - 1] + nums[i];
        }
        int l, r;
        for(int i = 0; i < n; i++){
            if(i == 0){
                l = 0;
                r = PS[n - 1] - PS[i];
            }
            else if(i == n - 1){
                l = PS[i - 1];
                r = 0;
            }
            else{
                l = PS[i - 1];
                r = PS[n - 1] - PS[i];
            }
            if(l == r){
                return i;
            }
        }
        return -1;
    }
}