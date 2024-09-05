import java.util.*;

class Solution {
    public int[] solution(int n, String[] words) {
        int[] answer = new int[2];

        int cnt = 0;
        int person = 0;
        int num = 0;

        Set<String> set = new HashSet<>();
        set.add(words[0]);

        for(int i = 1; i<words.length; i++) {
            if(!words[i].startsWith(String.valueOf(words[i-1].charAt((words[i-1].length()-1))))) {
                cnt = i+1;
                break;
            }

            if(set.contains(words[i])) {
                cnt = i+1;
                break;
            }

            set.add(words[i]);
        }

        person = (cnt != 0 && ((cnt) % n) == 0) ? n : (cnt) % n;
        num = ((cnt) / n) + (((cnt) % n) == 0 ? 0 : 1);

        answer[0] = person;
        answer[1] = num;

        return answer;
    }
}