package hard;

//블루레이 만들기

import java.util.Scanner;

public class Beakjoon_2343 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] a = new int[n];
        int start = 0;
        int end = 0;
        for(int i = 0; i < n; i++){
            a[i] = sc.nextInt();
            end = end + a[i];
        }
        while(start <= end){
            int middle = (start + end) / 2;
            int sum = 0;
            int count = 0;
            for(int i = 0; i < n; i++){
                if(sum + a[i] > middle){
                    count++;
                    sum = 0;
                }
                sum = sum + a[i];
            }
            if(sum != 0){
                count++;
            }
            if(count > m){
                start = middle + 1;
            } else{
                end = middle - 1;
            }
        }
        System.out.println(start);
    }
}
