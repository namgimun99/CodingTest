import java.util.*;

class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int [2];
        int a = 0;
        int b = 0;
        List<Integer> c = new ArrayList<>(); 

        
        for(int i = 0; i<yellow; i++){
            if(yellow%(i+1) == 0){
                a = yellow/(i+1);
                c.add(a);
            }    
        }
                    
        System.out.println(c);
        if(c.size() % 2 == 1){
            answer[0] = c.get(c.size()/2) + 2;
            answer[1] = c.get(c.size()/2) + 2;
        }
        
        for(int i = 0; i<c.size()/2;i++){
            
            a = (c.get(i) + 2) *2;
            b = (c.get(c.size()-i-1)) *2;
            
            if(a + b == brown){
                answer[0] = c.get(i) + 2;
                answer[1] = (c.get(c.size()-i-1)) +2 ;
            };

            
            
                
        }
        return answer;
    }
}