class Solution {
    public int timeRequiredToBuy(int[] tickets, int k) {
        ArrayDeque<Integer> q = new ArrayDeque<>();
        for(int i = 0; i < tickets.length; i++){
            q.offer(i);
        }
        int c = 0;
        while(tickets[k] > 0){
            int i = q.peek();
            tickets[i]--;
            q.poll();
            if(tickets[i] != 0){
                q.offer(i);
            }
            c++;
        }
        return c;

    }
}