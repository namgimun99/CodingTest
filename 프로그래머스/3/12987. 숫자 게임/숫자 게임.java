import java.util.*;

class Solution {
    public int solution(int[] A, int[] B) {
        int answer = 0;
        int j = 0;
        
        Arrays.sort(A);
        Arrays.sort(B);
        
        for(int i = 0 ; i< B.length; i++) {
            
            if (j == A.length) break;
            
            if(B[i] <= A[j]) {
                continue;
            } else {
                answer++;
                j++;
            }
        }
        
       
        
        
        
        return answer;
    }
}