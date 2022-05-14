package com.search;

import java.util.Scanner;



public class SeqSearch {
    // n은 element의 수~ a는 담을 객체~ key는 검색할 값
    public static int seqSearch(int[] a, int n, int key) {
        int i=0;

        while (true) {
            if(i==n){
                return -1;
            }else if(a[i]==key)
                return i;// search perfect
            i++;
        }
        // for 문으로 바꾼다면?
    }
    public static int sentinelMethod(int[] a, int n, int key) {
        int i=0;
        a[n] = key;
        while (true) {
            if(a[i]==key)
                break;
            i++;
        }
        return i == n ? -1 : i;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("요소의 총 숫자");
        int num = sc.nextInt();
        //int arr[] = new int[num];
        int arr[] = new int[num+1]; //보초법

        for (int i = 0; i < num; i++) {
            System.out.println("arr["+i+"] : ");
            arr[i]= sc.nextInt();
        }

        System.out.println("검색할 값 : ");
        int key = sc.nextInt();

        int idx = sentinelMethod(arr, num, key);

        if (idx == -1) {
            System.out.println("no this element");
        }else{
            System.out.println(key+" 는 " +idx+" 에 있습니다.");
        }
    }
}
