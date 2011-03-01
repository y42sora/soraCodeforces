import java.text.DecimalFormat;
import java.util.Scanner;

public class ProblemC {
	public static void main(String[] args) {
		ProblemC m = new ProblemC();
		m.start();
	}

	private void start() {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		int dig[][] = new int[n][3];
		for(int i=0; i<n; i++){
			dig[i][0] = sc.nextInt();
			dig[i][1] = sc.nextInt();
			dig[i][2] = sc.nextInt();
		}
		
		boolean flag[] = new boolean[10000];
		int num = 0;
		int now = -1;
		
		for(int i=0; i<flag.length; i++){
			if(isOk(i)){
				flag[i] = check(dig,i);
			}
			if(flag[i]){
				num++;
				now = i;
			}
		}

		DecimalFormat f = new DecimalFormat("0000");
		if(num == 0)
			System.out.println("Incorrect data");
		if(num > 1)
			System.out.println("Need more data");
		if(num == 1)
			System.out.println(f.format(now));
	}

	private boolean isOk(int i) {
		int a = i % 10;
		i /= 10;
		
		int b = i % 10;
		i /= 10;
		
		int c = i % 10;
		i /= 10;
		
		int d = i % 10;
		
		if(a != b && a != c && a != d)
			if(b != c && b != d)
				if(c != d)
					return true;
		return false;
	}

	private boolean check(int[][] dig, int num) {
		for(int i=0; i<dig.length; i++){
			int bull = getBull(dig[i][0], num); 
			int cow = getCow(dig[i][0], num);
			
			if(dig[i][1] != bull || dig[i][2] != cow) return false;
		}
		return true;
	}

	private int getCow(int i, int num) {
		int n = 0;
		
		int a = i % 10;
		i /= 10;
		int b = i % 10;
		i /= 10;
		int c = i % 10;
		i /= 10;
		int d = i % 10;
		
		int a2 = num % 10;
		num /= 10;
		int b2 = num % 10;
		num /= 10;
		int c2 = num % 10;
		num /= 10;
		int d2 = num % 10;
		
		if(a == b2 || a == c2 || a == d2)n++;
		if(b == a2 || b == c2 || b == d2)n++;
		if(c == a2 || c == b2 || c == d2)n++;
		if(d == a2 || d == b2 || d == c2)n++;

		return n;
	}
	private int getBull(int i, int num) {
		int n = 0;
		if(i%10 == num % 10)n++;
		i = i / 10;
		num = num / 10;
		
		if(i%10 == num % 10)n++;
		i = i / 10;
		num = num / 10;
		
		if(i%10 == num % 10)n++;
		i = i / 10;
		num = num / 10;
		
		if(i%10 == num % 10)n++;
		i = i / 10;
		num = num / 10;
		
		return n;
	}
}
