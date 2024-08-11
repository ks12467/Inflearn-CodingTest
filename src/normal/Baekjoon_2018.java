package normal;

//연속된 자연수의 합 구하기

/*
문제
어떠한 자연수 N은 몇 개의 연속된 자연수의 합으로 나타낼 수 있다.
어떤 자연수  N(1 <= N <= 10,000,000)을 몇 개의 연속된 자연수의 합으로 나타내는 가짓수를 알고싶다.
이때 사용하는 자연수는 N이어야 한다.
N을 입력받아 연속된 자연수의 합으로 나타내는 가짓수를 출력하는 프로그램을 작성하시오
 */

/*
슈도 코드
N 변수 저장
사용 변수 초기화(count = 1, start_index = 1, end_index = 1, sum =1)
while(end_index != N){
    if(sum == N) count 증가, end_index 증가. sum 값 변경
    else if(sum > N) sum 값 변경, start_index 증가
    else if(sum < N) end_index 증가, sum값 변경
}

count 출력
 */

import java.util.Scanner;

public class Baekjoon_2018 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int count = 1;
        int start_index = 1;
        int end_index = 1;
        int sum = 1;
        while(end_index != N){
            if(sum == N){
                count++; end_index++;
                sum = sum + end_index;
            } else if (sum > N) {
                sum = sum - start_index;
                start_index++;
            } else {
                end_index++;
                sum = sum + end_index;
            }
        }
        System.out.println(count);
    }
}
