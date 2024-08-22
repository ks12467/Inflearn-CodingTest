package normal;

//K번째 수 구하기

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Beakjoon_11004 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in ));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int n = Integer.parseInt(bf.readLine());
        int k = Integer.parseInt(bf.readLine());
        st = new StringTokenizer(bf.readLine());
        int[] a = new int[n];
        for(int i = 0; i < n; i++ ){
            a[i] = Integer.parseInt(st.nextToken());
        }
        quickSort(a, 0, n-1, k-1);
        System.out.println(a[k-1]);
    }

    public static void quickSort(int[] a, int s, int e, int k) {
        if(s<e){
            int pivot = partition(a,s,e);
            if(pivot == k){
                return;
            } else if(k<pivot){
                quickSort(a,s,pivot -1, k);
            }else{
                quickSort(a,pivot+1,e,k);
            }
        }
    }
    public static int partition(int[] a, int s, int e){
        if(s + 1 == e){
            if(a[s] > a[e])swap(a,s,e);
            return e;
        }
        int m = (s + e) /2;
        swap(a,s,m);
        int pivot = a[s];
        int i = s +1, j =e;
        while(i<=j){
            while(j >= s+1 && pivot < a[j]){
                j--;
            }
            while( i<=e && pivot > a[i]){
                i++;
            }
            if(i<=j){
                swap(a,i++,j--);
            }
        }
        a[s] = a[j];
        a[j] = pivot;
        return j;
    }
    public static void swap(int[] a, int i, int j){
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}
