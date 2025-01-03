package normal;

//2 * N 타일 채우기

import java.util.Scanner;

public class Beakjoon_11726 {
    static long mod = 10007;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        long D[] = new long[1001];
        D[1] = 1;
        D[2] = 2;
        for(int i = 3; i <= N; i ++){
            D[i] = (D[i - 1] + D[i - 2]) % mod;
        }
        System.out.println(D[N]);
    }
}
