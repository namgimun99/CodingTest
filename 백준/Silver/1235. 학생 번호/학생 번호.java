import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Set;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int num = Integer.parseInt(br.readLine());
        String[] empNo = new String[num];
        String checkEmpNo = "";
        Set<String> empNoSet = new TreeSet<>();
        int result = 0;
        for(int i = 0; i< num ; i++) {
            empNo[i] = br.readLine();
        }

        for(int i = 1; i<= empNo[0].length(); i++) {
            empNoSet.clear();
            for (String s : empNo) {
                checkEmpNo = s.substring(s.length() - i, s.length());

                if (empNoSet.contains(checkEmpNo)) {
                    continue;
                } else {
                    empNoSet.add(checkEmpNo);
                }
            }

            if(empNoSet.size() == empNo.length) {
                result = i;
                break;
            }
        }

        System.out.println(result);
        br.close();
    }
}
