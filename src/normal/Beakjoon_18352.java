package normal;

//특정 거리의 도시 찾기

import java.util.*;

public class Beakjoon_18352 {
    static int visited[];
    static ArrayList<Integer>[] A;
    static int n, m, k, x;
    static List<Integer> answer;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n =sc.nextInt();
        m =sc.nextInt();
        k =sc.nextInt();
        x =sc.nextInt();
        A = new ArrayList[n + 1];
        answer = new ArrayList<>();
        for(int i = 1; i <= n; i++){
            A[i] = new ArrayList<Integer>();
        }
        for(int i = 0; i < m; i++){
            int s = sc.nextInt();
            int e = sc.nextInt();
            A[s].add(e);
        }
        visited = new int[n + 1];
        for(int i = 0; i <= n; i++){
            if(visited[i]== k){
                answer.add(i);
            }
        }
        if(answer.isEmpty()){
            System.out.println("-1");
        } else {
            Collections.sort(answer);
            for(int temp:answer){
                System.out.println(temp);
            }
        }
    }
    private static void BFS(int node){
        Queue<Integer> queue = new LinkedList<Integer>();
        queue.add(node);
        visited[node]++;
        while(!queue.isEmpty()){
            int now_node = queue.poll();
            for(int i : A[now_node]){
                if(visited[i] == -1){
                    visited[i] = visited[now_node] + 1;
                    queue.add(i);
                }
            }
        }
    }
}
