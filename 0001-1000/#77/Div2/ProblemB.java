import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class ProblemB {
	public static void main(String args[]){
		ProblemB m = new ProblemB();
		m.start();
	}

	private void start() {
		Scanner sc = new Scanner(System.in);
		
		String str = sc.next();
		
		Long n = Long.valueOf(str);
	
		String out = getAns(n);
		System.out.println(out);
	}

	private String getAns(Long n) {
		Queue<String> q = new LinkedList<String>();
		
		q.add("4");
		q.add("7");
		
		while(!q.isEmpty()){
			String str = q.poll();
			
			Long x = Long.valueOf(str);
			if(n <= x)
				if(isLucky(x))
					return str;
			
			q.add(str + "4");
			q.add(str + "7");
		}

		return null;
	}
	
	private boolean isLucky(Long n) {
		String str = n.toString();
		
		int s = 0;
		int f = 0;
		
		for(int i=0; i<str.length(); i++){
			char c = str.charAt(i);
			
			if(c == '4')
				f++;
			else if(c == '7')
				s++;
		}

		if(f == s)
			if(f+s == str.length())
				return true;
		return false;
	}
}