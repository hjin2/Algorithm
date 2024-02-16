n= int(input())


s, e = 1,1
sum = 1
cnt = 0
while e != n:
    if sum < n:
        e += 1
        sum += e
    elif sum > n:
        sum -= s
        s += 1
    else:
        cnt += 1
        e += 1
        sum += e


print(cnt +1)