package hard;

//이분 그래프 판별하기 / 골드 4

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Beakjoon_1707 {
    static ArrayList<Integer>[] A;
    static int [] check;
    static boolean visited[];
    static boolean IsEven;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        for(int i = 0; i < N; i++){
            String[] s = br.readLine().split(" ");
            int V = Integer.parseInt(s[0]);
            int E = Integer.parseInt(s[1]);
            A = new ArrayList[V + 1];
            visited = new boolean[V + 1];
            check = new int[V + 1];
            IsEven = true;
            for(int j = 1; j <= V; j++){
                A[j] = new ArrayList<Integer>();
            }
            for(int j = 0; j < E; j++){
                s = br.readLine().split(" ");
                int start = Integer.parseInt(s[0]);
                int end = Integer.parseInt(s[1]);
                A[start].add(end);
                A[end].add(start);
            }
            for(int j = 1; j <= V; j++){
                if(IsEven){
                    DFS(j);
                } else{
                    break;
                }
            }
            if (IsEven) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }
    public static void DFS(int node){
        visited[node] = true;
        for(int i : A[node]){
            if(!visited[i]){
                check[i] = (check[node] + 1) % 2;
                DFS(i);
            }
            else if(check[node] == check[i]){
                IsEven = false;
            }
        }
    }
}
