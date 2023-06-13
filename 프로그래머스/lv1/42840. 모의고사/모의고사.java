import java.util.*;

class Solution {
    public List<Integer> solution(int[] answers) {
       List<Integer> answer = new ArrayList<>();
        int[] firstRule = {1,2,3,4,5};
        int[] secondRule = {2,1,2,3,2,4,2,5};
        int[] thirdRule = {3,3,1,1,2,2,4,4,5,5};
        int[] first = new int[answers.length]; //첫번째 수포자 배열
        int[] second = new int[answers.length]; //두번째 수포자 배열
        int[] third = new int[answers.length]; //세번째 수포자 배열
        
        int num = 0;
        //맞춘 갯수
        int cntst = 0;
        int cntnd = 0;
        int cntrd = 0;
        
        //맞춘 갯수로 배열만들기
        int[] allCount = new int[3];
        
        //맞춘 갯수 정렬과 비교를 위한 리스트 만들기
        List<Integer> sortCount = new ArrayList<>();
        
        // 첫번째 수포자 찍기
        for(int i = 0; i<answers.length;i++){
            num = i%5;
            first[i] = firstRule[num];
        }
        
        //두번째 수포자 찍기
         for(int i = 0; i<answers.length;i++){
             num = i%8;
             second[i] = secondRule[num];
        }
        
        //세번째 수포자 찍기
         for(int i = 0; i<answers.length;i++){
             num = i%10;
             third[i] = thirdRule[num];
        }
        
        // 수포자들 채점 결과
            for(int i = 0; i<answers.length;i++){
                
                if(first[i] == answers[i]){
                    cntst++;
                }
                
                if(second[i] == answers[i]){
                    cntnd++;
                }
                
                if(third[i] == answers[i]){
                    cntrd++;
                }
            
            }
       
        
        // 맞춘 갯수 배열에 넣기
        allCount[0] = cntst;
        allCount[1] = cntnd;
        allCount[2] = cntrd;
        
        for(int i = 0 ; i<allCount.length;i++){
            sortCount.add(allCount[i]);
        }
        
        // 제일 많이 맞춘 사람의 갯수 비교를 위해 정렬
        Collections.sort(sortCount);
        Collections.reverse(sortCount);
        
        //제일 많이 맞춘 갯수와 각자 맞춘 갯수 비교 후 같으면 결과 리스트에 추가
        for(int i = 0 ; i<sortCount.size();i++){
            if(sortCount.get(0) == allCount[i]){
                answer.add(i+1);
            }
        }

        return answer;
    }
}