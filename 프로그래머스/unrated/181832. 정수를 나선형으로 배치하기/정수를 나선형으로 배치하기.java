import java.util.Arrays;

class Solution {
    public int[][] solution(int n) {
        int[][] answer = new int[n][n];
        int row = 0;
        int col = 0;
        int move = 0;
        int num = 1;
        
        while (num <= n*n){
            
            answer[row][col] = num++;
            
            if(move == 0) {
                if(col == n-1 || answer[row][col+1] != 0){
                    move = 1;
                    row++;
                }   else {
                        col++;
                    }
            }
            else if(move == 1) {
                if(row == n-1 || answer[row+1][col] != 0){
                    move = 2;
                    col--;
                }   else {
                        row++;
                    }
            }
            
            else if(move == 2) {
                if(col == 0 || answer[row][col-1] != 0){
                    move = 3;
                    row--;
                }   else {
                        col--;
                    }
            }
            
            else if(move == 3) {
                if(row == 0 || answer[row-1][col] != 0){
                    move = 0;
                    col++;
                }   else {
                        row--;
                    }
            }
        }
        
        return answer;
    }
}