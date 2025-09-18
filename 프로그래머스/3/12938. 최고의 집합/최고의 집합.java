import java.util.*;

class Solution {
    public int[] solution(int n, int s) {
        int[] answer;
        int addNum = 0;
        
        if(n > s) {
            answer = new int [1];
            answer[0] = -1;
        } else if(n == s) {
            answer = new int[n];
            for(int i = 0; i< n; i++) {
                answer[i] = 1;
            }
        } else {
            answer = new int[n];
            
            int num = s/n;
            
            addNum = s % n;
            
            for(int i = 0; i<n; i++) {
                if(i < n - addNum) {
                    answer[i] = num;
                } else {
                    answer[i] = num+1;
                }
            }
        }
        
        System.out.println(Arrays.toString(answer));
    
        return answer;
    }
}