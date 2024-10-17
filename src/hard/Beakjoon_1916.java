package hard;

// 최소 비용 구하기

import org.w3c.dom.Node;

import java.io.*;
import java.util.*;

public class Beakjoon_1916 {
    static int N,M;
    static int[] dist;
    static ArrayList<Discount>[] list;
    static boolean[] visit;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        list = new ArrayList[N + 1];
        dist = new int[N + 1];
        visit = new boolean[N + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        for(int i = 0; i <= N; i++){
            list[i] = new ArrayList<Discount>();
        }
        for(int i = 0; i< M; i++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            list[start].add(new Discount(end, weight));
        }
        st = new StringTokenizer(br.readLine());
        int startIndex = Integer.parseInt(st.nextToken());
        int endIndex = Integer.parseInt(st.nextToken());
        bw.write(dijkstra(startIndex, endIndex) + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
    public static int dijkstra(int start, int end){
        PriorityQueue<Discount> pq = new PriorityQueue<>();
        pq.offer(new Discount(start, 0));
        dist[start] = 0;
        while(!pq.isEmpty()){
            Discount now_node = pq.poll();
            int now = now_node.targetNode;
            if(!visit[now]){
                visit[now] = true;
                for(Discount n : list[now]){
                    if(!visit[n.targetNode] && dist[n.targetNode] > dist[now] + n.value){
                        dist[n.targetNode] = dist[now] + n.value;
                        pq.add(new Discount(n.targetNode, dist[n.targetNode]));
                     }
                }
            }
        }
        return dist[end];
    }
}
class Discount implements Comparable<Discount>{
    int targetNode;
    int value;

    Discount(int targetNode, int value) {
        this.targetNode = targetNode;
        this.value = value;
    }


    @Override
    public int compareTo(Discount o) {
        return value  - o.value;
    }
}