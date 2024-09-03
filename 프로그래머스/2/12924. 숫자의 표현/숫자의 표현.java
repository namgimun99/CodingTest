class Solution {
    public int solution(int n) {
        int start = 0;
        int end = 1;
        int answer = 0;

        while(true){
            int sum = 0;
            for(int j = start; j<= end; j++) {
                sum += j;
            }
            
            if(sum < n) {
                end++;
            } else if(sum > n){
                start++;
            } else {
                answer++;
                end++;
                start++;
            }

            if(start > n) {
                break;
            }
        }
        return answer;
    }
}