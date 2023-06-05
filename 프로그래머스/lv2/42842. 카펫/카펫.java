import java.util.*;

class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int [2];
        int a = 0;
        int b = 0;
        List<Integer> c = new ArrayList<>(); 

        //yellow 카펫이 배치될 수 있는 경우의 수 리스트 (양 끝)
        for(int i = 0; i<yellow; i++){
            if(yellow%(i+1) == 0){
                a = yellow/(i+1);
                c.add(a);
            }    
        }
        
        if(c.size()== 1){
            answer[0] = c.get(0) + 2;
            answer[1] = c.get(0) + 2;
            }
        
        //yellow 카펫을 감싼 brown 카펫의 수가 입력받은 brown 카펫 수와 같은지 검사
        for(int i = 0; i<c.size()/2;i++){
            
            a = (c.get(i) + 2) *2;
            b = (c.get(c.size()-i-1)) *2;
            
            if(c.size() % 2 == 1){
            answer[0] = c.get(c.size()/2) + 2;
            answer[1] = c.get(c.size()/2) + 2;
            }
            
            // 같으면 answer 배열에 추가
            if(a + b == brown){
                answer[0] = c.get(i) + 2;
                answer[1] = (c.get(c.size()-i-1)) +2 ;
            };
    
        }
        return answer;
    }
}