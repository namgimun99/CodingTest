import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Deque;
import java.util.LinkedList;

public class Main {
	public static void main(String[] args)throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pw = new PrintWriter(System.out);
		
		String input = br.readLine();
		
		String[] parts = input.split(" ");
		
		int dig = Integer.parseInt(parts[0]);
		int cnt = Integer.parseInt(parts[1]);
		int count = 0;
		
		String num = br.readLine();
		
		Deque<Integer> deque = new LinkedList<>();
		
		for(int i = 0; i<dig; i++) {
			
			// deque가 비었으면
			if(deque.isEmpty()) {
				deque.offerLast(num.charAt(i) + 0);
			} 
			// deque가 비어있지 않으면
			else {
				while(true) {
					if(deque.isEmpty()) {
						break;
					}
					
					if(deque.peekLast() < num.charAt(i) && count<cnt){
						deque.pollLast(); // 해당 값 삭제
						count++; // count 증가
					}
					
					else {
						break;
					}
					
				}

				deque.offerLast(num.charAt(i) + 0); // 우측 끝에 현재 값 집어넣기
					

			}
			
		}
		
		for(int j=count; j<cnt; j++) {
			deque.pollLast(); // 해당 값 삭제
		
		}
		
		for (int element : deque) {
            System.out.print(Character.getNumericValue(element) +0);
        }
		pw.close();
		br.close();
	}
	
}
