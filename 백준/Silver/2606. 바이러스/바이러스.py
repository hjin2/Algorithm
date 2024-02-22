from collections import deque
import sys

si = sys.stdin.readline

computer = int(si())
n = int(si())

graph = [[] for _ in range(computer+1)]
for i in range(n):
    start, end = map(int, si().split())
    graph[start].append(end)
    graph[end].append(start)

visited = [False] * (computer + 1)

ans = 0
def bfs(graph, start, visited):
    global ans
    queue = deque([start])
    visited[start] = True

    while queue:
        v = queue.popleft()
        for i in graph[v]:
            if not visited[i]:
                queue.append(i)
                visited[i] = True
                ans += 1

bfs(graph, 1, visited)
print(ans)