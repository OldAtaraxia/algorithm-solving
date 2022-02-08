package AlgorithmUtils;

public class 并查集 {
    public static int[] p;

    public static int find(int x) {
        if (p[x] != x)
            p[x] = find(p[x]);
        return p[x];
    }

    public static void union(int x, int y) {
        int xRoot = find(x);
        int yRoot = find(y);
        if (xRoot != yRoot)
            p[xRoot] = yRoot;
    }

    public static void main(String[] args) {
        int n = 5;
        p = new int[n + 1];
        for (int i = 1; i <= n; i++)
            p[i] = i;
        union(1, 2);
        union(2, 3);
        union(3, 4);
        union(4, 5);
        union(5, 1);
        for (int i = 1; i <= n; i++)
            System.out.print(find(i) + " ");
    }
}
