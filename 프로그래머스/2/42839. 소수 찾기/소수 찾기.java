import java.util.*;

class Solution {
    static TreeSet<Integer> set;
    static boolean[] visit;
    
    public int solution(String numbers) {
        int answer = 0;
        
        String[] numList = new String[numbers.length()];
        visit = new boolean[numbers.length()];
        set = new TreeSet<>();
        int[] numArr = new int[10000000];
        int cnt = 0;


        for(int i = 0;i<numbers.length();i++){
            numList[i] = String.valueOf(numbers.charAt(i));
        }

        for(int i = 1;i<= numList.length;i++) {
            String[] result = new String[i];
            recursion(numList,result, i, 0);
        }

        numArr[0] = 1;
        numArr[1] = 1;

        for(int i = 2; i< 10000000; i++) {
            for(int j = 2; j<1000000; j++) {

                if(i*j >= 10000000) {
                    break;
                }
                numArr[i*j] = 1;
            }
        }

        int num = set.size();

        for(int i = 0; i< num; i++) {
            int pollNum = set.pollFirst();
            if(numArr[pollNum] == 0) {
                numArr[pollNum] = 3;
                answer++;
            }
        }

        return answer;
    }

private static int recursion(String[] numList,String[] result, int num, int cnt) {

        if(cnt >= num) {
            StringBuilder sb =new StringBuilder();

            for(int i = 0; i<result.length; i++) {
                sb.append(result[i]);
            }

            set.add(Integer.parseInt(sb.toString()));

            return 0;
        }

        for(int i = 0; i<numList.length; i++) {

            if(!visit[i]) {
                result[cnt] = numList[i];
                visit[i] = true;
                recursion(numList,result, num,cnt+1);
                visit[i] = false;
            }
        }
        return 0;
    }
}