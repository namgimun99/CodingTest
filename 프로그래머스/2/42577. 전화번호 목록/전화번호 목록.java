import java.util.*;
import java.io.*;

class Solution {
    public boolean solution(String[] phone_book) throws IOException{
       boolean answer = true;
        
        Arrays.sort(phone_book);
        
        for(int i = 0; i<phone_book.length-1; i++) {
            String prefix = phone_book[i];
            if(phone_book[i].length() > phone_book[i+1].length()) {continue;}
            if(phone_book[i+1].startsWith(prefix)) {
                answer = false;
                break;
}
        }
        return answer;
    }
}