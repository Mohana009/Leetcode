class Solution {
    public String removeDuplicates(String s) {
        Stack<Character> stack = new Stack<>();
        for(int i = 0; i < s.length(); i++){
            if(!stack.isEmpty() && stack.peek() == s.charAt(i)){
                stack.pop();
            }
            else{
                stack.push(s.charAt(i));
            }
        }
        String res = "";
        while(!stack.isEmpty()){
            res += stack.peek();
            stack.pop();
        }
        int i = 0;
        int j = res.length() - 1;
        char[] arr = res.toCharArray();
        while(i < res.length() / 2){
            char temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            i++;
            j--;
        }
        res = new String(arr);
        return res;
    }
}