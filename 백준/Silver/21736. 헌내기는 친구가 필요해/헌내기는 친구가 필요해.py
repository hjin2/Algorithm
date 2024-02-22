import sys
from collections import deque
si = sys.stdin.readline

n, m = map(int, si().split())

board = [list(map(str,si().strip())) for i in range(n)]
dx = [-1, 1, 0, 0]
dy = [0,0,-1,1]

me = []
for i in range(n):
    for j in range(m):
        if board[i][j] == 'I':
            me.append(i)
            me.append(j)

visited = [[False] * m for i in range(n)]
ans = 0
def bfs(graph, start, visited):
    global ans
    queue = deque([start])
    visited[start[0]][start[1]] = True

    while queue:
        v = queue.popleft()
        visited[v[0]][v[1]] = True

        if graph[v[0]][v[1]] == 'P':
            ans += 1
        for i in range(4):
            if v[0] + dx[i] < 0 or v[0] + dx[i] >= n or v[1] + dy[i] < 0 or v[1] + dy[i] >= m:
                continue
            if visited[v[0] + dx[i]][v[1] + dy[i]] == True:
                continue
            if graph[v[0] + dx[i]][v[1] + dy[i]] == 'X':
                continue
            if graph[v[0] + dx[i]][v[1] + dy[i]] == 'O' or graph[v[0] + dx[i]][v[1] + dy[i]] == 'P':
                queue.append([v[0] + dx[i], v[1] + dy[i]])
                visited[v[0] + dx[i]][v[1] + dy[i]] = True


bfs(board, me, visited)
if ans == 0:
    print("TT")
else:
    print(ans)