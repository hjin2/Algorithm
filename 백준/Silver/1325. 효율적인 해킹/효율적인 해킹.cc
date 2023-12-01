#include<iostream>
#include<queue>
#include<algorithm>
#include<string.h>
using namespace std;

vector<vector<int>>v;

queue<int>q;
int result[10'001];
bool visited[10'001];

int main()
{
	cin.tie(0); cout.tie(0);
	ios::sync_with_stdio(0);

	// N는 컴퓨터의 개수, M은 신뢰하는 연결의 개수
	int N, M = 0;
	cin >> N >> M;

	v.resize(N + 1);

	for (int i = 0;i < M;i++)
	{
		// A가 B를 신뢰한다.
		int A, B = 0;
		cin >> A >> B;
		v[A].push_back(B);
	}

	for (int i = 1;i <= N;i++)
	{
		memset(visited, false, sizeof(bool) * (N + 1));
		q.push(i);
		visited[i] = true;
		while (!q.empty())
		{
			int cur = q.front(); q.pop();
			for (int nxt : v[cur])
			{
				if (!visited[nxt])
				{
					result[nxt]++;
					q.push(nxt);
					visited[nxt] = true;
				}
			}
		}
	}

	int comp_value = -1;
	for (int i = 1;i <= N;i++)
	{
		if (result[i] > comp_value)
		{
			comp_value = result[i];
		}
	}

	for (int i = 0;i <= N;i++)
	{
		if (result[i] == comp_value)
		{
			cout << i << ' ';
		}
	}

	return 0;
}