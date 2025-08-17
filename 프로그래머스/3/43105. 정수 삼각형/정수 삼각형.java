import java.util.*;

class Solution {
    public int solution(int[][] triangle) {
    int[][] sumTriangle = new int[triangle.length][triangle.length];

        sumTriangle[0][0] = triangle[0][0];

        for(int i = 1; i < triangle.length; i++) {

            sumTriangle[i][0] = sumTriangle[i-1][0] + triangle[i][0];

            for(int j = 1; j< triangle[i].length-1; j++) {

                sumTriangle[i][j] = Math.max(sumTriangle[i-1][j] + triangle[i][j] , sumTriangle[i-1][j-1] + triangle[i][j]);

            }

            sumTriangle[i][triangle[i].length -1] = sumTriangle[i-1][triangle[i].length -2] + triangle[i][triangle[i].length -1];
        }

        return Arrays.stream(sumTriangle[sumTriangle.length-1]).max().getAsInt();
    }
}