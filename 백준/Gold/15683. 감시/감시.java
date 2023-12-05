import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int tvCnt = 0;
    static int minBlind = Integer.MAX_VALUE;
    static int[] answer;
    static int[] dx = {1,0,-1,0};
    static int[] dy = {0,1,0,-1};
    static int[][] tvDirection;
    static List<Integer> cctv;
    static List<Integer> cctvX;
    static List<Integer> cctvY;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        StringTokenizer st = new StringTokenizer(br.readLine());

        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        tvDirection = new int[x][y];
        cctv = new ArrayList<>();
        cctvX = new ArrayList<>();
        cctvY = new ArrayList<>();
        int[] watch = {0,1,2,3};



        for(int i = 0; i<x; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j<y; j++){
                tvDirection[i][j] = Integer.parseInt(st.nextToken());
                if(tvDirection[i][j] >0 && tvDirection[i][j] < 6) {
                    cctv.add(tvDirection[i][j]);
                    cctvX.add(i);
                    cctvY.add(j);
                    tvCnt++;
                }
            }
        }

        answer = new int[tvCnt];

        see(0, watch);


        pw.println(minBlind);

        br.close();
        pw.close();
    }

    public static void see(int count, int[] watch) {
        if(count >= tvCnt) {
            int[][] tempDirection = new int[tvDirection.length][tvDirection[0].length];

            for(int i = 0; i<tvDirection.length; i++) {
                System.arraycopy(tvDirection[i],0,tempDirection[i],0,tvDirection[0].length);
            }

            for(int i = 0; i< answer.length; i++){
                if(cctv.get(i) == 1) {
                    active1(answer[i],cctvX.get(i),cctvY.get(i),tempDirection);
                } else if(cctv.get(i) == 2) {
                    active2(answer[i],cctvX.get(i),cctvY.get(i),tempDirection);
                } else if(cctv.get(i) == 3) {
                    active3(answer[i],cctvX.get(i),cctvY.get(i),tempDirection);
                } else if(cctv.get(i) == 4) {
                    active4(answer[i],cctvX.get(i),cctvY.get(i),tempDirection);
                } else if(cctv.get(i) == 5) {
                    active5(answer[i],cctvX.get(i),cctvY.get(i),tempDirection);
                }
            }
            int blind = 0;

            for(int i = 0; i< tempDirection.length; i++){
                for(int j = 0; j< tempDirection[0].length; j++) {
                    if(tempDirection[i][j] == 0) {
                        blind++;
                    }
                }
            }

            minBlind = Math.min(blind,minBlind);
            return;
        }

        for(int i = 0; i<watch.length; i++) {
            answer[count] = watch[i];
            see(count+1,watch);
        }
    }

    public static boolean checkRange(int cnt,int answer, int xL, int yL, int[][] tempDirection) {
        if(xL+(dx[answer]*cnt) >= 0 && xL+(dx[answer]*cnt) < tempDirection.length
                && yL+(dy[answer]*cnt) >= 0 && yL+(dy[answer]*cnt) < tempDirection[0].length) {
            return true;
        } else {
            return false;
        }
    }

    public static void move(int answer, int xL, int yL, int[][] tempDirection) {
        int cnt = 0;

        while(checkRange(cnt, answer, xL,yL,tempDirection)){
            if(tempDirection[xL+(dx[answer]*cnt)][yL+(dy[answer]*cnt)] == 0) {
                tempDirection[xL+(dx[answer]*cnt)][yL+(dy[answer]*cnt)] = -1;
            } else if(tempDirection[xL+(dx[answer]*cnt)][yL+(dy[answer]*cnt)] == 6) {
                break;
            }
            cnt++;
        }
    }
    public static void active1(int answer,int xL, int yL,int[][] tempDirection){
        move(answer,xL,yL,tempDirection);
    }

    public static void active2(int answer,int xL, int yL,int[][] tempDirection){
        if(answer % 2 == 0) {
            move(0,xL,yL,tempDirection);
            move(2,xL,yL,tempDirection);
        }
        else {
            move(1,xL,yL,tempDirection);
            move(3,xL,yL,tempDirection);
        }
    }

    private static void active3(int answer, int xL, int yL, int[][] tempDirection) {
        move(answer,xL,yL,tempDirection);
        move((answer+1)%4 ,xL,yL,tempDirection);

    }

    private static void active4(int answer, int xL, int yL, int[][] tempDirection) {
        move(answer,xL,yL,tempDirection);
        if(answer % 2 == 1) {
            move(0,xL,yL,tempDirection);
            move(2,xL,yL,tempDirection);
        }
        else {
            move(1,xL,yL,tempDirection);
            move(3,xL,yL,tempDirection);
        }
    }

    private static void active5(int answer, int xL, int yL, int[][] tempDirection) {
        move(0,xL,yL,tempDirection);
        move(2,xL,yL,tempDirection);
        move(1,xL,yL,tempDirection);
        move(3,xL,yL,tempDirection);
    }
}