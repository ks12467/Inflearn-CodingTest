package hard;

//최장 공통 부분 수열 찾기

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Beakjoon_9252 {
    private static long[][] DP;
    private static ArrayList<Character> Path;
    private static char[] A;
    private static char[] B;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        A = br.readLine().toCharArray();
        B = br.readLine().toCharArray();
        DP = new long[A.length + 1][B.length + 1];
        Path = new ArrayList<Character>();
        for(int i = 1; i <= A.length; i++){
            for(int j = 1; j <= B.length; j++){
                if(A[i - 1] == B[j - 1]){
                    DP[i][j] = DP[i - 1][j - 1] + 1;
                } else {
                    DP[i][j] = Math.max(DP[i - 1][j], DP[i][j - 1]);
                }
            }
        }
        System.out.println(DP[A.length][B.length]);
        getText(A.length, B.length);
        for(int i = Path.size() - 1; i >= 0; i--){
            System.out.println(Path.get(i));
        }
        System.out.println();
    }
    private static void getText(int r, int c){
        if(r == 00 || c == 0){
            return;
        }
        if(A[r - 1] == B[c - 1]){
            Path.add(A[r - 1]);
            getText(r - 1, c - 1);
        } else {
            if(DP[ r - 1][c] > DP[r][c - 1]){
                getText( r - 1, c);
            } else {
                getText(r, c - 1);
            }
        }
    }
}
