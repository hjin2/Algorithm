import sys

si = sys.stdin.readline

tc = int(si())


def recur(num, sum):
    global ans
    if sum > num:
        return
    elif sum == num:
        ans += 1

    recur(num, sum + 1)

    recur(num, sum + 2)

    recur(num, sum + 3)



for i in range(tc):
    num = int(si())
    ans = 0
    recur(num,  0)
    print(ans)