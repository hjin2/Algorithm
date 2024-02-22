import sys
si = sys.stdin.readline

n, m = map(int, si().split())

dict = {}
for i in range(n):
    address, password = map(str, si().split())
    dict[address] = password


for j in range(m):
    search = si().strip()
    print(dict[search])
