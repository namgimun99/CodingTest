import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Stack;

public class Main {
	public static void main(String[] args) throws IOException{
		
		BufferedReader  br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pw = new PrintWriter(System.out);
		Stack<Integer> stack = new Stack<>();
		
		int num = Integer.parseInt(br.readLine());
		
		for(int i = 0; i<num;i++) {
			String str = br.readLine();
			
			if(str.contains(" ")) {
				String[] parts = str.split(" ");
				
				stack.push(Integer.parseInt(parts[1]));
				
			}
			
			 if(str.equals("pop")) {
				if(stack.empty()) {
						pw.println(-1);
				} 
				else {
					 pw.println(stack.pop());
				}
				
			} 
			
			else if(str.equals("size")) {
				pw.println(stack.size());
			} 
			
			else if(str.equals("empty")) {
				if(stack.empty()) {
					pw.println(1);
				} 
				
				else {
					pw.println(0);
				}
			}
			
			else if(str.equals("top")) {
				
				if(stack.empty()) {
					pw.println(-1);
				} 
				else {
					pw.println(stack.peek());
				}
			} 
			
		}
		
		pw.close();
		br.close();
	}

}
