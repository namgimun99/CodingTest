import java.util.*;

class Solution {
    boolean solution(String s) {
        boolean answer = true;

        Queue<Character> queue = new LinkedList<>();

        for(int i = 0; i< s.length(); i++) {
            if(s.charAt(i) == '(') {
                queue.add('(');
            } else {
                if(queue.isEmpty()) {
                    answer = false;
                    break;
                } else {
                    queue.remove();
                }
            }
        }

        if(answer == true) {
            if(!queue.isEmpty()) {
                answer = false;
            }
        }
        return answer;
    }
}