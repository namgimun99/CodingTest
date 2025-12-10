import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        Map<String, Integer> countMap = new HashMap<>();

        // 1. 단어 입력 + 길이 조건 + 개수 카운트
        for (int i = 0; i < N; i++) {
            String word = br.readLine();
            if (word.length() < M) continue;

            countMap.put(word, countMap.getOrDefault(word, 0) + 1);
        }

        // 2. 단어 리스트로 변환
        List<String> words = new ArrayList<>(countMap.keySet());

        // 3. 정렬 조건 정의
        words.sort((a, b) -> {
            int cntA = countMap.get(a);
            int cntB = countMap.get(b);

            if (cntA != cntB) {
                return cntB - cntA;               // 1) 빈도 내림차순
            }
            if (a.length() != b.length()) {
                return b.length() - a.length();  // 2) 길이 내림차순
            }
            return a.compareTo(b);              // 3) 사전순 오름차순
        });

        // 4. 출력
        StringBuilder sb = new StringBuilder();
        for (String word : words) {
            sb.append(word).append('\n');
        }

        System.out.print(sb.toString());
    }
}
