import sys
si = sys.stdin.readline

n, s = map(int,si().split())
arr = list(map(int, si().split()))

start, end, sum, ans = 0,-1,0,n+1

while start < n:
    while end + 1 < n and sum < s:
        end += 1
        sum += arr[end]
    if sum >= s:
        ans = min(ans, (end - start + 1))
    sum -= arr[start]
    start += 1

if ans == n+1:
    print(0)
else:
    print(ans)