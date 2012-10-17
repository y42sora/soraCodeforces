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
	int k;
	
	cin >> n;
	cin >> k;

	vector<PII> light;
	REP(i,n){
		int l;
		cin >> l;
		light.push_back(make_pair(l, i+1));
	}

	std::sort(light.begin(), light.end(), std::greater<std::pair<int, int> >());

	int minl = light[0].first;
	VI ans;
	REP(i,k){
		ans.push_back(light[i].second);
		minl = min(minl, light[i].first);
	}
	SORT(ans);

	cout << minl << endl;

	REP(i,k-1)
		cout << ans[i] << " ";

	cout << ans[k-1] << endl;

    return 0;
}