import java.util.Scanner;

public class ProblemA {
	public static void main(String[] args) {
		ProblemA m = new ProblemA();
		m.start();
	}

	private void start() {
		Scanner sc = new Scanner(System.in);

		String str1 = sc.next();
		String str2 = sc.next();

		String str = "";
		for(int i=0; i<str1.length(); i++){
			if(str1.charAt(i) != str2.charAt(i))
				str = str + "1";
			else
				str = str + "0";
		}

		System.out.println(str);
	}

}
