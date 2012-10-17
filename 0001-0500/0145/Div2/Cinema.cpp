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

int get_other_max(int x, VI nums){
	int ans = -1;

	REP(i,nums.size())
		if(i != x)
			ans = max(ans, nums[i]);
	return ans;
}

int main(void){
	ifstream cin("input.txt");
	ofstream cout("output.txt");

	int m;
	int k;
	cin >> m >> k;

	map<int, bool> fav;
	REP(i,k){
		int a;
		cin >> a;
		fav[a] = true;
	}

	VI maxs;
	VI mins;

	int n;
	cin >> n;
	REP(i,n){
		string s;
		cin >> s;

		int zeros = 0;
		int favs = 0;

		int d;
		cin >> d;
		REP(i,d){
			int temp;
			cin >> temp;

			if(temp == 0)
				zeros++;
			if(fav.find(temp) != fav.end())
				favs++;
		}

		maxs.push_back(min(k, favs+zeros));
		mins.push_back(max(favs, k-m+d));
	}

	REP(i,n)
		if(get_other_max(i,maxs) <= mins[i])
			cout << 0 << endl;
		else if(maxs[i] < get_other_max(i,mins))
			cout << 1 << endl;
		else
			cout << 2 << endl;

    return 0;
}