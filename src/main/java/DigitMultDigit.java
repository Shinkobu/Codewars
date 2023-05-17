import java.util.stream.Collectors;

/*Welcome. In this kata, you are asked to square every digit of a number and concatenate them.

        For example, if we run 9119 through the function, 811181 will come out, because 92 is 81 and 12 is 1. (81-1-1-81)

        Example #2: An input of 765 will/should return 493625 because 72 is 49, 62 is 36, and 52 is 25. (49-36-25)
*/
public class DigitMultDigit {
    public static void main(String[] args) {

        System.out.println(squareDigits(0));
    }

    public static int squareDigits(int n) {
        int myTempDigit = 0;
        String tempString = "";

        if (n==0) return 0;

        while (n>0) {
            myTempDigit = n % 10;
            n = (n - myTempDigit)/10;

            tempString = (String.valueOf(myTempDigit*myTempDigit)).concat(tempString);
//            System.out.println(tempString);

        }
        return Integer.parseInt(tempString);
    }

    public int squareDigits1(int n) {
        return Integer.parseInt(String.valueOf(n)
                .chars()
                .map(i -> Integer.parseInt(String.valueOf((char) i)))
                .map(i -> i * i)
                .mapToObj(String::valueOf)
                .collect(Collectors.joining("")));
    }
}
