class Solution {
    public int solution(int a, int b) {
        int answer = 0;
        String aa = String.valueOf(a);
        String bb = String.valueOf(b);
        
        int aanum = Integer.parseInt(aa.concat(bb));
        int bbnum = Integer.parseInt(bb.concat(aa));
        
        if(aanum >= bbnum){
            answer = aanum;
        } else {
            answer = bbnum;
        }
        return answer;
    }
}