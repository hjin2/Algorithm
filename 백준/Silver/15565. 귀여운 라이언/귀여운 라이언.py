import sys
si = sys.stdin.readline

n, k = map(int, si().split())
arr = list(map(int, si().split()))

s, e = 0, -1
cnt = 0 # 범위 안에 있는 라이언 개수
ans = n + 1 # 답
size = 0 # 부분집합의 길이

while s < n and e < n: # 더 이상 start랑 end가 갈 곳이 없을때 종료
    if cnt < k:
        e += 1
        if e < n and arr[e] == 1:
            cnt += 1
    else:
        if cnt == k:
            ans = min(ans, e - s + 1)
        if arr[s] == 1:
            cnt -= 1
        s += 1

if ans == n + 1:
    print(-1)
else:
    print(ans)