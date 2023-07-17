import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

public class Main {
	public static void main(String[] args) throws IOException{
		
		BufferedReader  br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pw = new PrintWriter(System.out);
		
		Deque<Integer> deque = new LinkedList<>();
		
		int num = Integer.parseInt(br.readLine());
		
		for(int i = 0; i<num;i++) {
			String str = br.readLine();
			
			if(str.contains(" ")) {
				String[] parts = str.split(" ");
				
				if(parts[0].equals("push_front")) {
					deque.offerLast(Integer.parseInt(parts[1]));
				} 
				
				else {
					deque.offerFirst(Integer.parseInt(parts[1]));
				}
				
				
				
				
			}
			
			 if(str.equals("pop_front")) {
				if(deque.isEmpty()) {
						pw.println(-1);
				} 
				else {
					 pw.println(deque.pollLast());
				}
				
			} 
			 
			 else if(str.equals("pop_back")) {
				if(deque.isEmpty()) {
						pw.println(-1);
				} 
				else {
					 pw.println(deque.pollFirst());
				}
				
			 } 
			
			 else if(str.equals("size")) {
				 pw.println(deque.size());
			 } 
			
			 else if(str.equals("empty")) {
			 	if(deque.isEmpty()) {
					pw.println(1);
				} 
				
				else {
					pw.println(0);
				}
			 }
			
			 else if(str.equals("front")) {
				
				if(deque.isEmpty()) {
					pw.println(-1);
				} 
				else {
					pw.println(deque.peekLast());
				}
			 } 
			 
			 else if(str.equals("back")) {
				
				if(deque.isEmpty()) {
					pw.println(-1);
				} 
				else {
					pw.println(deque.peekFirst());
				}
			 }
			
		}
		
		pw.close();
		br.close();
	}

}
