class Solution {
    public String solution(int[] numLog) {
        String answer = "";
        
        for(int i = 0; i<numLog.length-1; i++){
            if(numLog[i+1] - numLog[i] == 1) {
                answer = answer.concat("w");
            } else if(numLog[i+1] - numLog[i] == -1) {
                answer = answer.concat("s");
            } else if(numLog[i+1] - numLog[i] == 10) {
                answer = answer.concat("d");
            } else {
                answer = answer.concat("a");
            }
        }
        return answer;
    }
}