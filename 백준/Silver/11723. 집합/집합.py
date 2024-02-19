import sys
si = sys.stdin.readline

result = [False] * 21
tc = int(si())

for i in range(tc):
    data = si().split()

    menu = data[0]
    if menu != "all" and menu != "empty":
        num = int(data[1])


    if menu == "add":
        result[num] = True
    elif menu == "remove":
        result[num] = False
    elif menu == "check":
        if result[num] == 1:
            print(1)
        else:
            print(0)
    elif menu == "toggle":
        result[num] = not result[num]
    elif menu == "all":
        for i in range(1,21):
            result[i] = True
    elif menu == "empty":
        for i in range(1,21):
            result[i] = False