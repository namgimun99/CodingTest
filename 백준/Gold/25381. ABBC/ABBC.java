import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{

        Deque<Character> deque = new LinkedList<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);

        String str = br.readLine();
        int cnt = 0;

        List<Character> temp = new ArrayList<>();

        for(int i = 0; i< str.length(); i++){
            temp.add(str.charAt(i));
        }

        //B, C 존재 유무 확인 후 제거
        while(true){
            if(temp.contains('B') && temp.contains('C')) {
                if(temp.indexOf('B') < temp.indexOf('C')) {
                    temp.remove(Character.valueOf('B'));
                    temp.remove(Character.valueOf('C'));
                    cnt++;
                } else {
                    temp.remove(Character.valueOf('C'));
                }
            } else {
                break;
            }
        }

        // 남은 A,B로 규칙 확인
        while(true){
            if(temp.contains('A') && temp.contains('B')) {
                if(temp.indexOf('A') < temp.indexOf('B')) {
                    temp.remove(Character.valueOf('A'));
                    temp.remove(Character.valueOf('B'));
                    cnt++;
                } else {
                    temp.remove(Character.valueOf('B'));
                }
            } else {
                break;
            }
        }

        pw.println(cnt);

        pw.close();
        br.close();
    }
}
