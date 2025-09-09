import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String a = br.readLine();
        String b = br.readLine();

        while(b.length() > a.length()) {
            if(b.charAt(b.length()-1) == 'A') {
                b = b.substring(0, b.length()-1);
            } else {
                b = new StringBuilder(b.substring(0, b.length()-1)).reverse().toString();
            }
        }

        if(b.equals(a)) {
            System.out.println(1);
        } else {
            System.out.println(0);
        }
    }

    public static String minusA(String str) {
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i< str.length()-1; i++) {
            sb.append(str.charAt(i));
        }
        str = sb.toString();
        return str;
    }

    public static String minusBReverse(String str) {

        StringBuilder sb = new StringBuilder();
        char ch;

        for(int i = 1 ; i< str.length(); i++) {
            ch = str.charAt(str.length()-1-i);

            sb.append(ch);
        }

        str = sb.toString();

        return str;
    }

}
