package com.code.algorithm.dynamic;

public class MatrixChain {

    public static int[][] c;
    public static int[][] s;
    static int[] a;
    public static void main(String[] args) {
        a = new int[] {30,35,15, 5};
        c = new int[a.length][a.length];
        s = new int[a.length][a.length];
        compute(a);
        System.out.println(result(1, a.length-1) + "\n" + c[1][a.length-1]);
    }

    private static void compute(int[] a) {
        int j, temp;
        for (int n = 1; n < a.length; n++) {
            for (int i = 1; i+n < a.length; i++) {
                j = i+n;
                c[i][j] = Integer.MAX_VALUE;
                for (int k = i; k < j; k++) {
                    temp = c[i][k] + c[k+1][j] + a[i-1]*a[k]*a[j];
                    if (temp < c[i][j]) {
                        c[i][j] = temp;
                        s[i][j] = k;
                    }
                }
            }
        }
    }
    private static String result(int start, int end) {
        if (start==end) {
            return "A"+start;
        }
        int k = s[start][end];
        StringBuffer sb = new StringBuffer();
        sb.append("(").append(result(start, k)).append(result(k+1, end)).append(")");
        return sb.toString();
    }
}
