class Solution {
    static int reqHrs(int[] piles, int mid){
        int hrs = 0;
        for(int i = 0; i < piles.length; i++){
            hrs += Math.ceil(piles[i] * 1.0 / mid);
        }
        return hrs;
    }
    public int minEatingSpeed(int[] piles, int h) {
        int maxi = Integer.MIN_VALUE;
        for(int i = 0; i < piles.length; i++){
            maxi = Math.max(maxi, piles[i]);
        }
        int l = 1, r = maxi;
        while(l <= r){
            int mid = (l + r) / 2;
            int hrs = reqHrs(piles, mid);
            if(hrs > h)     l = mid + 1;
            else    r = mid - 1;
        }
        return l;
    }
}