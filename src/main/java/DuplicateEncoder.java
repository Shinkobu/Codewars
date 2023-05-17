/*The goal of this exercise is to convert a string to a new string where each character
in the new string is "(" if that character appears only once in the original string, or ")"
if that character appears more than once in the original string. Ignore capitalization
when determining if a character is a duplicate.

        Examples
        "din"      =>  "((("
        "recede"   =>  "()()()"
        "Success"  =>  ")())())"
        "(( @"     =>  "))(("
*/

public class DuplicateEncoder {
    public static void main(String[] args) {
        encode("din");
        encode("recede");
        encode("Success");
        encode("(( @");
    }

    static String encode(String word) {
        String result = "";
        int dublicate = 0;
        for (int i = 0; i < word.length(); i++) {
            for (int j = 0; j < word.length(); j++) {
                if (Character.toLowerCase(word.charAt(i)) ==
                    Character.toLowerCase(word.charAt(j))) {
                    dublicate++;
                }
            }
            if (dublicate > 1) {
                result += ")";
            } else result += "(";
            dublicate = 0;
        }
        System.out.println(result);
        return result;
    }

    static String encode1(String word){
        word = word.toLowerCase();
        String result = "";
        for (int i = 0; i < word.length(); ++i) {
            char c = word.charAt(i);
            result += word.lastIndexOf(c) == word.indexOf(c) ? "(" : ")";
        }
        return result;
    }
}
