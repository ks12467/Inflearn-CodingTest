package hard;

//거의 소수 구하기

import java.util.Scanner;

public class Beakjoon_1456 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long min = sc.nextLong();
        long max = sc.nextLong();
        long[] a = new long[10000001];
        for (int i = 2; i < a.length; i++) {
            a[i] = i;
        }
        for (int i = 2; i < Math.sqrt(a.length); i++) {
            if (a[i] == 0) {
                continue;
            }
            for (int j = i + i; j < a.length; j = j + i) {
                a[j] = 0;
            }
        }
        int count = 0;
        for (int i = 2; i < 10000001; i++) {
            if (a[i] != 0) {
                long temp = a[i];
                while ((double) a[i] <= (double) max / (double) temp) {
                    if ((double) a[i] >= (double) min / (double) temp) {
                        count++;
                    }
                    temp = temp * a[i];
                }
            }
        }
        System.out.println(count);
    }

}
