package com.search;

import java.util.Arrays;

public class BinSearch {
    // n : elements , a : arr, key
    public static int binSearch(int a[], int n, int key) {
        int pl = 0;
        int pr = n;
        int mid = (pl+pr)/2;

        while (pl<=pr) {
            System.out.println("mid = " + mid);
            if(a[mid]==key)
                return mid;
            else if(a[mid]<key){
                pl=mid+=1;
            }else{
                pr=mid-1;
            }
            mid = (pl+pr)/2;
        }
        return -1;
    }

    public static void main(String[] args) {
        int [] arr ={3,2,1,4,6,5,9,8,7};
        int val;
        Arrays.sort(arr);
        for(int v : arr){
            System.out.println("v = " + v);
        }
        val = binSearch(arr,arr.length,4);
        System.out.println("val = " + val);
    }
}
