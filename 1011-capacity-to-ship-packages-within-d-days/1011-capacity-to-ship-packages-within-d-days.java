class Solution {
    static int reqDays(int[] weights, int c){
        int l = 0;  //load
        int d = 1;
        for(int i = 0; i < weights.length; i++){
            if(l + weights[i] <= c){
                l += weights[i];
            }
            else{
                d += 1;
                l = weights[i];
            }
        }
        return d;
    }
    public int shipWithinDays(int[] weights, int days) {
        int maxi = Integer.MIN_VALUE;
        int sum = 0;
        for (int i = 0; i < weights.length; i++) {
            maxi = Math.max(maxi, weights[i]);
            sum += weights[i];
        }
        int l = maxi, h = sum;
        while(l <= h){
            int mid = (l + h) / 2;
            int rd = reqDays(weights, mid);
            if(rd <= days)  h = mid - 1;
            else    l = mid + 1;
        }
        return l;
    }
}