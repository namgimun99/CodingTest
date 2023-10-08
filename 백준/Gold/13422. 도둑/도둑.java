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
        StringTokenizer st ;

        int testCase = Integer.parseInt(br.readLine());



        for(int i = 0; i<testCase; i++) {
            st = new StringTokenizer(br.readLine());

            int town = Integer.parseInt(st.nextToken());
            int home = Integer.parseInt(st.nextToken());
            int money = Integer.parseInt(st.nextToken());
            int counting = 0;
            List<Integer> list = new ArrayList<>();
            List<Integer> countingList = new ArrayList<>();

            st = new StringTokenizer(br.readLine());

            for(int j = 0; j < town; j++){
                int num = Integer.parseInt(st.nextToken());
                list.add(num);
                counting += num;
                countingList.add(counting);
            }

            for(int j = 0; j<list.size(); j++){
                countingList.add(countingList.get(countingList.size()-1) + list.get(j));
            }

            int start = 0;
            int end = home;
            int endpoint = town;
            int cnt = 0;

            if(town == home){
                if(counting < money){
                    cnt++;
                }
            } else {
                while(true){
                    if(start == endpoint){
                        break;
                    }

                    int startHome = countingList.get(start%(town*2));
                    int endHome = countingList.get(end%(town*2));

                    if(startHome !=0) {
                        if(endHome-startHome < money) {
                            cnt++;
                        }
                    } else {
                        if(endHome < money) {
                            cnt++;
                        }
                    }

                    start++;
                    end++;

                }
            }

            pw.println(cnt);
        }



        br.close();
        pw.close();
    }
}
