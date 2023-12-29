class Solution
{
    public int solution(int n, int a, int b)
    {
	int answer = 0;

	while(b != a) {
		a = ++a / 2;
		b = ++b / 2;
		answer++;
	}

	return answer;

    }
}