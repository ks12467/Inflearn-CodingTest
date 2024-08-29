package easy;

// 연결 요소의 개수

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Beakjoon_11724 {
   static ArrayList<Integer> [] a;
   static boolean visited[];

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        a = new ArrayList[n + 1];
        visited = new boolean[n + 1];
        for(int i = 1; i < n + 1; i++){
            a[i] = new ArrayList<Integer>();
        }
        for(int i = 0; i < m; i++){
            st = new StringTokenizer(bf.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            a[s].add(e);
            a[e].add(s);
        }
        int count = 0;
        for(int i = 0; i<n+1; i++){
            if(!visited[i]){
                count++;
                DFS(i);
            }
        }
        System.out.println(count);
    }
    static void DFS(int v){
        if(visited[v]){
            return;
        }
        visited[v] = true;
        for(int i :a[v]){
            if(visited[v] ==false){
                DFS(i);
            }
        }
    }
}
