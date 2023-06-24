class Solution {
    
    static String[] word = {"aya", "ye", "woo", "ma"};
    
    public int solution(String[] babbling) {
        
		int answer = 0;
		int length = 0;
		
	    for(int i = 0; i<babbling.length;i++) {
	    	length = babbling[i].length();
	    	for(int j = 0; j<word.length;j++) {

	    		if(babbling[i].contains(word[j])) {
	    			length = length-word[j].length();
	    		};
	    	}
	    	if(length == 0) {
				answer++;
			}
	    }
	    return answer;
	 }
}