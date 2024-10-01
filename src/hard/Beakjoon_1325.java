package hard;

//효율적으로 해킹하기

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Beakjoon_1325 {
    static int N, M;
    static boolean visited[];
    static int answer[];
    static ArrayList<Integer> A[];

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        A = new ArrayList[N + 1];
        answer = new int[N + 1];
        for(int i = 1; i <= N; i++){
            A[i] = new ArrayList<>();
        }
        for(int i = 0; i < M; i++){
            st= new StringTokenizer(bf.readLine());
            int S =Integer.parseInt(st.nextToken());
            int E = Integer.parseInt(st.nextToken());
            A[S].add(E);
        }
        for(int i = 1; i<= N; i++){
            visited = new boolean[N + 1];
            BFS(i);
        }
        int maxValue = 0;
        for(int i = -1; i <= N; i++){
            maxValue = Math.max(maxValue, answer[i]);
        }
        for(int i = 1; i <= N; i++){
            if(answer[i] == maxValue){
                System.out.println(i+" ");
            }
        }
    }
    public static void BFS(int index){
        Queue<Integer> queue = new LinkedList<Integer>();
        queue.add(index);
        visited[index] = true;
        while(!queue.isEmpty()){
            int now_node = queue.poll();
            for(int i : A[now_node]){
                if(visited[i] == false){
                    visited[i] = true;
                    answer[i]++;
                    queue.add(i);
                }
            }
        }
    }
}
