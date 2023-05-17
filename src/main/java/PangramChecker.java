import java.util.ArrayList;
import java.util.List;

/*
A pangram is a sentence that contains every single letter of the alphabet at least once. For example, the sentence "The quick brown fox jumps over the lazy dog" is a pangram, because it uses the letters A-Z at least once (case is irrelevant).

Given a string, detect whether or not it is a pangram. Return True if it is, False if not. Ignore numbers and punctuation.
 */
public class PangramChecker {
    public static void main(String[] args) {
        System.out.println(check("The quick brown fox jumps over the lazy dog."));
        System.out.println(check("The quik brown fox jumps over the lazy dog."));
    }

    public static boolean check(String sentence) {
        char[] alphabet = "abcdefghijklmnopqrstuvwxyz".toCharArray();
        sentence = sentence.toLowerCase();
        for (char c : sentence.toCharArray()) {
            for (int i = 0; i < alphabet.length; i++) {
                if (alphabet[i] == c) {
                    alphabet[i] = ' ';
                }
            }
        }

        for (int i = 0; i < alphabet.length; i++) {
            if (alphabet[i] != ' ') {
                return false;
            }
        }
        return true;
    }

    public class PangramChecker1 {
        public boolean check(String sentence){
            for (char c = 'a'; c<='z'; c++)
                if (!sentence.toLowerCase().contains("" + c))
                    return false;
            return true;

        }
    }
}


