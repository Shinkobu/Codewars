/*На входе имеем строку определённого формата, нужно её преобразовать по правилам:
a2[bc] - > abcbc
2[a3[b]] - > 2[abbb] - > abbbabbb
2[a3[bcd]zz] -> abcdbcdbcdzz abcdbcdbcdzz
 */

public class a2bc {
    public static void main(String[] args) {

        System.out.println(strFormat("a2[bc]"));
        System.out.println(strFormat("2[a3[b]]"));
        System.out.println(strFormat("2[a3[bcd]zz]"));

        String test = "0123456";
        System.out.println(test.substring(3, 3));
    }

    public static String strFormat(String myString) {
        int mult;
        String result = "";

        for (int i = 0; i < myString.length(); i++) {

            char c = myString.charAt(i);

            if (Character.isDigit(c) && myString.charAt(i + 1) == '[') {
                mult = Integer.parseInt(String.valueOf(myString.charAt(i)));
                int lastCharIndex = myString.length() - 1;
                char cc = myString.charAt(lastCharIndex);
                String tailString = "";

                while (cc != ']') {
                    tailString = cc + tailString;
                    lastCharIndex--;
                    cc = myString.charAt(lastCharIndex);
                }

                for (int m = 1; m <= mult; m++) {
                    result += strFormat(myString.substring(i + 2, lastCharIndex));
                }
                // последний символ и последний символ
                result += tailString;
                break;

            } else {
                result += myString.charAt(i);
            }
        }
        return result;
    }
}
