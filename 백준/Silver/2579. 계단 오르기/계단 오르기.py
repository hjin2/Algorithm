import sys

si = sys.stdin.readline
# 계단 수
n = int(si())

# 계단 점수
# 인덱스 1부터 시작하기 위해 0추가


dp = [0] * (n + 1)

scores = [0] * (n + 1)
for i in range(1, n + 1):
    scores[i] = int(si())




# 정답이 될 최댓값
ans =-1

# 첫번째 계단에 올라가는 건 한가지 경우
dp[1] = scores[1]
# 두번째 계단에 올라가는 최대값이 되는 경우는 1번째 칸에서 올라오는 것
if n >= 2:
    dp[2] = scores[1] + scores[2]
    # 세번째 계단은 1,2,3이렇게 연속 3번 안됨
    # 1 -> 3으로 혹은 2 -> 3으로 두 가지 경우
    # dp[3] = max(dp[1] + scores[3], scores[2] + scores[3])
    # 여기서 dp[2]가 아닌 이유는 0 -> 2 -> 3 이렇게 오를 수밖에 없기 때문에
if n>=3:
    dp[3] = max(dp[1], scores[2]) + scores[3]


# 네번째 계단은 3 -> 4 혹은 2 -> 4
# 다섯번째 계단은 4 -> 5 혹은 3 -> 5
# 즉 n번째 계단은 한 칸 전에서 올라오거나 두 칸 전에서 올라온다
for i in range(4, n + 1):
    dp[i] = max(dp[i - 3] + scores[i - 1], dp[i - 2]) + scores[i]

print(dp[n])