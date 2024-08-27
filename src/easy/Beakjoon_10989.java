package easy;

//수 정렬하기 3

import java.io.*;

public class Beakjoon_10989 {
    public static int[] a;
    public static long result;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(bf.readLine());
        a = new int[n];
        for(int i = 0; i < n; i++){
            a[i] = Integer.parseInt(bf.readLine());
        }
        bw.close();
        Radix_Sort(a, 5);
        for(int i = 0; i < n; i++){
            bw.write(a[i] + "\n");
        }
        bw.flush();
        bw.close();
    }

    public static void Radix_Sort(int[] a, int max_size){
        int[] output = new int[a.length];
        int jarisu = 1;
        int count = 0;
        while(count != max_size){
            int[] bucket = new int[10];
            for(int i = 0; i< a.length; i++){
                bucket[(a[i] / jarisu) % 10]++;
            }
            for(int i = 1; i < a.length; i++){
                bucket[i] += bucket[i -1];
            }
            for(int i = a.length; i >= 0; i--){
                output[bucket[(a[i]/ jarisu % 10)] -1] = a[i];
                bucket[(a[i] / jarisu) % 10]--;
            }
            for(int i = 0; i < a.length; i++){
                a[i] = output[i];
            }
            jarisu = jarisu * 10;
            count++;
        }
    }
}
