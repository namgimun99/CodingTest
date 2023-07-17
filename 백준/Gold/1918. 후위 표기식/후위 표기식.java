
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Deque;
import java.util.LinkedList;

public class Main {
	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pw = new PrintWriter(System.out);
		
		String str = br.readLine();
		
		Deque<Character> operator = new LinkedList<>();
		
		for(int i = 0; i<str.length(); i++) {
			if(str.charAt(i) >= 40 && str.charAt(i) <= 47) {// 연산자가 들어왔을 때
				
				if(!operator.isEmpty()) { //덱이 비어있지 않다면
					
					
					if(str.charAt(i) == '(') {
						operator.offerLast(str.charAt(i));
					}
					
					else {
						while(!operator.isEmpty()) { // 덱이 빌때까지 반복


							if(str.charAt(i) == ')') {
								while(operator.peekLast() != '(') {
									pw.print(operator.pollLast());
								}
								operator.pollLast();
								break;
							}
							
							else if(operator.peekLast() == '*' || operator.peekLast() == '/') { // 마지막이 *,/ 중 하나이고
								if(str.charAt(i) == '+' || str.charAt(i) == '/' || str.charAt(i) == '*' || str.charAt(i) == '-') { 
									// 들어오는게 +, -, *, /, ) 중 하나면
									
									pw.print(operator.pollLast()); // 저장되어있던 마지막 기호 추출 (우선순위 높음)
								} 
							} 
							
							else if(operator.peekLast() == '+' || operator.peekLast() == '-') {// 마지막이 +, - 중 하나이고
								if(str.charAt(i) == '+' || str.charAt(i) == '-') { // 들어오는 기호가 +, - 중 하나이면
									pw.print(operator.pollLast()); // 저장되어있던 마지막 기호 추출 (우선순위 높음)
								} 
								else if(str.charAt(i) == '*' || str.charAt(i) == '/') { // 들어오는 기호가 *, / 중 하나이면
									break;
								}
							}
							
							else if(operator.peekLast() == '(') {
								break;
							}
							
							
						}
						
						if(str.charAt(i) != ')') {
							operator.offerLast(str.charAt(i));
						}
					} 
				}
				else { // 덱이 비었다면
					if(str.charAt(i) != ')') {
						operator.offerLast(str.charAt(i));
					}
				}
			}
			
			// 피연산자가 들어오면 그냥 출력시킨다.
			else if(str.charAt(i) >= 65 && str.charAt(i) <= 90) {
				pw.print(str.charAt(i));
			}
			
			else {
				continue;
			}
		}
		
		while(!operator.isEmpty()) { // 덱이 빌때까지 반복
			pw.print(operator.pollLast());
		}
		
		pw.close();
		br.close();
		
		
	}

}
