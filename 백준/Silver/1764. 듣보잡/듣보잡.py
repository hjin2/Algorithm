# 어딘가에 볼 수 없는 애들 저장해놓고
# 볼 수 없는 애들에 이미 있으면 정답 리스트에 저장
# 없으면 그냥 넘어가기
# 나중에 리스트 정렬해서 출력

# set

import sys

si = sys.stdin.readline

n, m = map(int, si().split())
set = set()
ans = []

for _ in range(n):
    word = si().strip()
    set.add(word)

for _ in range(m):
    word = si().strip()
    if word in set:
        ans.append(word)
    else:
        continue

ans = sorted(ans)
print(len(ans))
for i in ans:
    print(i)