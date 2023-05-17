public class Narcissistic {
    public static void main(String[] args) {

        System.out.println(isNarcissistic(153));
        System.out.println(isNarcissistic(4561553));
    }

    public static boolean isNarcissistic(int number) {

        int numberOfDigits = (int) Math.log10(number)+1;
        int result = 0;
        int tempNumber = number;

        for (int i = 0; i < numberOfDigits; i++) {
            result += (int) Math.pow(tempNumber % 10, numberOfDigits);
            tempNumber = tempNumber / 10;
        }

        if (result==number) {
            return true;
        }else
            return false;

    }
}
