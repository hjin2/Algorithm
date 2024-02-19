import sys
si = sys.stdin.readline

n, tc = map(int, si().split())


dict = {}

for i in range(1, n + 1):
    name = si().strip()
    dict[name] = i

key_list = list(dict.keys())

for i in range(tc):
    find = si().strip()
    if find.isdigit():
        find = int(find)
        print(key_list[find -1])
    else:
        print(dict[find])