import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) throws IOException {


    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    PrintWriter pw = new PrintWriter(System.out);

    int num = Integer.parseInt(br.readLine());
    int cnt = 0;

    String str = "";
    List<String> inputList = new ArrayList<>();

    for(int i = 0; i<num; i++){
        str = br.readLine();
        inputList.add(str); // 들어온 순서대로 저장
    }

    int len = 0;
    int max = 0;
    int firstidx = 0;
    int secondidx = 0;

    for(int i = 0; i<inputList.size(); i++){
        for(int j = i+1; j<inputList.size(); j++){
            cnt = 0;
            len = inputList.get(i).length() > inputList.get(j).length() ? inputList.get(j).length() : inputList.get(i).length();
            for(int k = 0; k<len; k++){
                if(inputList.get(i).charAt(k) == inputList.get(j).charAt(k)){
                    cnt++;
                } else {
                    break;
                }
            }
            if(max<cnt) {
                max = cnt;
                firstidx = i;
                secondidx = j;
            }
        }
    }

    pw.println(inputList.get(firstidx));
    pw.println(inputList.get(secondidx));




    pw.close();
    br.close();
}
}
