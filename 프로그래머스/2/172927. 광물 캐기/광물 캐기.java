import java.util.*;

class Solution {
    public int solution(int[] picks, String[] minerals) {
        int answer = 0;
        
        int[] diaCnt = new int[10];
        int[] ironCnt = new int[10];
        int[] stoneCnt = new int[10];
        int needPick = (minerals.length + 4) / 5;
        int pickCnt = 0;

        // 1. 5개 단위로 광물 카운트
        for (int i = 0; i < minerals.length; i++) {
            int num = i / 5;
            if (minerals[i].equals("diamond")) diaCnt[num]++;
            if (minerals[i].equals("iron")) ironCnt[num]++;
            if (minerals[i].equals("stone")) stoneCnt[num]++;
        }

        for(int i = 0 ; i<picks.length; i++) {
            pickCnt += picks[i];
        }
        
        int useDiaPick = 0;
        int useIronPick = 0;
        int useStonePick = 0;
        List<int[]> blocks = new ArrayList<>();
        
        if(pickCnt >= needPick) { // 곡괭이의 갯수가 충분할 때
            
            // 2. 블록 묶음 만들기
            for (int i = 0; i < (minerals.length+4)/5; i++) {
                blocks.add(new int[]{diaCnt[i], ironCnt[i], stoneCnt[i], i , 0});
            }
        }  
        //곡괭이가 더 부족할 때
        else {
            for (int i = 0; i < pickCnt; i++) {
                blocks.add(new int[]{diaCnt[i], ironCnt[i], stoneCnt[i], i , 0});
            }
        }
        
        
        // 3. 정렬 (다이아 > 철 > 돌 개수 순으로 내림차순)
        blocks.sort((a, b) -> {
            if (a[0] != b[0]) return b[0] - a[0];
            if (a[1] != b[1]) return b[1] - a[1];
            return b[2] - a[2];
        });

        for(int i = 0; i<blocks.size(); i++) {
            if(useDiaPick < picks[0]) {
                blocks.get(i)[4] = 0;
                useDiaPick++;
            } else if(useIronPick < picks[1]) {
                blocks.get(i)[4] = 1;
                useIronPick++;
            } else {
                blocks.get(i)[4] = 2;
                useStonePick++;
            }
        }

        
        // 피로도 누적
        for(int i = 0; i< blocks.size(); i++) {
            for(int j = 0; j< 3; j++) {
                if(blocks.get(i)[4] == 0) { // 다이아 곡괭이
                    answer += blocks.get(i)[j];
                } else if(blocks.get(i)[4] == 1) { // 철 곡괭이
                    if(j == 0) {
                        answer += blocks.get(i)[j] * 5;
                    } else {
                        answer += blocks.get(i)[j];
                    }
                } else { // 돌 곡괭이
                    if(j == 0) {
                        answer += blocks.get(i)[j] * 25;
                    } else if(j == 1) {
                        answer += blocks.get(i)[j] * 5;
                    } else {
                        answer += blocks.get(i)[j];
                    }
                }
                
            }
        }
        // 확인용 출력
        for (int[] block : blocks) {
            System.out.println(Arrays.toString(block));
        }
        
        return answer;
    }
}