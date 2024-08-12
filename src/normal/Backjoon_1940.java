package normal;

/*
문제
갑옷을 만드는 재료들은 각각의 고유한 번호가 있고, 갑옷은 2개의 재료로 만드는데
2가지의 고유 번호를 합쳐 M(1 <= M <= 10,000,000)이 되면 갑옷이 만들어진다
N(1 <= N < 15,000) 개의 재료와 M이 주어졌을 때 몇 개의 갑옷을 만들 수 있을까?
 */

/*
슈도 코드
N(재료의 개수), M(갑옷이 되는 번호) 저장하기
for(N만큼 반복)
{
    재료 배열 저장
}

재료 배열 정렬하기
while(i<j)
{
    if(재료 합 < M) 작은 번호 재료를 한칸 위로 변경
    else if(재료 합 > M) 큰 번호 재료 를 한칸 아래로 변경
    else 경우의 수 증가, 양쪽 index 각각 변경
}
count 출력하기
 */

import javax.imageio.IIOException;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Backjoon_1940 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        int[] A = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i< N; i++){
            A[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(A);
        int count = 0;
        int i= 0;
        int j = N-1;

        while(i<j){
            if(A[i] + A[j] < M){
                i++;
            } else if (A[i] + A[j] > M) {
                j--;
            } else {
                count++;
                i++;
                j--;
            }
        }
        System.out.println(count);
    }
}
