import java.util.Scanner;

public class ProblemA {
	public static void main(String[] args) {
		ProblemA m = new ProblemA();
		m.start();
	}

	private void start() {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		String s[][] = new String[n][2];
		
		for(int i=0; i<n; i++){
			s[i][0] = sc.next();
			s[i][1] = sc.next();
		}
		
		for(int i=0; i<n; i++)
			if(s[i][1].equals("rat"))
				System.out.println(s[i][0]);
		
		for(int i=0; i<n; i++)
			if(s[i][1].equals("woman") || s[i][1].equals("child"))
				System.out.println(s[i][0]);
		
		for(int i=0; i<n; i++)
			if(s[i][1].equals("man"))
				System.out.println(s[i][0]);
		
		for(int i=0; i<n; i++)
			if(s[i][1].equals("captain"))
				System.out.println(s[i][0]);
	}
}
