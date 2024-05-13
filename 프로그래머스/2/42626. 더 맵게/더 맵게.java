import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        
        for(int num : scoville) {
            priorityQueue.add(num);
        }
        
        int num1 = 0;
        int num2 = 0;
        int sum = 0;
        int cnt = 0;
        boolean flag = true;
        
        while(true) {
            if(priorityQueue.size() == 1) {
                num1 = priorityQueue.poll();
                if(num1 >= K) {
                    answer = cnt;
                } else {
                    answer = -1;
                }
                break;
            }
            num1 = priorityQueue.poll();
            num2 = priorityQueue.poll();
            if((num1 >= K)) {
                answer = cnt;
                break;
            }
            sum = num1 + (num2*2);
            cnt++;
            priorityQueue.add(sum);
        }

        
        return answer;
    }
}