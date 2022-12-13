import java.util.Random;
import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
//        Random r = new Random();
//        Scanner s = new Scanner(System.in);
//        int n;
//
//        System.out.print("Gimmie n: ");
//        n = s.nextInt();
//
//        int[] array = new int[n];
//
//        for (int i = 0; i < n; ++i)
//        {
//            array[i] = r.nextInt(1999) - 999;
//        }

        zad3();
    }

    static void printArray(int[] array, int n)
    {
        for (int i = 0; i < n; ++i)
        {
            System.out.printf("%d ", array[i]);
        }

        System.out.println();
    }

    static void zad1a(int[] array, int n)
    {
        int even = 0;
        int odd = 0;

        for (int i = 0; i < n; ++i)
        {
            if (array[i] % 2 == 0) ++even;
            else ++odd;
        }

        System.out.printf("Even: %d, Odd: %d", even, odd);
    }

    static void zad1b(int[] array, int n)
    {
        int pos = 0;
        int neg = 0;
        int zeros = 0;

        for (int i = 0; i < n; ++i)
        {
            if (array[i] > 0) ++pos;
            else if (array[i] < 0) ++neg;
            else ++zeros;
        }

        System.out.printf("Pos: %d, Neg: %d, Zeros: %d", pos, neg, zeros);
    }

    static void zad1c(int[] array, int n)
    {
        int value = Integer.MIN_VALUE;
        int count = 0;

        for (int i = 0; i < n; ++i)
        {
            if (array[i] > value)
            {
                value = array[i];
                count = 1;

                continue;
            }

            if (array[i] == value) ++count;
        }

        System.out.printf("Highest value: %d, Count: %d", value, count);
    }

    static void zad1d(int[] array, int n)
    {
        int posSum = 0;
        int negSum = 0;

        for (int i = 0; i < n; ++i)
        {
            if (array[i] > 0)
            {
                posSum += array[i];
            }
            else if (array[i] < 0)
            {
                negSum += array[i];
            }
        }

        System.out.printf("Sum of pos: %d, Sum of neg: %d", posSum, negSum);
    }

    static void zad1e(int[] array, int n)
    {
        int countHighest = 0;
        int count = 0;

        for (int i = 0; i < n; ++i)
        {
            if (array[i] < 1)
            {
                count = 0;
                continue;
            }

            ++count;

            if (count > countHighest)
            {
                countHighest = count;
            }
        }

        System.out.printf("Highest count of pos in row: %d", countHighest);
    }

    static void zad1f(int[] array, int n)
    {
        for (int i = 0; i < n; ++i)
        {
            if (array[i] < 0) array[i] = -1;
            else if (array[i] > 0) array[i] = 1;
        }

        printArray(array, n);
    }

    static void zad1g(int[] array, int n, Scanner s)
    {
        System.out.print("Gimmie left: ");
        int left = s.nextInt();

        System.out.print("Gimmie right: ");
        int right = s.nextInt();

        if (right < left || left < 1 || left >= n || right >= n)
        {
            System.out.println("Wrong numbers.");
            return;
        }

        int temp;

        while (left < right)
        {
            temp = array[left];
            array[left] = array[right];
            array[right] = temp;

            ++left;
            --right;
        }
    }

    static void zad3()
    {
        Random r = new Random();
        Scanner s = new Scanner(System.in);

        System.out.print("Gimmie m: ");
        int m = s.nextInt();

        System.out.print("Gimmie m: ");
        int n = s.nextInt();

        System.out.print("Gimmie m: ");
        int k = s.nextInt();

        if (m < 1 || n < 1 || k < 1 || m > 10 || n > 10 || k > 10)
        {
            System.out.println("Wrong numbers");
            return;
        }

        int sizeA = m * n;
        int sizeB = n * k;

        int[] matrixA = new int[sizeA];
        int[] matrixB = new int[sizeB];

        for (int i = 0; i < sizeA; ++i) matrixA[i] = r.nextInt(10);
        for (int i = 0; i < sizeB; ++i) matrixB[i] = r.nextInt(10);

        printMatrix(matrixA, m);
        printMatrix(matrixB, n);
    }

    static void printMatrix(int[] matrix, int columns)
    {
        System.out.println("Matrix:");

        for (int i = 0; i < matrix.length; ++i)
        {
            if (i > 0 && i % columns == 0) System.out.println();

            System.out.printf("%d ", matrix[i]);
        }

        System.out.println();
    }
}