//Complete the function that accepts a string parameter, and reverses each word in the string.
//        All spaces in the string should be retained.
//
//        "This is an example!" ==> "sihT si na !elpmaxe"
//        "double  spaces"      ==> "elbuod  secaps"

import java.util.Arrays;
import java.util.stream.Collectors;

public class ReverseWord {
    public static void main(String[] args) {
//    reverseWords("This is an example!");
//    reverseWords("double  spaces");
    reverseWords("   ");
    }

    public static String reverseWords(final String original)
    {
        String [] myStringArray = original.split(" ");
        System.out.println(Arrays.toString(myStringArray));
        String result = "";

        if (myStringArray.length == 0){
            return original;
        }

        for (int i = 0; i < myStringArray.length ; i++) {
            result += new StringBuilder(myStringArray[i]).reverse().toString();
            if (!(i== myStringArray.length-1)) {result += " ";}
        }

        System.out.println(result);
        return result;
    }

    public static String reverseWords1(final String original)
    {
        String[] array = original.split(" ");

        if(array.length == 0)
            return original;


        int i = 0;
        for(String string : array){
            array[i] = new StringBuilder(string).reverse().toString();
            i++;
        }

        return String.join(" ",array);
    }

    public static String reverseWords2(final String original)
    {
        return Arrays.stream(original.split("(?<=\\s)|(?=\\s+)"))
                .map(str -> new StringBuilder(str).reverse().toString())
                .collect(Collectors.joining());
    }


}
