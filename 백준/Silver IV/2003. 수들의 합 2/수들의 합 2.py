import sys
si = sys.stdin.readline


n, m = map(int, si().split())
arr = list(map(int, si().split()))
ans = 0 # 합이 m이 되는 경우의 수

sum = 0
s = 0
e = -1

while s < n:
    while sum < m and e + 1 < n:
        e += 1
        sum += arr[e]
    if sum == m:
        ans += 1
    sum -= arr[s]
    s += 1
print(ans)