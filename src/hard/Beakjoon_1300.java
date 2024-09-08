package hard;

//배열에서 K번째 수 찾기

import java.util.Scanner;

public class Beakjoon_1300 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        long start = 1;
        long end = k;
        long answer = 0;

        while(start <= end){
            long middle = (start + end) / 2;
            long cnt = 0;

            for(int i = 1; i <= n; i++){
                cnt += Math.min(middle/ i, n);
            }
            if(cnt < k){
                start = middle + 1;
            } else {
                answer = middle;
                end = middle - 1;
            }
        }
        System.out.println(answer);
    }
}
