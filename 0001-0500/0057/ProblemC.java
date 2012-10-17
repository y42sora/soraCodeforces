import java.util.Scanner;

public class ProblemC {
	public static void main(String[] args) {
		ProblemC m = new ProblemC();
		m.start();
	}

	private void start() {
		Scanner sc = new Scanner(System.in);

		String s[] = new String[2];
		s[0] = sc.next();
		s[1] = sc.next();

		int base = 0;
		if(s[0].charAt(0) == 'R')
			base = -1;
		else
			base = Integer.parseInt(s[0]);

		int next = 0;
		if(s[1].charAt(0) == 'R')
			next = -1;
		else
			next = Integer.parseInt(s[1]);

		String input = sc.next();

		slove(base,next,input);
	}

	private void slove(int base, int next, String input) {

		long num = 0;
		if(base != -1)
			num = getInt(base,input);
		else
			num = arabic(input);

		String ans = "";
		if(next != -1)
			ans = getStr(next,num);
		else
			ans = roman(num);

		System.out.println(ans);
	}

	private String getStr(int next, long num) {
		String str = "";

		while(num != 0){
			long n = num % next;

			if(n < 10)
				str = String.valueOf(n) + str;
			else
				str = String.valueOf((char)(n - 10 + 'A')) + str;

			num = num / next;
		}
		if(str == "") return "0";

		return str;
	}

	private long getInt(int base, String input) {
		long num = 0;
		long cal = 1;

		for(int i=input.length()-1; 0 <= i; i--){
			char c = input.charAt(i);
			if(base <= 10)
				num += (c - '0') * cal;
			else
				if('0' <= c && c <= '9')
					num += (c - '0') * cal;
				else
					num += (c - 'A' + 10) * cal;
			cal = cal * base;
		}
		return num;
	}


	class elem{
		char c;
		int v;

		public elem(char c, int v){
			this.c = c;
			this.v = v;
		}

		public char getChar(){
			return c;
		}

		public int getVal(){
			return v;
		}
	};

	elem tbl[]={
		new elem( 'm', 1000 ),
		new elem( 'd',  500 ),
		new elem( 'c',  100 ),
		new elem( 'l',   50 ),
		new elem( 'x',   10 ),
		new elem( 'v',    5 ),
		new elem( 'i',    1 ),
	};

	boolean chkv( char c ){
		for(int i = 0 ; i < tbl.length ; i++ ){
			if( tbl[i].getChar() == c ){
				return true;
			}
		}
		return false;
	}

	int getv( char c ){
		for(int i = 0 ; i < tbl.length ; i++ ){
			if( c == tbl[i].getChar() ){
				return tbl[i].getVal();
			}
		}
		return -1;
	}

	String roman(long num){
		int n =  (int) num;

		String[][] tbl = {
				{ "", "i", "ii", "iii", "iv", "v", "vi", "vii", "viii", "ix", },
				{ "", "x", "xx", "xxx", "xl", "l", "lx", "lxx", "lxxx", "xc", },
				{ "", "c", "cc", "ccc", "cd", "d", "dc", "dcc", "dccc", "cm", },
				{ "", "m", "mm", "mmm", "mmmm", "", "", "", "", "", },
		};
		String ans = "";

		int x;
		x = n % 10;
		ans = tbl[0][x] + ans;
		n = n / 10;

		x = n % 10;
		ans = tbl[1][x] + ans;
		n = n / 10;

		x = n % 10;
		ans = tbl[2][x] + ans;
		n = n / 10;

		x = n % 10;
		ans = tbl[3][x] + ans;
		n = n / 10;

		ans = ans.toUpperCase();
		return ans;
	}

	int arabic( String buf ){
		int prev = 0;
		int current = 0;
		int i;
		int val = 0;
		int cnt = 0;

		buf.trim();
		buf = buf.toLowerCase();

		for( i = 0 ; i < buf.length() ; i ++ ){
			if( chkv( buf.charAt( i ) ) == true ){
				current = getv( buf.charAt( i ) );
				if( prev == current)
					cnt++;
				else
					cnt = 0;

				if( current > prev && prev != 0 ){
					val -= prev * 2;
					val += current;
					prev = current - prev;
				}else{
					val += current;
					prev = current;
				}
			}
		}
		return val;
	}

}