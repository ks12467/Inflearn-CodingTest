package easy;

//수 정렬하기

import java.util.Scanner;

public class Beakjoon_2750 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        for(int i = 0; i < n; i++){
            a[i] = sc.nextInt();
        }
        for(int i = 0; i< n-1; i++){
            for(int j = 0; j<n -1; j++){
                if(a[j] > a[i]){
                    int temp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = temp;
                }
            }
        }
        for(int i = 0; i< n; i++){
            System.out.println(a[i]);
        }
    }
}
