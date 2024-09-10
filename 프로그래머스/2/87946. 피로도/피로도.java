class Solution {
    
    private static int temp;
    
    public int solution(int k, int[][] dungeons) {
        int answer = -1;
        
        temp = 0;


        boolean[] visit = new boolean[dungeons.length];
        int[][] result = new int[dungeons.length][dungeons[0].length];

        recursion(dungeons,visit,result,dungeons.length,0,k);
        
        answer = temp;
        
        return answer;
    }
    
     private static int recursion(int[][] dungeons, boolean[] visit,  int[][] result, int num, int cnt, int k) {

        if(cnt >= num) {
            int answer = 0;
            for(int i = 0; i< result.length; i++) {

                if(k >= result[i][0]) {
                    answer++;
                } else {
                    break;
                }
                k = k-result[i][1];

            }
            temp = Math.max(temp, answer);
            return temp;
        }

        for(int i = 0; i<dungeons.length; i++) {
            if(!visit[i]) {
                result[cnt] = dungeons[i];
                visit[i] = true;
                recursion(dungeons,visit,result,num,cnt+1,k);
                visit[i] = false;
            }
        }
        return 0;
    }
}