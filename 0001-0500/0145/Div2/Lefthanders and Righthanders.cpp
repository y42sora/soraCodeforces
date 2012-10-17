#include <vector>
#include <list>
#include <map>
#include <set>
#include <deque>
#include <stack>
#include <bitset>
#include <algorithm>
#include <functional>
#include <numeric>
#include <utility>
#include <sstream>
#include <iostream>
#include <iomanip>
#include <cstdio>
#include <cmath>
#include <fstream>
using namespace std;

#define FOR(i,a,b) for(int i=(a);i<(b);++i)
#define REP(i,n)  FOR(i,0,n)
typedef vector<int> VI;
typedef vector<VI> VVI;
typedef vector<string> VS;
typedef pair<int, int> PII;
typedef pair<double, double> PDD;
typedef vector<bool> VB;
typedef vector<VB> VVB;
typedef vector<double> VD;
typedef long long LL;
const double EPS = 1e-10;
#define SORT(c) sort((c).begin(),(c).end())



int main(void){
	ifstream cin("input.txt");
	ofstream cout("output.txt");

	int n;
	string s;
	cin >> n;
	cin >> s;

	REP(i,n/2)
		if(s[i] == 'L')
			cout << i+1 << " " << n/2+i+1 << endl;
		else
			cout << n/2+i+1 << " " << i+1 << endl;

    return 0;
}