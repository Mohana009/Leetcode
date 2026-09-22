class Solution {
    public String predictPartyVictory(String senate) {
        ArrayDeque<Integer> Rq = new ArrayDeque<>();
        ArrayDeque<Integer> Dq = new ArrayDeque<>();
        int n = senate.length();
        for(int i = 0; i < n; i++){
            if(senate.charAt(i) == 'R') Rq.offer(i);
            else Dq.offer(i);
        }
        while(!Rq.isEmpty() && !Dq.isEmpty()){
            int r = Rq.peek();
            Rq.pop();
            int d = Dq.peek();
            Dq.pop();
            if(r < d){
                Rq.offer(r + n);
            }
            else{
                Dq.offer(d + n);
            }
        }
        if(Rq.isEmpty()) return "Dire";
        return "Radiant";
    }
}