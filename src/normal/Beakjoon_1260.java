package normal;

//DFS와 BFS 프로그램

import java.util.*;

public class Beakjoon_1260 {
    static boolean visited[];
    static ArrayList<Integer>[] a;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int start = sc.nextInt();
        a = new ArrayList[n + 1];
        for(int i = 1; i <= n; i++){
            a[i] = new ArrayList<Integer>();
        }
        for(int i = 0; i < m; i++){
            int s = sc.nextInt();
            int e = sc.nextInt();
            a[s].add(e);
            a[e].add(s);
        }
        for(int i = 1; i <= n; i++){
            Collections.sort(a[i]);
        }
        visited = new boolean[n + 1];
        DFS(start);
        System.out.println();
        visited = new boolean[n + 1];
        BFS(start);
        System.out.println();
    }

    public static void DFS(int node){
        System.out.println(node + " ");
        visited[node] = true;
        for(int i : a[node]){
            if(!visited[i]){
                DFS(i);
            }
        }
    }
    public static void BFS(int node){
        Queue<Integer> queue = new LinkedList<Integer>();
        queue.add(node);
        visited[node] = true;

        while(!queue.isEmpty()){
            int now_node = queue.poll();
            System.out.println(now_node + " ");
            for(int i : a[now_node]){
                if(!visited[i]){
                    visited[i] = true;
                    queue.add(i);
                }
            }
        }
    }
}
