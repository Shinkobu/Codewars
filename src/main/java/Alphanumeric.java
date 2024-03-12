/*In this example you have to validate if a user input string is alphanumeric. The given string is not nil/null/NULL/None, so you don't have to check that.

The string has the following conditions to be alphanumeric:

At least one character ("" is not valid)
Allowed characters are uppercase / lowercase latin letters and digits from 0 to 9
No whitespaces / underscore

 */

public class Alphanumeric {
    public static void main(String[] args) {
        System.out.println(alphanumeric("Invalid character"));
    }

    public static boolean alphanumeric(String s) {
        char[] myCharArray = s.toCharArray();
        if (myCharArray.length==0) return false;

        for (char c : myCharArray) {

            if (!((c >= 'a' && c <= 'z') ||
                    (c >= 'A' && c <= 'Z') ||
                    (c >= '0' && c <= '9'))) {
                return false;
            }
        }
        return true;
    }


        public static boolean alphanumeric1(String s) {
            return s.matches("[A-Za-z0-9]+");
        }


}


