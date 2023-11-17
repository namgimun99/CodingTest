class Solution {
    public int solution(int a, int b) {
        int answer = 0;
        String num = String.valueOf(a).concat(String.valueOf(b));
        int num2 = 2*a*b;
        
        answer = Integer.parseInt(num) > num2 ? Integer.parseInt(num) : num2;
        
        return answer;
    }
}