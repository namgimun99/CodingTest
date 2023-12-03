import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
        public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            PrintWriter pw = new PrintWriter(System.out);

            int testcase = Integer.parseInt(br.readLine());
            List<Integer> bag1List = new ArrayList<>();
            List<Integer> bag2List = new ArrayList<>();

            for (int i = 0; i < testcase; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int bag1 = Integer.parseInt(st.nextToken());
                int bag2 = Integer.parseInt(st.nextToken());

                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < bag1; j++) {
                    bag1List.add(Integer.parseInt(st.nextToken()));
                }

                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < bag2; j++) {
                    bag2List.add(Integer.parseInt(st.nextToken()));
                }

                Collections.sort(bag1List);
                Collections.sort(bag2List);


                int cnt = 0;

                for (int j = bag1List.size()-1; j >= 0; j--) {

                    int leftIdx = 0;
                    int rightIdx = bag2List.size()-1;
                    int checkIdx = 0;

                    if(bag1List.get(j) > bag2List.get(rightIdx)){
                        cnt += (rightIdx+1);
                    } else {
                        while (leftIdx <= rightIdx) {
                            checkIdx = (leftIdx + rightIdx)/2;
                            if(bag1List.get(j) < bag2List.get(checkIdx)) {
                                rightIdx = checkIdx-1;
                            } else if(bag1List.get(j) > bag2List.get(checkIdx)){
                                leftIdx = checkIdx+1;
                            } else {
                                break;
                            }
                        }

                        while(bag2List.get(checkIdx) >= bag1List.get(j) && checkIdx >= 0) {
                            checkIdx--;
                            if(checkIdx == -1){
                                break;
                            }
                        }
                        cnt += (checkIdx+1);
                    }
                }

                pw.println(cnt);
                bag1List.clear();
                bag2List.clear();
            }

            br.close();
            pw.close();
        }
    }

