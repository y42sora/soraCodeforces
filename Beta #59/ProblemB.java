import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class ProblemB {
	public static void main(String[] args) {
		ProblemB m = new ProblemB();
		m.start();
	}

	private void start() {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		
		int solder[] = new int[k+1];
		
		for(int i=0; i<n; i++)
			solder[sc.nextInt()]++;
		
		int num = 0;
		while(solder[k] != n){
			num++;
			for(int i=k; 0<i; i--){
				if(solder[i-1] != 0){
					solder[i-1]--;
					solder[i]++;
				}
			}
		}

		System.out.println(num);
	}
}
