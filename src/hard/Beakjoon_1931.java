package hard;

//회의실 배정하기

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Beakjoon_1931 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] a = new int[n][2];
        for(int i = 0; i< n; i++){
            a[i][0]= sc.nextInt();
            a[i][1]= sc.nextInt();
        }
        Arrays.sort(a, new Comparator<int[]>() {
            @Override
            public int compare(int[] s, int[] e) {
                if(s[1] == e[1]){
                    return s[0] - e[0];
                }
                return s[1] - e[1];
            }
        });
        int count = 0;
        int end = -1;
        for(int i = 0; i<n; i++){
            if(a[i][0] >= end){
                end = a[i][1];
                count++;
            }
        }
        System.out.println(count);
    }
}
