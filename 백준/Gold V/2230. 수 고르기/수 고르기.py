import sys
si = sys.stdin.readline


n, m = map(int, si().split())
arr = [int(input()) for _ in range(n)]

# 정수로 이루어진 수열에서
# 두 수를 골랐을 때 차이가 m이상이면서 제일 작은 경우 구하기

arr.sort()

s = 0
e = 1
ans = 2000000000
while s < n and e < n:
    if arr[e] - arr[s] < m:
        e += 1
    elif arr[e] - arr[s] == m:
        print(m)
        sys.exit()
    elif arr[e] - arr[s] > m:
        if ans > arr[e] - arr[s] and arr[e] - arr[s] >= m:
            ans = arr[e] - arr[s]
        s += 1


print(ans)