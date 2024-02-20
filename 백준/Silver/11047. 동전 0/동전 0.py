import sys
si = sys.stdin.readline


# n종류   합이 k원
n, k = map(int, si().split())
ans = 0

coins = []
for i in range(n):
    coin = si().strip()
    coin = int(coin)
    if coin <= k:
        coins.append(coin)

coins = sorted(coins, reverse=True)


# 나눌 수 있는 동전 리스트를 정렬 = [1000, 500, 100 ..  1]
for coin in coins:
    ans += k // coin
    k = k % coin

print(ans)