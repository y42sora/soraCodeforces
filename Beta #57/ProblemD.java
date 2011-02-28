import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;

public class ProblemD {
	public static void main(String[] args) {
		ProblemD m = new ProblemD();
		m.start();
	}

	private void start() {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		long sum = 0;
		
		ArrayList<Edge>[] path = new ArrayList[n+1];
		for(int i=0; i<n+1; i++){
			path[i] = new ArrayList<Edge>();
		}
		for(int i=0; i<n-1; i++){
			int s = sc.nextInt();
			int e= sc.nextInt();
			int len= sc.nextInt();
			
			path[s].add(new Edge(e,len));
			path[e].add(new Edge(s,len));
			
			sum += len;
		}
		
		long length = getLength(path,1,0,0);
		System.out.println(sum*2  - length);
	}
	
	class Edge{
		int end;
		int len;
		Edge(int end,int len){
			this.end = end;
			this.len = len;
		}
	}

	private long getLength(ArrayList<Edge>[] path,int now,int before, long nowLength) {
		long next = 0;
		
		for(int i=0; i<path[now].size();i++){
			Edge e = path[now].get(i);
			if(e.end != before){
				next = Math.max(next, getLength(path,e.end,now,nowLength+e.len));
			}
		}
		return Math.max(next, nowLength);
	}
}
