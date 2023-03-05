/*Complete the method/function so that it converts dash/underscore delimited words into camel casing.
The first word within the output should be capitalized only if the original word was capitalized (known as Upper Camel Case,
also often referred to as Pascal case). The next words should be always capitalized.

        Examples
        "the-stealth-warrior" gets converted to "theStealthWarrior"
        "The_Stealth_Warrior" gets converted to "TheStealthWarrior"
*/


import java.util.Arrays;

public class StringToCamelCase {

    public static void main(String[] args) {
        toCamelCase("the-stealth-warrior");
        toCamelCase("The_Stealth_Warrior");
    }

    static String toCamelCase(String s) {
        boolean dashIsFound = false;
        boolean firstDashIsFound = false;
        String result = "";
        String tempString = "";
        for (int i = 0; i < s.length(); i++) {

            tempString = "" + s.charAt(i);

            if (s.charAt(i) == '-' | s.charAt(i) == '_') {
                dashIsFound = true;
            } else if (dashIsFound) {
                result = result + tempString.toUpperCase();
                dashIsFound = false;
            } else {
                result = result + tempString;
            }

        }
        System.out.println(result);
        return result;
    }

    static String toCamelCase1(String str) {
        String[] words = str.split("[-_]");
        return Arrays.stream(words, 1, words.length)
                .map(s -> s.substring(0, 1).toUpperCase() + s.substring(1))
                .reduce(words[0], String::concat);
    }
}

