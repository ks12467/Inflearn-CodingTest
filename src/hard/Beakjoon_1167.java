package hard;

//트리의 지름 구하기

import java.util.*;

public class Beakjoon_1167 {
    static boolean visited[];
    static int[] distance;
    static ArrayList<Edge>[] a;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc. nextInt();
        a = new ArrayList[n + 1];
        for(int i = 1; i < n; i++){
            int s = sc.nextInt();
            while(true){
                int e = sc.nextInt();
                if(e == -1){
                    break;
                }
                int v = sc.nextInt();
                a[s].add(new Edge(e,v));
            }
        }
        distance = new int[n + 1];
        visited = new boolean[n + 1];
        BFS(1);
        int max = 1;
        for(int i = 2; i<= n; i++){
            if(distance[max] < distance[i]){
                max = i;
            }
        }
        distance = new int[n + 1];
        visited = new boolean[n + 1];
        BFS(max);
        Arrays.sort(distance);
        System.out.println(distance[n]);
    }
    private static void BFS(int index){
        Queue<Integer> queue = new LinkedList<Integer>();
        queue.add(index);
        visited[index] = true;
        while(!queue.isEmpty()){
            int now_node = queue.poll();
            for(Edge i : a[now_node]){
                int e = i.e;
                int v = i.value;
                if(!visited[e]){
                    visited[e] = true;
                    queue.add(e);
                    distance[e] = distance[now_node] + v;
                }
            }
        }
    }

}
class Edge{
    int e;
    int value;
    public Edge(int e, int value){
        this.e = e;
        this.value = value;
    }
}


