class Solution {
    public int[] solution(String myString) {
        int cnt = 0;

        for(int i = 0; i<myString.length();i++){
            if(myString.charAt(i) == 'x') {
                cnt++;
                
            }
        }
        int[] answer = new int[cnt+1];
        
        cnt = 0;
        int x = 0;
        
        for(int i = 0; i<myString.length();i++){
            if(myString.charAt(i) == 'x') {
                answer[x] = cnt;
                cnt = 0;
                x++;
            } else {
                cnt++;
            }
        }
        answer[x] = cnt;
        return answer;
    }
}