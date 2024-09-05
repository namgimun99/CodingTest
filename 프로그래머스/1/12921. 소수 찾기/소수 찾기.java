class Solution {
    public int solution(int n) {
        int answer = 0;
        
        int[] arr = new int[n];
        arr[0] = 1;

        for(int i = 2; i<=n; i++) {
            int num = 2;
            while(true) {
                if(i * num > n) {
                    break;
                }
                arr[i*num-1] = 1;
                num++;
            }
        }

        for(int i = 0; i< arr.length; i++) {
            if(arr[i] == 0) {
                answer++;
            }
        }
        
        return answer;
    }
}