import sys

si = sys.stdin.readline

tc = int(si())


for i in range(tc):
    my_dict = {}
    input = int(si())
    for _ in range(input):
        name, type = map(str, si().split())
        if type not in my_dict:
            my_dict[type] = [name]
        else:
            my_dict[type].append(name)
    ans = 1
    for i in my_dict:
        ans *= (len(my_dict[i]) + 1)

    print(ans - 1)