package normal;

//DNA 비밀번호

/*
슈도 코드 :
S(문자열 크기) P(부분 문자열의 크기)
A(문자열 데이터)
checkArr(비밀번호 체크 배열)
myArr(현재 상태 배열)
checkSecret(몇 개의 문자와 관련된 개수를 충족했는지 판단하는 변수)
P 범위 (0 ~ P -1) 만큼 S 배열에 적용하고, 유효한 비밀번호인지 판단하기
for(i를 P에서 S까지 반복)
{
    j선언(i -P)
    한 칸씩 이동하면서 제거되는 문자열과 새로 들어오는 문자열을 처리하기
    유효한 비밀번호인지(checkSecret == 4) 판단해 결과값에 업데이트
}
결과값 출력

별도 함수
Add(문자 더하기 함수)
{
    새로 들어온 문자를 my Arr에 업데이트 하거나 checkSecret 값 변경하기
}
Remove(문자 빼기 함수)
{
    제거되는 문자를 myArr에 업데이트하거나 checkSecret 값 변경하기
}
 */


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Backjoon_12891 {
    static int checkArr[];
    static int myArr[];
    static int checkSecret;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int s = Integer.parseInt(st.nextToken());
        int p = Integer.parseInt(st.nextToken());
        int result = 0;
        char A[] = new char[s];
        checkArr = new int[4];
        myArr = new int[4];
        checkSecret = 0;
        A = bf.readLine().toCharArray();
        st = new StringTokenizer(bf.readLine());
        for (int i = 0; i < 4; i++) {
            checkArr[i] = Integer.parseInt(st.nextToken());
            if (checkArr[i] == 0) {
                checkSecret++;
            }
        }
        for (int i = 0; i < p; i++) {
            Add(A[i]);
        }
        if (checkSecret == 4) {
            result++;
        }
        for (int i = p; i < s; i++) {
            int j = i - p;
            Add(A[i]);
            Remove(A[j]);
            if (checkSecret == 4) {
                result++;
            }
        }
        System.out.println(result);
        bf.close();
    }

    private static void Add(char c) {
        switch (c) {
            case 'A':
                myArr[0]++;
                if (myArr[0] == checkArr[0]) {
                    checkSecret++;
                }
                break;

            case 'C':
                myArr[1]++;
                if (myArr[1] == checkArr[1]) {
                    checkSecret++;
                }
                break;

            case 'G':
                myArr[2]++;
                if (myArr[2] == checkArr[2]) {
                    checkSecret++;
                }
                break;

            case 'T':
                myArr[3]++;
                if (myArr[3] == checkArr[3]) {
                    checkSecret++;
                }
                break;
        }
    }
    private static void Remove(char c) {
        switch (c) {
            case 'A':
                myArr[0]--;
                if (myArr[0] == checkArr[0]) {
                    checkSecret--;
                }
                myArr[0]--;
                break;

            case 'C':
                myArr[1]--;
                if (myArr[1] == checkArr[1]) {
                    checkSecret--;
                }
                myArr[1]--;
                break;

            case 'G':
                myArr[2]--;
                if (myArr[2] == checkArr[2]) {
                    checkSecret--;
                }
                myArr[2]--;
                break;

            case 'T':
                myArr[3]--;
                if (myArr[3] == checkArr[3]) {
                    checkSecret--;
                }
                myArr[3]--;
                break;
        }
    }
}
