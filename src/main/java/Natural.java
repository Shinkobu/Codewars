/*

If we list all the natural numbers below 10 that are multiples of 3 or 5, we get 3, 5, 6 and 9.
The sum of these multiples is 23.


Finish the solution so that it returns the sum of all the multiples of 3 or 5 below the number passed in. Additionally,
if the number is negative, return 0 (for languages that do have them).

Note: If the number is a multiple of both 3 and 5, only count it once.
*/

import java.util.stream.IntStream;

public class Natural {
    public static void main(String[] args) {

        System.out.println(solution(10));

    }

    public static int solution(int number) {
        if (number < 0) return 0;
        int result = 0;
        for (int i = 1; i < number; i++) {
            if (i % 3 == 0 || i % 5 == 0) {
                result += i;
            }

        }
        return result;
    }

    public int solution1(int number) {
        return IntStream.range(0, number)
                .filter(n -> (n % 3 == 0) || (n % 5 == 0))
                .sum();
    }
}

