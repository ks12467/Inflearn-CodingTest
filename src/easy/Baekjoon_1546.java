package easy;
// 평균 구하기

/*문제
시험을 본 과목의 개수 N
1000 >= N
현재 성적 sum =100 >= sum > 0
*/

/*
슈도 코드
변수 N에 과목 수 입력
길이가 N인 1차원 배열 A[] 선언
for(A[] 만큼 길이 반복){
    A[i]에 각 점수 저장
}
for(A[] 만금 길이 반복){
    최고점은 변수 max에, 총점은 sum에 저장
}
sum * 100/ max / n 출력
 */


import java.util.Scanner;

public class Baekjoon_1546 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int A[] = new int[N];
        long sum = 0;
        long max = 0;

        for(int i = 0; i< N; i++){
            int temp = sc.nextInt();
            if(temp>max){
                max = temp;
            }
            sum = sum + temp;
        }
        System.out.println(sum * 100.0 /max/N);
    }
}
