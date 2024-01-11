class Solution {
    public boolean solution(boolean x1, boolean x2, boolean x3, boolean x4) {
        boolean answer = true;
        boolean n1 = false;
        boolean n2 = false;
        
        if(x1 || x2) {
            n1 = true;
        }
        
        if(x3 || x4) {
            n2 = true;
        }
        
        if(n1 && n2) {
            answer = true;
        } else {
            answer = false;
        }
        return answer;
    }
}