import java.util.Scanner;

public class Main {
	static int n;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		
		// S[0]일 때, 문자열의 총 길이 
		int num = 3;
		// S[k-1]의 마지막 index
		int preK = 3;
		// index
		int k = 0;
		
		//  n의 범위를 구해주기
		while(num<n) {
			k++;
			num = 2 * preK + (1+2+k);
			preK = num; 
		}
		// 재귀함수에 S(k-1)값으로 넣어주기 위해 preK 을 다시 구함
		preK = (num-(1+2+k))/2;
		
		
		char c=' ';
		
		// 입력된 숫자가 3 이하일 경우
		if(k==0) {
			if(n==1) {
				c = 'm';
			}
			else {
				c = 'o';
			}
		}
		// 3보다 클 경우
		else {
			//새로운 인덱스의 중간 배열에 포함된다면
			if(preK+1<=n && n<preK+(1+2+k)) {
				//중간배열의 첫글자면 m
				if(preK+1==n) {
					c =  'm';
				}
				//첫글자가 아니면 o
				else {
					c = 'o';
				}
			}
			//중간배열이 아닌 앞, 뒤에 붙은 이전 배열이라면
			else {
				c = moo(preK+1+(1+2+k),k-1,num);
			}
		}	
		System.out.println(c);
	}
			// 시작 index, k 값, 끝 index
	private static char moo(int start, int k, int end) {
		
		// 중간 moo의 크기 구하기
		int index = ((end-start+1 -(k + 3))/2);
		
		// 기저조건
		if(k==0) {
			if(n==start) return 'm';
			else return 'o';
		}else {
			
			//왼쪽인 경우
			if(start<=n && n<start+index) {
				if(start==n) return 'm';
				return moo(start, k-1, start+index-1);
			}
			//오른쪽인 경우
			else if(start+index+(k + 3)<=n && n<=end) {
				if(start+index+(k + 3)==n) return 'm';
				else return moo(start+index+(k + 3), k-1, end);
			}
			//가운데
			else{
				if(start+index==n) return 'm';
				else return 'o';
			}
		}
	}
}
