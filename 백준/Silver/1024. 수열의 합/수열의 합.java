import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);

        StringTokenizer st = new StringTokenizer(br.readLine());

        int num = Integer.parseInt(st.nextToken());
        int length = Integer.parseInt(st.nextToken());
        int minLength = 0;
        int answer = 0;
        boolean lengFlag = false;

        for(int i = length; i<=100; i++) {

            double constant = 0;
            double first_num = 0;

            for (int j = 1; j < i; j++) {
                constant += j;
            }
            first_num = (num - constant) / i;

            if(first_num == (int)first_num && first_num >= 0) {
                minLength = i;
                answer = (int)first_num;
                lengFlag= true;
                break;
            }
        }

        if(lengFlag) {
            for(int i = 0; i<minLength; i++) {
                pw.print(answer + i + " ");
            }
        } else {
            pw.println(-1);
        }




        pw.close();
        br.close();
    }
}
