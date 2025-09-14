import java.util.*;

class Solution {
    public int solution(int[][] routes) {
        int answer = 0;
        int nearCamera = Integer.MIN_VALUE;
        
        Arrays.sort(routes, (a, b) -> {
            if(a[1] != b[1]) return Integer.compare(a[1], b[1]);
            else return Integer.compare(a[0], b[0]);
        });
        
        
        for(int i = 0; i<routes.length; i++) {
            if(nearCamera < routes[i][0]) {
                answer++;
                nearCamera = routes[i][1];
            }
        }
        
        return answer;
    }
}