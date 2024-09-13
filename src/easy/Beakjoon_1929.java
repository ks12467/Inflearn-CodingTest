package easy;

//소수 구하기

import java.util.Scanner;

public class Beakjoon_1929 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        int[] a = new int[n + 1];
        for(int i = 2; i <= n; i++){
            a[i] = i;
        }
        for(int i = 2; i<= Math.sqrt(n); i++){
            if(a[i] == 0){
                continue;
            }
            for(int j = i + 1; j <= n; j=j+1){
                a[j] = 0;
            }
        }
        for(int i = m; i<= n; i++){
            if(a[i] != 0){
                System.out.println(a[i]);
            }
        }
    }
}
