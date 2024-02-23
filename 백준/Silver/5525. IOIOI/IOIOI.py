import sys

si = sys.stdin.readline

n = int(si())
m = int(si())
s = si()



ans = 0
cnt = 0
i = 0
while i < (m- 1):
    if s[i:i+3]  == 'IOI': # 일단 될 수 있음
        i += 2
        cnt += 1 # 그 뒤에도 나올 수 있는지?
        if cnt == n:
            ans += 1
            cnt -= 1 # 앞에꺼 사라지니까 cnt -1
    else:
        i += 1
        cnt = 0 # 없어져서 리셋됨


print(ans)