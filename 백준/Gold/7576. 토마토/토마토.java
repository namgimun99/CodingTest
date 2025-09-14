import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

/*
6 4
0 0 0 0 0 0
0 0 0 0 0 0
0 0 0 0 0 0
0 0 0 0 0 1
*/
public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int col = Integer.parseInt(st.nextToken());
        int row = Integer.parseInt(st.nextToken());
        int day = 0;
        int[][] tomato = new int[row][col];
        int[] addCol = {1, 0, -1, 0};
        int[] addRow = {0, 1, 0, -1};
        int tomatoSeq = 0;
        int[] tomatoCol = new int[col*row];
        int[] tomatoRow = new int[row*col];



        for(int i = 0 ; i< row; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j<col; j++) {
                tomato[i][j] = Integer.parseInt(st.nextToken());

                if(tomato[i][j] == 1) {
                    tomatoCol[tomatoSeq] = j;
                    tomatoRow[tomatoSeq] = i;
                    tomatoSeq++;
                }
            }
        }

        for(int i = 0; i < tomatoSeq; i++) {
            for(int j = 0; j<4; j++) {
                int checkRow = tomatoRow[i]+addRow[j];
                int checkCol = tomatoCol[i]+addCol[j];
                if( checkRow >=0 && checkRow < row && checkCol >= 0 && checkCol<  col) {
                   if(tomato[checkRow][checkCol] == 0) {
                       tomato[checkRow][checkCol] = tomato[tomatoRow[i]][tomatoCol[i]] + 1;;
                       tomatoRow[tomatoSeq] = checkRow;
                       tomatoCol[tomatoSeq] = checkCol;
                       tomatoSeq++;
                   }
                }
            }
        }

        for(int i = 0; i< tomato.length; i++) {
            for(int j = 0; j<tomato[i].length; j++) {

                if(tomato[i][j] == 0) {
                    day = 0;
                    break;
                }
                day = Math.max(day,tomato[i][j]);
            }
            if(day == 0) break;
        }

        System.out.println(day-1);

        br.close();
    }
}
