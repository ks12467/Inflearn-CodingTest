package hard;

//줄 세우기 / 골드 3

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Beakjoon_2252 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n =  sc.nextInt();
        int m =  sc.nextInt();
        ArrayList<ArrayList<Integer>> a = new ArrayList<>();
        for(int i = 0; i <= n; i++){
            a.add(new ArrayList<>());
        }
        int[] indergree = new int[n + 1];
        for(int i = 0; i < m; i++){
            int s = sc.nextInt();
            int e = sc.nextInt();
            a.get(s).add(e);
            indergree[e]++;
        }
        Queue<Integer> queue = new LinkedList<>();
        for(int i = 1; i <= n; i++){
            if(indergree[i]== 0){
                queue.offer(i);
            }
        }
        while(!queue.isEmpty()){
            int now = queue.poll();
            System.out.println(now + " ");
            for(int next : a.get(now)){
                indergree[next]--;
                if(indergree[next] == 0){
                    queue.offer(next);
                }
            }
        }
    }
}
