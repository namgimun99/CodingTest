class Solution {
    public String solution(String[] arr) {
        String answer = "";
        
        for(int i = 0; i< arr.length; i++){
            answer = answer.concat(arr[i]);
        }
        return answer;
    }
}