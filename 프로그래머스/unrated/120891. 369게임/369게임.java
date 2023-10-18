class Solution {
    public int solution(int order) {
        int answer = 0;
        String str = String.valueOf(order);
        
        for(int i = 0; i< str.length(); i++){
            if(str.charAt(i) != 48){
                if(str.charAt(i) % 3 == 0) {
                    answer++;
                }
            }
            
        }
        return answer;
    }
}