import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String a = sc.next();
        char s = 0;
        
        for(int i = 0; i <a.length(); i++){
            
            char c = a.charAt(i);
            
            if(c >= 65 && c<91){
                s = (char)(c+32);
            }
            
            if(c>=97 && c <122){
                s = (char)(c-32);
            }
            
            System.out.print(s);
            
        }
        
    }
}