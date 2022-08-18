package com.start;

import java.io.*;
import java.util.*;
//계수 정렬이 낫배드 => n의 시간 복잡도 가지게 된다. 단점 공간 복잡도를 많이 사용하게 된다.

class Main {
    public static void main(String[] args) throws IOException {
        BufferedWriter bf = new BufferedWriter(new OutputStreamWriter(System.out));
        FastReader scanner = new FastReader();

        int n = scanner.nextInt();

        ArrayList<Integer> arrayList = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int x = scanner.nextInt();
            arrayList.add(x);
        }
        Collections.sort(arrayList);
        int sum=0;
        int res=0;
        for (int i = 0; i < arrayList.size(); i++) {
            sum += arrayList.get(i);
            res+=sum;
        }
        System.out.println(res);
        //System.out.println(set.size());
    }
    public static class FastReader {
        BufferedReader br;
        StringTokenizer st;
        public FastReader() { br = new BufferedReader(new InputStreamReader(System.in)); }
        public FastReader(String s) throws FileNotFoundException { br = new BufferedReader(new FileReader(new File(s))); }
        String next() {
            while (st == null || !st.hasMoreElements()) {
                try { st = new StringTokenizer(br.readLine()); }
                catch (IOException e) { e.printStackTrace(); }
            }
            return st.nextToken();
        }
        int nextInt() { return Integer.parseInt(next()); }
        long nextLong() { return Long.parseLong(next()); }
        double nextDouble() { return Double.parseDouble(next()); }
        String nextLine() {
            String str = "";
            try { str = br.readLine(); }
            catch (IOException e) { e.printStackTrace(); }
            return str;
        }
    }
}