package easy;

//원하는 정수 찾기

import java.util.Arrays;
import java.util.Scanner;

public class Beakjoon_1920 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        for(int i = 0; i < n; i++){
            a[i] = sc.nextInt();
        }
        Arrays.sort(a);
        int m = sc.nextInt();
        for(int i = 0; i < m; i++){
            boolean find = false;
            int target = sc.nextInt();
            int start = 0;
            int end = a.length -1;
            while(start <= end){
                int midi = (start + end) / 2;
                int midV = a[midi];
                if(midV > target){
                    end = midi - 1;
                } else if(midV < target){
                    start = midi + 1;
                } else {
                    find = true;
                    break;
                }
            }
            if(find) {
                System.out.println(1);
            } else {
                System.out.println(0);
            }
        }
    }
}
