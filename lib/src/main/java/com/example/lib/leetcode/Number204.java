package com.example.lib.leetcode;

public class Number204 {

    public static void main(String[] args) {
        Number204 number202 = new Number204();
        number202.countPrimes2(10);
    }

    public int countPrimes2(int n) {
        boolean[] isPrime = new boolean[n];
        for (int i = 0; i < isPrime.length; i++) {
            isPrime[i] = true;
        }
        for (int i = 2; i * i < n; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j < n; j += i) {
                    isPrime[j] = false;
                }
            }
        }

        int count = 0;
        for (int i = 2; i < isPrime.length; i++) {
            if (isPrime[i]) {
                count++;
            }
        }
        return count;
    }


    public int countPrimes(int n) {
        int count = 0;
        for (int i = 2; i < n; i++) {
            if (isPrime(i)) {
                count++;
            }
        }
        return count;
    }

    public boolean isPrime(int num) {
        if (num <= 1) return false;
        for (int i = 2; i * i <= num; i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }
}
