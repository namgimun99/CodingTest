import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);

        List<Integer> list = new ArrayList<>();
        List<Integer> resultList = new ArrayList<>();

        int sum = 0;
        int cnt = 0;

        for(int i = 0; i < 10; i++){
            list.add(Integer.parseInt(br.readLine()));

            if(sum + list.get(list.size()-1) >= 100) {
                resultList.add(sum);
                resultList.add(sum + list.get(list.size()-1));
                break;
            }

            else {
                sum = list.get(list.size()-1) + sum;
            }
            cnt++;
        }

        if(cnt == 10){
            pw.println(sum);
        }
        else{
            int s = -(resultList.get(0) - 100);
            int b = resultList.get(1) - 100;

            pw.println(s<b? resultList.get(0) : resultList.get(1));
        }


        pw.close();
        br.close();
    }
}