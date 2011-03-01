import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
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
		
		ArrayList<String> ar;
		
		ar = new ArrayList<String>();
		for(int i=0; i<n; i++)
			if(s[i][1].equals("rat"))
				ar.add(s[i][0]);
		//Collections.sort(ar);
		for(int i=0; i<ar.size(); i++){
			System.out.println(ar.get(i));
		}
		
		ar = new ArrayList<String>();
		for(int i=0; i<n; i++)
			if(s[i][1].equals("woman") || s[i][1].equals("child"))
				ar.add(s[i][0]);
		//Collections.sort(ar);
		for(int i=0; i<ar.size(); i++){
			System.out.println(ar.get(i));
		}
		
		ar = new ArrayList<String>();
		for(int i=0; i<n; i++){
			if(s[i][1].equals("man"))
				ar.add(s[i][0]);
		}
		//Collections.sort(ar);
		for(int i=0; i<ar.size(); i++){
			System.out.println(ar.get(i));
		}
		
		ar = new ArrayList<String>();
		for(int i=0; i<n; i++){
			if(s[i][1].equals("captain"))
				ar.add(s[i][0]);
		}
		//Collections.sort(ar);
		for(int i=0; i<ar.size(); i++){
			System.out.println(ar.get(i));
		}
	}
}
