# 두 수를 선택한다
# e : 현재 > s : 기억
# e제곱 - s제곱을 했을 때 G이면 e 추가하고 어떻게? s+=1 e+=1까지 해줘야함
#                     < G이면 e를 더 큰 수로
#                     > G이면 s를 더 큰 수로
# 근데 언제까지 할것인가?

# 99 100 : 9801 10000
# 연속하는 두 수 제곱의 차 > G이면 종료


g = int(input())
s = 1
e = 2
ans = []
while True:
    if pow(s+1,2) - pow(s,2) > g:
        break
    elif pow(e,2) - pow(s,2) == g:
        ans.append(e)
        s += 1
        e += 1
    elif pow(e,2) - pow(s,2) < g:
        e += 1
    elif pow(e,2) - pow(s,2) > g:
        s += 1

if len(ans) == 0:
    print(-1)
else:
    for number in ans: print(number)