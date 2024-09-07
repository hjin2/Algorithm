import sys
N = int(sys.stdin.readline())
K = int(sys.stdin.readline())
start = 1
end = K

while start <= end:
    mid = (start + end) // 2
    cnt = 0
    # ex) N*N에서 20보다 작거나 같은 수는
    # 1행 기준 1~ 20 -> 20//1 개
    # 2행 기준 2,4,6,8... -> 20//2 개
    # 3행 기준 3,6,9,12... -> 20//3 개
    # 4행 기준 4,8,12,16,20... -> 20//4개
    # N행 기준 N,N*2,N*3... -> 20//N개!
    # 이중 찾는값//i가 N보다 큰 경우가 존재하므로 최대 N까지만 갖게 설정
    for i in range(1, N+1):
        cnt += min(mid//i, N)
    if cnt >= K:
        result = mid
        end = mid - 1
    else:
        start = mid + 1
print(result)