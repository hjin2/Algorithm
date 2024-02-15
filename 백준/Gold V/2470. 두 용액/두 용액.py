import sys
si = sys.stdin.readline
import math


n = int(input())
arr = list(map(int, si().split()))

arr.sort()
s = 0
e = n - 1
ans = 1 << 31
x , y = -1, -1


while s < e:
    if ans > abs(arr[s] + arr[e]):
        ans = abs(arr[s] + arr[e])
        x = arr[s]
        y = arr[e]
        
    if arr[s] + arr[e] <= 0:
        s += 1
    elif arr[s] + arr[e] > 0:
        e -= 1

if x < y:
    print(x,y)
else:
    print(y,x)