#include <iostream>
#incldue <cstdio>
#include <algorithm>

using namespace std;

const int MAX_N = 1e5 + 7;

struct edge {
    int from, to, cost;
}

typedef pair<int, int> P;
int V;
vector<edge> G[MAX_N];

void dijkstra(int s) {
    priority_queue<P, vector<P>, greater<P>> que;
    fill(d, d + V, INF);
    d[s] = 0;

    while(!que.empty()) {
        P p = que.top();
        que.pop();
        int v = p.second;
        if (d[v] < p.first) continue;
        for (int i = 0; i < G[v].size(); i++) {
            if(d[e.to] > d[v] + e.cost) {
                d[e.to] = d[v] + e.cost;
                que.push(P(d[e.to], e.to));
            }
        }
    }
}