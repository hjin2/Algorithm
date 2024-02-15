import sys
si = sys.stdin.readline


n = int(input())
list = list(map(int, si().split()))

s = 0
e = n - 1
ans = 2222222222
x , y = -1, -1
while s < e:
    if abs(list[s] + list[e]) < ans:
        ans = abs(list[s] + list[e])
        x, y = list[s], list[e]

    if list[s] + list[e] >= 0:
        e -= 1
    else:
        s += 1


print(x, y)