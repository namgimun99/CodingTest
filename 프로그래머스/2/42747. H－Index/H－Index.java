import java.util.Arrays;

class Solution {
    public int solution(int[] citations) {
        int answer = 0;
        
        int smallCnt = 0;
        int bigCnt = citations.length;
        
        Arrays.sort(citations);

        for(int i = 0; i< citations[citations.length-1]; i++) {


            if(citations[smallCnt] == i) {
                bigCnt = citations.length - smallCnt +1;
            } else {
                bigCnt = citations.length - smallCnt;
            }


            if(bigCnt >= i && smallCnt <= i) {
                answer = i;
            }

            if(citations[smallCnt] <= i) {
                smallCnt++;
            }
        }
        
        return answer;
    }
}