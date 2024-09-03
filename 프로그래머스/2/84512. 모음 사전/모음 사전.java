import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

class Solution {
    
    static List<String> list;
    
    public int solution(String word) {
        int answer = 0;
        
        String[] str = {"A","E","I","O","U"};
        list = new ArrayList<>();
        for(int i = 1; i<= 5; i++) {
            String[] answerArr = new String[i];
            nPr(str,answerArr, i, 0,0);
        }

        Collections.sort(list);
        
        answer = list.indexOf(word)+1;
        
        return answer;
    }
    
    private static int nPr(String[] str, String[] answerArr, int num,int startIdx, int cnt) {

        if(num <= cnt) {
            StringBuilder sb = new StringBuilder();
            for(int i = 0; i< answerArr.length; i++) {
                sb.append(answerArr[i]);
            }

            list.add(sb.toString());
            return 0;
        }

        for(int i = 0; i< str.length; i++) {
            answerArr[cnt] = str[i];
            nPr(str,answerArr, num, i,cnt+1);

        }


        return 0;
    }
}