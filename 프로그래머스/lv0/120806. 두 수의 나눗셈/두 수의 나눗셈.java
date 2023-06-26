
class Solution {
    public int solution(int num1, int num2) {
        int answer = 0;
        double a1 = (num1/(double)num2)*1000;
        answer = (int)Math.floor(a1);
        return answer;
    }
}