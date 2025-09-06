import java.util.*;

//1. 임의의 사원보다 두 점수가 모두 낮은 경우가 한번이라도 있으면 인센티브 X
//2. 인센티브를 받는 사원 중 두 점수의 합이 높은 순으로 인센티브 차등 지급
//3. 두 점수의 합이 동일한 사원은 같은 석차이고, 그만큼 다음 석차 건너 뜀

class Solution {
    public int solution(int[][] scores) {
        int answer = 0;
        
        boolean[] fail = new boolean[scores.length];
        int[] point = new int[scores.length];
        int rank = 1;
        int maxEval = 0;
        
        //1.인센티브를 못받는 사람들 구하기
        int[][] arr = new int[scores.length][3];
        for (int i = 0; i < scores.length; i++) {
            arr[i][0] = scores[i][0];
            arr[i][1] = scores[i][1];
            arr[i][2] = i;
        }

        // att 내림차순, att 같으면 eval 오름차순
        Arrays.sort(arr, new Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                if (b[0] != a[0]) return b[0] - a[0];
                return a[1] - b[1];
            }
        });
        
        for (int i = 0; i < scores.length; i++) {
            int att = arr[i][0];
            int eval = arr[i][1];
            int idx = arr[i][2];

            if (eval < maxEval) fail[idx] = true;
            else maxEval = eval;

            if (!fail[idx]) point[idx] = att + eval;
            else point[idx] = -1;
        }
        
        //2. 인센티브를 받는 사람들에 완호가 포함되어있는지 구하기
        if(fail[0]) {
            answer = -1;
            return answer;
        }
        
        //4. 완호 등수 구하기
        for(int i = 1; i<point.length; i++) {
            if(point[0] < point[i]) {
                rank++;
            }
        }
        
        answer = rank;
    
        return answer;
    }
}