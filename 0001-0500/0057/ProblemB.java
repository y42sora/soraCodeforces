import java.util.Scanner;

public class ProblemB {
	public static void main(String[] args) {
		ProblemB m = new ProblemB();
		m.start();
	}

	private void start() {
		Scanner sc = new Scanner(System.in);

		String str1 = sc.next();
		String str2 = sc.next();
		String str3 = sc.next();

		str1 = str1.toLowerCase();
		str1 = str1.replaceAll(";", "");
		str1 = str1.replaceAll("_", "");
		str1 = str1.replaceAll("-", "");

		str3 = str3.toLowerCase();
		str3 = str3.replaceAll(";", "");
		str3 = str3.replaceAll("_", "");
		str3 = str3.replaceAll("-", "");


		str2 = str2.toLowerCase();
		str2 = str2.replaceAll(";", "");
		str2 = str2.replaceAll("_", "");
		str2 = str2.replaceAll("-", "");

		int x = 0;
		String s[] = new String[6];
		s[x++] = str1 + str2 + str3;
		s[x++] = str1 + str3 + str2;
		s[x++] = str2 + str1 + str3;
		s[x++] = str2 + str3 + str1;
		s[x++] = str3 + str1 + str2;
		s[x++] = str3 + str2 + str1;

		int n = sc.nextInt();
		for(int i=0; i<n; i++){
			String str = sc.next();
			str = str.toLowerCase();
			str = str.replaceAll(";", "");
			str = str.replaceAll("_", "");
			str = str.replaceAll("-", "");

			boolean flag = false;
			for(int j=0; j<6; j++)
				if(s[j].equals(str))
					flag = true;

			if(flag)
				System.out.println("ACC");
			else
				System.out.println("WA");
		}
	}
}
