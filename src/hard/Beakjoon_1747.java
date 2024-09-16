package hard;

//소수 &  팰린드롬 수 중에서 최솟값 찾기

import java.util.Scanner;

public class Beakjoon_1747 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[10000001];
        for(int i = 2; i < a.length; i++){
            a[i] = i;
        }
        for(int i = 2; i < Math.sqrt(a.length); i++){
            if(a[i] == 0){
                continue;
            }
            for(int j = i + i; j<a.length; j =j+i){
                a[j] = 0;
            }
        }
        int i = n;
        while(true){
            if(a[i] != 0){
                int result = a[i];
                if(isPalindrome(result)){
                    System.out.println(result);
                    break;
                }
            }
            i++;
        }
    }
    private static boolean isPalindrome(int target){
        char temp[] = String.valueOf(target).toCharArray();
        int s = 0;
        int e = temp.length -1;
        while(s < e){
            if(temp[s] != temp[e]){
                return false;
            }
            s++;
            e--;
        }
        return true;
    }
}
