import java.lang.Math;
import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Podaj n: ");

        int n = scanner.nextInt();
        float[] numbers = new float[n];

        for (int i = 0; i < n; ++i)
        {
            System.out.printf("Podaj a%d:%n", i);
            numbers[i] = scanner.nextFloat();
        }

        zad_a(n, numbers);
    }

    static void zad_a(int n, float[] numbers)
    {
        float result = 0;

        for (int i = 0; i < n; ++i)
        {
            result += numbers[i];
        }

        System.out.printf("Result: %f", result);
    }

    static void zad_b(int n, float[] numbers)
    {
        float result = 1;

        for (int i = 0; i < n; ++i)
        {
            result *= numbers[i];
        }

        System.out.printf("Result: %f", result);
    }

    static void zad_c(int n, float[] numbers)
    {
        float result = 0;

        for (int i = 0; i < n; ++i)
        {
            result += Math.abs(numbers[i]);
        }

        System.out.printf("Result: %f", result);
    }

    static void zad_d(int n, float[] numbers)
    {
        float result = 0;

        for (int i = 0; i < n; ++i)
        {
            result += Math.sqrt(Math.abs(numbers[i]));
        }

        System.out.printf("Result: %f", result);
    }

    static void zad_e(int n, float[] numbers)
    {
        float result = 1;

        for (int i = 0; i < n; ++i)
        {
            result *= Math.abs(numbers[i]);
        }

        System.out.printf("Result: %f", result);
    }

    static void zad_f(int n, float[] numbers)
    {
        float result = 0;

        for (int i = 0; i < n; ++i)
        {
            result += (numbers[i] * numbers[i]);
        }

        System.out.printf("Result: %f", result);
    }

    static void zad_g(int n, float[] numbers)
    {
        float result = 0;
        float result2 = 1;

        for (int i = 0; i < n; ++i)
        {
            result += numbers[i];
            result2 *= numbers[i];
        }

        System.out.printf("Result: %f", result + result2);
    }

    static void zad_h(int n, float[] numbers)
    {
        float result = 0;
        float sign = 1;

        for (int i = 0; i < n; ++i)
        {
            result += sign * numbers[i];
            sign = -sign;
        }

        System.out.printf("Result: %f", result);
    }

    static void zad_i(int n, float[] numbers)
    {
        float result = 0;
        float sign = 1;

        for (int i = 0; i < n; ++i)
        {
            result += (sign * numbers[i]) / factorial(i + 1);
            sign = -sign;
        }

        System.out.printf("Result: %f", result);
    }

    static int factorial(int n)
    {
        int result = 1;

        for (int i = 1; i < n + 1; ++i)
        {
            result *= i;
        }

        return result;
    }

    static void zad_j(int n, float[] numbers)
    {
        for (int i = 1; i < n; ++i)
        {
            System.out.printf("%f ", numbers[i]);
        }

        System.out.print(numbers[0]);
    }

    static void zad_a2(int n, float[] numbers)
    {
        int result = 0;

        for (int i = 0; i < n; ++i)
        {
            if (numbers[i] % 2 == 1) ++result;
        }

        System.out.printf("Result: %d", result);
    }

    static void zad_b2(int n, float[] numbers)
    {
        int result = 0;

        for (int i = 0; i < n; ++i)
        {
            if (numbers[i] % 3 == 0 && numbers[i] % 5 != 0) ++result;
        }

        System.out.printf("Result: %d", result);
    }

    static void zad_c2(int n, float[] numbers)
    {
        int result = 0;

        for (int i = 0; i < n; ++i)
        {
            if (Math.sqrt(numbers[i]) % 2 == 0) ++result;
        }

        System.out.printf("Result: %d", result);
    }

    static void zad_d2(int n, float[] numbers)
    {
        int result = 0;

        for (int i = 1; i < n - 1; ++i)
        {
            if (isLessThanNeighboringAverage(numbers[i], numbers[i - 1], numbers[i + 1]))
            {
                ++result;
            }
        }

        System.out.printf("Result: %d", result);
    }

    static boolean isLessThanNeighboringAverage(float a, float left, float right)
    {
        return a < (left + right) / 2f;
    }

    static void zad_e2(int n, float[] numbers)
    {
        int result = 0;

        for (int i = 0; i < n; ++i)
        {
            if (isMoreThanTwoPoweredAndLessThanFactorial(numbers[i], i))
            {
                ++result;
            }
        }

        System.out.printf("Result: %d", result);
    }

    static boolean isMoreThanTwoPoweredAndLessThanFactorial(float a, int k)
    {
        return powInt(2, k) < a && a < factorial(k);
    }

    // tylko dla pozytywnych poteng
    static float powInt(float n, int p)
    {
        float result = n;

        for (int i = 1; i < p; ++i)
        {
            result *= n;
        }

        return result;
    }

    static void zad_f2(int n, float[] numbers)
    {
        int result = 0;

        for (int i = 1; i < n; i += 2)
        {
            if (numbers[i] % 2 == 0) ++result;
        }

        System.out.printf("Result: %d", result);
    }

    static void zad_g2(int n, float[] numbers)
    {
        int result = 0;

        for (int i = 0; i < n; ++i)
        {
            if (numbers[i] % 2 == 1 && numbers[i] < 0) ++result;
        }

        System.out.printf("Result: %d", result);
    }

    static void zad_h2(int n, float[] numbers)
    {
        int result = 0;

        for (int i = 0; i < n; ++i)
        {
            if (isAbsValueLessThanSquare(numbers[i], i)) ++result;
        }

        System.out.printf("Result: %d", result);
    }

    static boolean isAbsValueLessThanSquare(float a, int k)
    {
        return Math.abs(a) < powInt(k, 2);
    }

    static void zad_22(int n, float[] numbers)
    {
        float result = 0;

        for (int i = 0; i < n; ++i)
        {
            if (numbers[i] > 0) result += numbers[i];
        }

        System.out.printf("Result: %f", result * 2);
    }

    static void zad_23(int n, float[] numbers)
    {
        int positive = 0;
        int negative = 0;
        int zeros = 0;

        for (int i = 0; i < n; ++i)
        {
            if (numbers[i] == 0) ++zeros;
            else if (numbers[i] < 0) ++negative;
            else ++positive;
        }

        System.out.printf("Positives: %d, Negatives: %d, Zeros: %d", positive, negative, zeros);
    }

    static void zad_24(int n, float[] numbers)
    {
        float smallest = Float.MAX_VALUE;
        float biggest = Float.MIN_VALUE;

        for (int i = 0; i < n; ++i)
        {
            if (numbers[i] > biggest) biggest = numbers[i];
            if (numbers[i] < smallest) smallest = numbers[i];
        }

        System.out.printf("Biggest: %f, Smallest: %f", biggest, smallest);
    }

    static void zad_25(int n, float[] numbers)
    {
        int result = 0;
        
        for (int i = 1; i < n; ++i)
        {
            if (numbers[i - 1] > 0 && numbers[i] > 0) ++result;
        }

        System.out.printf("Result: %d", result);
    }
}