import java.io.*;
import java.util.*;

class Solution {
    static int map[][], n;
    
    public int solution(int n, int[][] wires) {
        int answer = Integer.MAX_VALUE;
        this.n = n;
        map = new int[n][n];
        
        for(int i = 0; i < wires.length; i++) {
            int fr = wires[i][0]-1;
            int to = wires[i][1]-1;
            map[fr][to] = 1;
            map[to][fr] = 1;
        }
        
        for(int i = 0; i < wires.length; i++) {
            boolean[] visited = new boolean[n];
            int fr = wires[i][0]-1;
            int to = wires[i][1]-1;
            
            // 간선 끊기
            map[fr][to] = 0;
            map[to][fr] = 0;
            
            int cnt = dfs(0, visited);
            int diff = Math.abs(cnt - (n - cnt));
            answer = Math.min(diff, answer);
            
            // 원복
            map[fr][to] = 1;
            map[to][fr] = 1;
        }
        return answer;
    }
    
   public static int dfs(int start, boolean[] visited) {
        visited[start] = true;
        int cnt = 1;
       
        for(int i = 0; i < n; i++) {
            if(map[start][i] == 1 && !visited[i]) {
                cnt += dfs(i, visited);
            }
        }
       return cnt;
   }
}