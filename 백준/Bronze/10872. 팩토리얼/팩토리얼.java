import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Main {
	static int result;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		PrintWriter pw = new PrintWriter(System.out);
		
		String input = st.nextToken();
		int num = Integer.parseInt(input);
		int result = 0;
		
		result = factorial(num);
		pw.println(result);
		
		br.close();
		pw.close();
		
		
	}
	public static int factorial(int num) {
		if (num == 0) {
			return 1;
		}
		
		return factorial(num-1)*num;
	}
}