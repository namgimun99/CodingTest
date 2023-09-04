import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);

        int N = Integer.parseInt(br.readLine());
        int cnt = 0;
        int result = 0;
        String str = "";

        Set<Character> set = new TreeSet<>();
        Deque<Character> deq = new LinkedList<>();
        int[] arr = new int[26];

        for(int i = 0; i<N; i++){
            str = br.readLine();

            for(int j = 0; j<str.length(); j++){
                set.add(str.charAt(j));
                if(deq.isEmpty()){
                    deq.offerLast(str.charAt(j));
                } else {
                    if(deq.peekLast() != str.charAt(j)){
                        arr[deq.peekLast() - 97] = arr[deq.peekLast() - 97] + 1;
                        deq.offerLast(str.charAt(j));
                    }
                }

                if(j == str.length()-1) {
                    arr[deq.peekLast() - 97] = arr[deq.peekLast() - 97] + 1;
                }

            }

            for(int j = 0; j < arr.length; j++){
                if(arr[j] == 1) {
                    cnt++;
                }
            }
            if(cnt == set.size()){
                result++;
            }

            cnt = 0;
            arr = new int[26];
            set.clear();
            deq.clear();
        }

        pw.println(result);

        pw.close();
        br.close();
    }
}
