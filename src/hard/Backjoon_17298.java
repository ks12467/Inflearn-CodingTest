package hard;

// 오큰수 구하기

/*
슈도 코드
N(수열 개수) A[](수열 배열) ans[](정답배열)
수열 배열 채우기
최초 스택 초기화하기
for(N만큼 반복){
    while(스택이 비어 있지 않고, 현재 수열 값이 top에 해당하는 수열보다 클 때까지) {
        pop()
        정답 배열에 오큰수를 현재 수열로 저장하기
    }
    현재 수열을 스택에 push()
}
while(스택이 빌 때까지){
    스택에 있는 인덱스의 정답 배열에 -1 저장하기
}
정답 배열 출력하기
 */

import java.io.*;
import java.util.Stack;

public class Backjoon_17298 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());
        int[] A = new int[n];
        int[] ans = new int[n];
        String[] str = bf.readLine().split(" ");
        for(int i = 0; i < n; i++){
            A[i] = Integer.parseInt(str[i]);
        }
        Stack<Integer> myStack = new Stack<>();
        myStack.push(0);
        for(int i = 0; i< n; i++){
            while(!myStack.isEmpty() && A[myStack.peek()] < A[i]){
                ans[myStack.pop()] = A[i];
            }
            myStack.push(i);
        }
        while(!myStack.empty()){
            ans[myStack.pop()] = -1;
        }
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for(int i = 0; i < n; i++){
            bw.write(ans[i] + " ");
        }
        bw.write("\n");
        bw.flush();
    }
}
