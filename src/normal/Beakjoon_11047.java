package normal;

//동전 개수의 최솟값 구하기

import java.util.Scanner;

public class Beakjoon_11047 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] a = new int[n];
        for(int i = 0; i < n; i++){
            a[i] = sc.nextInt();
        }
        int count = 0;
        for(int i = n-1; i>=0; i--){
            if(a[i] <= k){
                count += (k/a[i]);
                k = k % a[i];
            }
        }
        System.out.print(count);
    }
}
