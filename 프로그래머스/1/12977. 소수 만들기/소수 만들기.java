class Solution {

    static int count;
    static int answer;
    static int sum;
    static int[] choice;

    public int solution(int[] nums) {
        int answer = 0;
        choice = new int[3];

        answer = nCr(0,0,nums);
        return answer;
    }

    private static int nCr(int cnt,int start,int[] nums) {
        sum = 0;
        count = 0;

        if(cnt == 3) {
            for(int i = 0; i< choice.length; i++){
                sum += choice[i];
            }
            for(int i = 1; i<= sum; i++){
                if(sum % i == 0){
                    count++;
                }
            }

            if(count <= 2){
                answer++;
            }
            return answer;
        }


        for(int i = start; i<nums.length; i++){
            choice[cnt] = nums[i];
            nCr(cnt+1,i+1,nums);
        }
        return answer;
    }
}