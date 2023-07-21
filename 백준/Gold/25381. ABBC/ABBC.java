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

        for(int i = 0; i< temp.size(); i++){
            deque.offerLast(temp.get(i));
        }
        
        temp.clear();

        while(!deque.isEmpty()){
            if(deque.peekFirst() == 'A') {
                deque.pollFirst();
                for(int i = 0; i<deque.size();i++){
                    if(deque.peekFirst() == 'B') {
                        cnt++;
                        deque.pollFirst();
                        break;
                    }
                    else {
                        temp.add(deque.pollFirst());
                    }
                }
                Collections.reverse(temp);

                for(int i = 0; i<temp.size(); i++){
                    deque.offerFirst(temp.get(i));
                }

                temp.clear();
            }

            else {
                deque.pollFirst();
            }
        }

        pw.println(cnt);

        pw.close();
        br.close();
    }
}
