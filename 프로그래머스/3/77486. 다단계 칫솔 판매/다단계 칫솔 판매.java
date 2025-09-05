import java.util.*;

class Solution {
    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        int[] answer = new int[enroll.length];
        
        Map<String, String> map = new HashMap<>();
        Map<String, Integer> money = new HashMap<>();
        String sellerName = "";
        int upMoney=0;
        for(int i= 0; i< enroll.length; i++) {
            map.putIfAbsent(enroll[i], "");
            money.putIfAbsent(enroll[i], 0);
        }

        for(int j = 0; j< referral.length; j++) {
            map.put(enroll[j],referral[j]);
        }

        for(int i = 0; i<seller.length;i++) {
            int realMoney = amount[i] * 100;
            int keep = realMoney - realMoney / 10; //90프로 가질거야
            int pass = realMoney / 10; // 10프로 넘겨줄거야

            money.put(seller[i], money.get(seller[i]) + keep); // 내가 90프로 가졌어
            sellerName = map.get(seller[i]); // 윗사람 찾았어
            upMoney = pass; // 10퍼센트 줄거야

            while(true) {
                if (sellerName.equals("-") || upMoney < 1) {
                    break;
                }

                keep = upMoney - upMoney / 10;
                pass = upMoney / 10;

                money.put(sellerName, money.get(sellerName) + keep);

                //다음사람 찾았어
                sellerName = map.get(sellerName);
                upMoney = pass;//10프로 위에줬어

            }
        }
        
        for(int i = 0 ;i<enroll.length; i++) {
            answer[i] = money.get(enroll[i]);
        }
        
        return answer;
    }
}