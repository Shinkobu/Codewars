import java.util.*;

class Permutations {

    public static void main(String[] args) {
        System.out.println(singlePermutations("abcd"));
    }

    public static List<String> singlePermutations(String s) {

        List<String> digitList = new ArrayList<>();
        List<List<String>> complexList = new ArrayList<>();
        char[] startArray = s.toCharArray();

        System.out.println(s.substring(0,2));
        System.out.println(s.substring(0,3));
        System.out.println(s.substring(1,2));
        System.out.println(s.substring(1,3));
        System.out.println(s.substring(2,3));
        System.out.println(s.substring(3,3));
        System.out.println(s.substring(3,4));

//      encode to digits
        for (int i = 0; i < startArray.length; i++) {
            digitList.add(String.valueOf(i));
        }

        for (Character c : startArray) {
            complexList.add(digitList);
        }
        System.out.println(digitList);

//      get all mutations
        List<String> mutationsList = ObservedPin.enumeration(complexList, new ArrayList<>(), 0, "");
        System.out.println(mutationsList);

//      filter duplicates
        List<String> tempList = new ArrayList<>();
        for (String s1 : mutationsList) {
            Set<Character> tempSet = new HashSet<>();
            String tempS = "";
            for (Character c : s1.toCharArray()) {
                if (tempSet.add(c)) tempS = tempS.concat(String.valueOf(c));
            }
            if (tempS.length() == s.length()) tempList.add(tempS);
        }
        System.out.println(tempList);

        List<String> resultList = new ArrayList<>();

        // decode

        Set<String> tempSet = new HashSet<>();
        for (String ss : tempList) {
            String resultString = "";
            for (Character c : ss.toCharArray()) {
                Integer index = Integer.parseInt(String.valueOf(c));
                resultString = resultString.concat(String.valueOf(startArray[index]));
            }

            if (tempSet.add(resultString)) resultList.add(resultString);
        }

        return resultList;
    }
}

class Permutations1 {
    public static void main(String[] args) {
        singlePermutations("abc");
    }

    public static void generate(String seq, String out, List<String> list){
        if (seq.isEmpty()){
            if (!list.contains(out))
                list.add(out);
        }
        else
            for(int i=0; i < seq.length(); i++)
                generate(remove(seq,i), out+seq.charAt(i), list);
    }

    public static String remove(String str, int idx){
        return str.substring(0, idx)+str.substring(idx+1);
    }

    public static List<String> singlePermutations(String s) {
        List<String> list = new ArrayList<>();
        for(int i=0; i < s.length(); i++){
            generate(remove(s,i), ""+s.charAt(i), list);
        }
        return list;
    }
}