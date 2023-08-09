import java.util.*;
class Solution {
    public String solution(String s) {
        String answer = "";
        
        String[] parts = s.split(" ");
        int[] num = new int[parts.length];
        
        for(int i = 0; i< num.length; i++){
            num[i] = Integer.parseInt(parts[i]);
        }
        
        Arrays.sort(num);
        
        answer = num[0] + " " + num[num.length-1];
        return answer;
    }
}