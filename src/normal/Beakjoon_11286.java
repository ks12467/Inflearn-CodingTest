package normal;

//절대값 힙 구현하기

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Beakjoon_11286 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());
        PriorityQueue<Integer> myQueue = new PriorityQueue<>((o1, o2) -> {
            int first_abs = Math.abs(o1);
            int second_abs = Math.abs(o2);
            if(first_abs == second_abs){
                return o1>o2 ? 1 : -1;
            } else {
                return first_abs - second_abs;
            }
        });
        for(int i = 0; i < n; i++){
            int request = Integer.parseInt(bf.readLine());
            if(request ==0){
                if(myQueue.isEmpty()){
                    System.out.println("0");
                } else {
                    System.out.println(myQueue.poll());
                }
            } else {
                myQueue.add(request);
            }
        }
    }
}
