class Solution {
    static int divisionSum(int[] nums, int n){
        int s = 0;
        for(int i = 0; i < nums.length; i++){
            double div = nums[i] * 1.0 / n;
            s += Math.ceil(div);
        }
        return s;
    }
    public int smallestDivisor(int[] nums, int threshold) {
        int maxi = Integer.MIN_VALUE;
        for(int i = 0; i < nums.length; i++){
            maxi = Math.max(maxi, nums[i]);
        }
        int l = 1, h = maxi;
        while(l <= h){
            int mid = (l + h) / 2;
            int ds = divisionSum(nums, mid);
            if(ds <= threshold) h = mid - 1;
            else l = mid + 1;
        }
        return l;
    }
}