import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int aCnt = 0;
        int bCnt = 0;
        int result = Integer.MAX_VALUE;

        for(int i = 0 ; i < str.length(); i++) { // 연속해야하는 a의 갯수
            if(str.charAt(i) == 'a') aCnt++;
        }

        //원형으로 되어있으므로 맨 앞과 맨 뒤가 이어져야함
        str = str + str;

        for(int i = 0; i< str.length() - aCnt; i++) {
            String sw = str.substring(i, i+aCnt);
            bCnt = 0;
            for(int j = 0; j< sw.length(); j++) {

                if(sw.charAt(j) == 'b') {
                    bCnt++;
                }
            }
            result = Math.min(bCnt, result);
        }

        System.out.println(result);


        br.close();
    }
}
