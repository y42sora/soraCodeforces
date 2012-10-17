import java.util.Scanner;


public class ProblemA {
	
	public static void main(String args[]){
		ProblemA m = new ProblemA();
		m.start();
	}

	private void start() {
		Scanner sc = new Scanner(System.in);
		
		String str = sc.next();
		
		char before = str.charAt(0);
		int count = 1;
		
		for(int i=1; i<str.length(); i++){
			char c = str.charAt(i);
			
			if(c == before){
				count++;
				if(count == 7)	break;
			}else{
				before = c;
				count = 1;
			}
		}

		if(count == 7)
			System.out.print("YES");
		else
			System.out.print("NO");
		
	}

	
}
