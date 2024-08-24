package easy;

//수 정렬하기2

import java.io.*;

public class Beakjoon_2751 {
    public static int[] a, temp;
    public static long result;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bo = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(bf.readLine());
        a = new int[n + 1];
        temp = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            a[i] = Integer.parseInt(bf.readLine());
        }
        marget_sort(1, n);
        for (int i = 0; i <= n; i++) {
            bo.write(a[i] + "\n");
        }
        bo.flush();
        bo.close();
    }

    private static void marget_sort(int s, int e) {
        if (e - s < 1) {
            return;
        }
        int m = s + (e - s) / 2;
        marget_sort(s, m);
        marget_sort(m + 1, e);
        for (int i = s; i <= e; i++) {
            temp[i] = a[i];
        }
        int k = s;
        int index1 = s;
        int index2 = m + 1;
        while (index1 <= m && index2 <= e) {
            if (temp[index1] > temp[index2]) {
                a[k] = temp[index2];
                k++;
                index2++;
            } else {
                a[k] = temp[index1];
                k++;
                index1++;
            }
        }
        while (index1 <= m) {
            a[k] = temp[index1];
            k++;
            index1++;
        }
        while (index2 <= e) {
            a[k] = temp[index2];
            k++;
            index2++;
        }
    }
}