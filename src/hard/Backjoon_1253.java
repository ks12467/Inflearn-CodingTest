package hard;

//좋은 수 구하기

/*
문제 :
주어진 N개의 수에서 다른 수의 합으로 표현되고 수가 있다면 그 수를 '좋은 수' 라고 한다. N개의 수 중 좋은 수가 총 몇개인지 출력하시오.
1번째 줄에 수의 개수 N(1 <= N <= 2,000), 2번째 줄에 N개의 수의 값(Ai)이 주어진다 (|Ai| <= 1,00,000,000) Ai는 정수)
 */

/*
슈도 코드 :
N(수의 개수)
A(수 데이터 저장 배열)
for(N만큼 반복하기)
{
    A 배열에 데이터 저장하기
}

A 배열 정렬하기

for(k를 0부터 N까지 반복)
{
    변수 초기화(찾고자 하는 값 find, 포인터 i, 포인터 j)
    while(i<j)
    {
        if(A[i] + A[j] == 찾고자 하는 값)
            두 포인터 i, j가 k가 아닐 때 결과값에 반영 및 while 문 종료
            두 포인터 i, j 가 k가 맞을 때 포인터 변경 및 계속 수행하기
        else if(A[i] + a[j] < 찾고자 하는 값) 포인터 i 증가
        else 포인터 j 감소
    }
}
좋은 수의 개수 출력하기
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Backjoon_1253 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        int result = 0;
        long A[] = new long[N];
        StringTokenizer st = new StringTokenizer(bf.readLine());
        for(int i = 0; i < N; i++){
            A[i] = Long.parseLong(st.nextToken());
        }
        Arrays.sort(A);
        for(int k = 0; k < N; k++){
            long find = A[k];
            int i = 0;
            int j = N - 1;

            while(i<j){
                if(A[i] + A[j] == find){
                    if(i != k && j != k){
                        result++;
                        break;
                    } else if(i == k ){
                        i++;
                    } else if (j == k) {
                        j--;
                    }
                } else if (A[i] + A[j] < find) {
                    i++;
                } else {
                    j--;
                }
            }
        }
        System.out.println(result);
        bf.close();
    }
}
