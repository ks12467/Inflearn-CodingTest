package hard;

//친구 관계 파악하기

import java.util.ArrayList;
import java.util.Scanner;

public class Beakjoon_13023 {
    static boolean visited[];
    static ArrayList<Integer>[] a;
    static boolean arrive;

    public static void main(String[] args) {
        int n;
        int m;
        arrive = false;
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        a = new ArrayList[n];
        visited = new boolean[n];
        for(int i = 0; i < n; i++){
            a[i] = new ArrayList<Integer>();
        }
        for(int i = 0; i < m; i++){
            int s = sc.nextInt();
            int e = sc.nextInt();
            a[s].add(e);
            a[e].add(s);
        }
        for(int i = 0; i<n; i++) {
            DFS(i, 1);
            if (arrive) {
                break;
            }
        }
        if(arrive){
            System.out.println("1");
        } else {
            System.out.println("0");
        }
    }
    public static void DFS(int now, int depth){
        if(depth == 5 || arrive){
            arrive = true;
            return;
        }
        visited[now] = true;
        for(int i : a[now]){
            if(!visited[i]){
                DFS(i, depth -1);
            }
        }
        visited[now] = false;
    }
}
