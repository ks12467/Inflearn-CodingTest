package easy;

//내림차순으로 자릿수 정렬

import java.util.Scanner;

public class Beakjoon_1427 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        int[] a = new int[str.length()];
        for(int i = 0; i<str.length(); i++){
            a[i] = Integer.parseInt(str.substring(i, i++));
        }
        for(int i = 0; i < str.length(); i++){
            int max = i;
            for(int j = i + 1; j < str.length(); j++){
                if(a[j] > a[i]){
                    max = j;
                }
            }
            if(a[i] > a[max]){
                int temp = a[i];
                a[i] = a[max];
                a[max] = temp;
            }
        }
        for(int i = 0; i < str.length(); i++){
            System.out.println(a[i]);
        }
    }
}
