import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);

        int T = Integer.parseInt(br.readLine());
        Stack<Character> stack = new Stack<>();
        Deque<Integer> deque = new LinkedList<>();

        String func = "";

        int N = 0;

        for(int i = 0; i < T; i++){
            func = br.readLine();

            N = Integer.parseInt(br.readLine());

            StringTokenizer st = new StringTokenizer(br.readLine(), "[],");
            boolean flag = true;

            for(int j = 0; j< N; j++){
                deque.offer(Integer.parseInt(st.nextToken()));
            }

            for(int j = 0; j< func.length(); j++){
                if(func.charAt(j) == 'R') {
                    if(stack.isEmpty()) {
                        stack.add('R');
                    } else {
                        stack.pop();
                    }
                } else {
                    if(deque.isEmpty()) {
                        pw.println("error");
                        flag = false;
                        break;
                    }
                    if(stack.size() == 1){
                        deque.pollLast();
                    } else {
                        deque.pollFirst();
                    }
                }
            }

            if(flag) {

                StringBuilder sb = new StringBuilder();
                sb.append("[");

                if(stack.size()== 1){
                    while(true){
                        if(deque.isEmpty()) {
                            sb.append("]");
                            break;
                        }

                        sb.append(deque.pollLast());
                        if(!deque.isEmpty()) {
                            sb.append(",");
                        }
                    }

                } else {
                    while(true){
                        if(deque.isEmpty()) {
                            sb.append("]");
                            break;
                        }
                        sb.append(deque.pollFirst());
                        if(!deque.isEmpty()) {
                            sb.append(",");
                        }
                    }
                }

                pw.println(sb);

                deque.clear();
                
            }
            stack.clear();
            }


        pw.close();
        br.close();
    }
}
