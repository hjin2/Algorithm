import sys

si = sys.stdin.readline

def dfs(graph, v, visited):
    visited[v] = True
    for i in graph[v]:
        if not visited[i]:
            dfs(graph, i , visited)



n , m = map(int, si().split())
graph = [[] for _ in range(n + 1)]

for i in range(m):
    u, v = map(int, si().split())
    graph[u].append(v)
    graph[v].append(u)

ans = 0
visited = [False] * (n+1)


for i in range(1, n+1):
    if not visited[i]:
        dfs(graph, i, visited)
        ans += 1

print(ans)