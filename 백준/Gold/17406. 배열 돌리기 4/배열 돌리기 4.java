import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int[] answer;
    static boolean[] visit;
    static List<Integer> seeList = new ArrayList<>();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[][] arr = new int[n][m];
        List<Integer>[] rotaNum = new List[k];
        answer = new int[k];
        visit = new boolean[k];

        for(int i = 0; i< n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j<m; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i = 0; i<k; i++){
            st = new StringTokenizer(br.readLine());
            List<Integer> list = new ArrayList<>();
            for(int j = 0; j<3; j++){
                list.add(Integer.parseInt(st.nextToken()));
            }
            rotaNum[i] = list;
        }

        rotation(0,k, rotaNum, arr);

        int min = Integer.MAX_VALUE;
        for(int i = 0; i< seeList.size(); i++){
            min = Math.min(min,seeList.get(i));
        }

        pw.println(min);

        br.close();
        pw.close();
    }

    public static void rotation(int cnt, int k,List<Integer>[] rotaNum, int[][] arr) {
        if(cnt >= k) {

            int[][] tempArr = new int[arr.length][arr[0].length];

            for(int i = 0; i<arr.length; i++) {
                System.arraycopy(arr[i],0,tempArr[i],0,arr[0].length);
            }

            int startIdxX = 0;
            int startIdxY = 0;
            int endIdxX = 0;
            int endIdxY = 0;
            for(int i = 0; i<answer.length; i++){
                startIdxX = rotaNum[answer[i]].get(0) - rotaNum[answer[i]].get(2)-1;
                startIdxY = rotaNum[answer[i]].get(1) - rotaNum[answer[i]].get(2)-1;
                endIdxX = rotaNum[answer[i]].get(0) + rotaNum[answer[i]].get(2)-1;
                endIdxY = rotaNum[answer[i]].get(1) + rotaNum[answer[i]].get(2)-1;

                turn(startIdxX,startIdxY,endIdxX,endIdxY,tempArr);
            }

            int min = Integer.MAX_VALUE;
            for(int j = 0; j< tempArr.length; j++){
                int sum = 0;
                for(int l = 0; l<tempArr[0].length; l++) {
                    sum += tempArr[j][l];
                }
                min = Math.min(min,sum);
            }

            seeList.add(min);
            return;
        }

        for(int i = 0; i<k; i++){
            if(!visit[i]){
                answer[cnt] = i;
                visit[i] = true;
                rotation(cnt+1,k,rotaNum,arr);
                visit[i] = false;
            }
        }

    }

    public static void turn(int startIdxX,int startIdxY,int endIdxX,int endIdxY,int[][] tempArr) {

        if(startIdxX >= endIdxX || startIdxY >= endIdxY) {
            return;
        }

        int temp = 0;
        int temp2 = 0;
        int turn = 0;
        int i = startIdxX;
        int j = startIdxY;

        temp = tempArr[i][j];
        tempArr[i][j] = tempArr[i+1][j];
        j++;

        while(true){

            if(i==startIdxX && j ==startIdxY) {
                turn++;
                if(turn == 1) {
                    break;
                }
            }
            if(j < endIdxY && i == startIdxX) {
                temp2 = temp;
                temp = tempArr[i][j];
                tempArr[i][j] = temp2;
                j++;
                continue;
            }

            if(i < endIdxX && j == endIdxY) {
                temp2 = temp;
                temp = tempArr[i][j];
                tempArr[i][j] = temp2;
                i++;
                continue;
            }

            if(j> startIdxY && i == endIdxX) {
                temp2 = temp;
                temp = tempArr[i][j];
                tempArr[i][j] = temp2;
                j--;
                continue;
            }

            if(i> startIdxX && j == startIdxY) {
                temp2 = temp;
                temp = tempArr[i][j];
                tempArr[i][j] = temp2;
                i--;
                continue;
            }
        }

        turn(startIdxX+1,startIdxY+1,endIdxX-1,endIdxY-1,tempArr);

    }
}