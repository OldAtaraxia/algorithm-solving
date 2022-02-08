package AlgorithmUtils;

public class Graphic {
    public static int INF = 0x3f3f3f3f;
    public static int n;
    public static Map<Integer, List<Node>> map = new HashMap<>();
    public static int[] dist;
    public static boolean[] visit;

    public static class Node {
        public int node;
        public int length;

        public Node(int node, int length) {
            this.node = node;
            this.length = length;
        }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        n = scan.nextInt();
        dist = new int[n + 1];
        visit = new boolean[n + 1];
        int m = scan.nextInt();
        for (int i = 1; i <= n; i++)
            map.put(i, new ArrayList<>());
        for (int i = 0; i < m; i++) {
            int x = scan.nextInt(), y = scan.nextInt(), z = scan.nextInt();
            map.get(x).add(new Node(y, z));
        }
        int res = dijkstra();
        System.out.println(res);
    }

    public static int dijkstra() {
        for (int i = 1; i <= n; i++)
            dist[i] = INF;
        dist[1] = 0;
        for (int i = 0; i < n - 1; i++) {
            int t = -1;
            for (int j = 1; j <= n; j++)
                if (!visit[j] && (t == -1 || dist[t] > dist[j]))
                    t = j;
            if (t == n)
                break;
            for (int j = 1; j <= n; j++)
                dist[j] = Math.min(dist[j], dist[t] + g[t][j]);
            visit[t] = true;
        }
        if (dist[n] == INF)
            return -1;
        return dist[n];
    }

    public static int betterDijkstra() {
        for (int i = 1; i <= n; i++)
            dist[i] = INF;
        dist[1] = 0;
        PriorityQueue<Node> heap = new PriorityQueue<>((node1, node2) -> node1.length - node2.length);
        heap.add(new Node(1, 0));
        while (!heap.isEmpty()) {
            Node top = heap.poll();
            int length = top.length, cur = top.node;
            if (visit[cur])
                continue;
            visit[cur] = true;
            for (Node next: map.get(cur)) {
                int node = next.node, cost = next.length;
                if (dist[node] > length + cost) {
                    dist[node] = length + cost;
                    heap.add(new Node(node, dist[node]));
                }
            }
        }
        if (dist[n] == INF)
            return -1;
        return dist[n];
    }

    public static int spfa() {
        for (int i = 1; i <= n; i++)
            dist[i] = INF;
        dist[1] = 0;
        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);
        visit[1] = true;
        while (!queue.isEmpty()) {
            int t = queue.poll();
            visit[t] = false;
            for (Node cur: map.get(t)) {
                int node = cur.node, length = cur.length;
                if (dist[node] > dist[t] + length) {
                    dist[node] = dist[t] + length;
                    if (!visit[node]) {
                        queue.add(node);
                        visit[node] = true;
                    }
                }
            }
        }
        return dist[n];
    }

    // spfa判断是否有负环
    public static boolean spfa() {
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            queue.add(i);
            visit[i] = true;
        }
        while (!queue.isEmpty()) {
            int t = queue.poll();
            visit[t] = false;
            for (Node cur: map.get(t)) {
                int node = cur.node, length = cur.length;
                if (dist[node] > dist[t] + length) {
                    dist[node] = dist[t] + length;
                    count[node] = count[t] + 1;
                    if (count[node] >= n)
                        return true;
                    if (!visit[node]) {
                        queue.add(node);
                        visit[node] = true;
                    }
                }
            }
        }
        return false;
    }
}
