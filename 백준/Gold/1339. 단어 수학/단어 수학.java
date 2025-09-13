import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        int num = Integer.parseInt(br.readLine());
        String[] strArr = new String[num];

        for(int i = 0; i< num; i++) {
            strArr[i] = br.readLine();
        }

        String number = "";
        int[] arr = new int[27];
        int ch = 0;
        int n = 9;
        int sum = 0;
        List<Integer> list = new ArrayList<>();


        for(int i = 0; i<strArr.length; i++) {
            for(int j = 0; j<strArr[i].length(); j++) {
                StringBuilder sb = new StringBuilder();
                sb.append(1);
                for(int k = j+1; k<strArr[i].length(); k++) {
                    sb.append(0);
                }

                ch = strArr[i].charAt(j) - 65;
                number = sb.toString();
                arr[ch] += Integer.parseInt(number);
            }
        }

        for(int i = 0; i<arr.length; i++) {
            if(arr[i] != 0) {
                list.add(arr[i]);
            }
        }

        Collections.sort(list, Collections.reverseOrder());

        for(int i = 0; i< list.size(); i++) {
            sum += list.get(i) * n;
            n--;
        }
        System.out.println(sum);



        br.close();

    }
}
