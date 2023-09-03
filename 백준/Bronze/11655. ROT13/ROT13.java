import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);

        String input = br.readLine();
        char ch = ' ';

        for(int i = 0; i<input.length(); i++){
            ch = input.charAt(i);
            if(ch >=65 && ch<=90) {
                ch = (char) (ch + 13);
                if(ch > 90){
                    ch = (char) (ch - 90 + 64);
                }
            } else if(ch >=97 && ch <=122) {
                ch = (char) (ch + 13);
                if(ch > 122){
                    ch = (char) (ch - 122 + 96);
                }
            }

            pw.print(ch);

        }

        pw.close();
        br.close();
    }
}
