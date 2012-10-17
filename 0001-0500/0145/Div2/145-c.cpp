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
	cin >> n;

	int zeros = 0;

	VI nums;
	REP(i,n){
		int l;
		cin >> l;
		
		if(l == 0)
			zeros++;
		
		nums.push_back(l);
	}

	VI downcount;
	downcount.push_back(0);
	FOR(i,1,n)
		if(0 < nums[i-1])
			downcount.push_back(downcount[i-1]+1);
		else
			downcount.push_back(downcount[i-1]);

	VI upcount;
	REP(i,nums.size())
		upcount.push_back(0);

	for(int i=nums.size()-2; 0 <= i; i--)
		if(nums[i+1] < 0)
			upcount[i] = upcount[i+1] + 1;
		else
			upcount[i] = upcount[i+1];

	VI count;
	FOR(i,1,nums.size())
		count.push_back(downcount[i] + upcount[i-1]);

	SORT(count);
	cout << count[0] + zeros << endl;

    return 0;
}