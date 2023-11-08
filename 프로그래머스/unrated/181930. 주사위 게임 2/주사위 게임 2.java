import java.util.*;

class Solution {
    public int solution(int a, int b, int c) {
        int answer = 0;
        int cnt = 0;
        List<Integer> list = new ArrayList<>();
        
        list.add(a);
        list.add(b);
        list.add(c);
        for(int i = 0; i < list.size()-1; i++){
            for(int j = i+1; j<list.size(); j++){
                if(list.get(i) == list.get(j)){
                    cnt++;
                }
            }
        }
        
        if(cnt == 0){
            answer = a+b+c;
        } else if(cnt == 1) {
            answer = (a+b+c)*(a*a+b*b+c*c);
        } else if(cnt == 3){
            answer = (a+b+c)*(a*a+b*b+c*c)*(a*a*a+b*b*b+c*c*c);
        }
        return answer;
    }
}