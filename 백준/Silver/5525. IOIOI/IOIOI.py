import sys

input = sys.stdin.readline
N = int(input())
M = int(input())
S = input().rstrip()
p = 'I' + 'OI' * N

count = 0
for start in [i for i in range(M - len(p) + 1) if S[i] == 'I']:
    end = start + len(p)
    if S[start:end] == p:
        count += 1
print(count)