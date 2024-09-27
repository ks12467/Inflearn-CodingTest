package hard;

//칵테일 만들기

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class Beakjoon_1033 {
    static ArrayList<cNode>[] A;
    static long lcm;
    static boolean visited[];
    static long d[];

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = sc.nextInt();
        A = new ArrayList[n];
        visited = new boolean[n];
        d = new long[n];
        lcm = 1;
        for (int i = 0; i < n; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int p = sc.nextInt();
            int q = sc.nextInt();

            A[a].add(new cNode(b, p, q));
            A[b].add(new cNode(a, p, q));
            lcm *= (p * q / gcd(p, q));
        }
        d[0] = lcm;
        DFS(0);
        long mgcd = d[0];
        for (int i = 1; i < n; i++) {
            mgcd = gcd(mgcd, d[i]);
        }
        for (int i = 0; i < n; i++) {
            System.out.println(d[i] / mgcd + " ");
        }
    }

    public static long gcd(long a, long b) {
        if (b == 0) {
            return a;
        } else {
            return gcd(b, a % b);
        }
    }

    public static void DFS(int node) {
        visited[node] = true;
        for (cNode i : A[node]) {
            int next = i.getB();
            if (!visited[next]) {
                d[next] = d[node] * i.getQ() / i.getP();
                DFS(next);
            }
        }
    }
}

class cNode {
    int b;
    int p;
    int q;

    public cNode(int b, int p, int q) {
        super();
        this.b = b;
        this.p = p;
        this.q = q;
    }

    public int getB() {
        return b;
    }

    public int getP() {
        return p;
    }

    public int getQ() {
        return q;
    }
}
