n = int(input())
arr = [int(input()) for _ in range(n)]

sorted(arr)
ans = 11111111

for i in range(n):
    cnt = 0
    for j in range(arr[i], arr[i] + 5):
        if j in arr:
            cnt += 1
    tmp = 5 - cnt # 추가해야할 놈들
    ans = min(ans, tmp)


print(ans)