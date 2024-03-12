import java.util.*;


public class ObservedPin {

    public static void main(String[] args) {
        getPINs("159");
    }

    public static List<String> getPINs(String observed) {

        int digitsNumber = observed.length();
        List<Integer> digitsList = new ArrayList<>();
        List<List<String>> combineList = new ArrayList<>();

        for (char c : observed.toCharArray()) {
            digitsList.add(Character.getNumericValue(c));
            combineList.add(getNeighbours(Character.getNumericValue(c)));
        }

        System.out.println(combineList);
        List<String> resultStringList = new ArrayList<>();
        resultStringList = enumeration(combineList, new ArrayList<>(), 0, "");
        System.out.println(resultStringList);
        return resultStringList;
    }

    public static List<String> enumeration(List<List<String>> startList, List<String> resultList, int level, String s) {

        for (int i = 0; i < startList.get(level).size(); i++) {
            String tempS = s;

            if (level < startList.size() - 1) {
                tempS = tempS.concat(startList.get(level).get(i));
                enumeration(startList, resultList, level + 1, tempS);
            }
            if (level == startList.size() - 1) {
                for (String s1 : startList.get(level)) {
                    resultList.add(tempS.concat(s1));
                }
                return resultList;
            }
        }
        return resultList;
    }

    public static List<String> getNeighbours(Integer digit) {
        int[][] matrix = new int[][]{
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9},
                {-1, 0, -1}
        };
        int ii = 0;
        int jj = 0;

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == digit) {
                    ii = i;
                    jj = j;
                    break;
                }
                System.out.println(matrix[i][j]);
                System.out.println(digit);
            }
            if (matrix[ii][jj] == digit) break;
        }
        List<String> resultList = new ArrayList<>();
        resultList.add(String.valueOf(matrix[ii][jj]));

        if (jj - 1 >= 0 && !(matrix[ii][jj - 1] == -1)) resultList.add(String.valueOf(matrix[ii][jj - 1]));
        if (ii - 1 >= 0 && !(matrix[ii - 1][jj] == -1)) resultList.add(String.valueOf(matrix[ii - 1][jj]));
        if (jj + 1 < matrix[0].length && !(matrix[ii][jj + 1] == -1))
            resultList.add(String.valueOf(matrix[ii][jj + 1]));
        if (ii + 1 < matrix.length && !(matrix[ii + 1][jj] == -1)) resultList.add(String.valueOf(matrix[ii + 1][jj]));

        return resultList;
    }


}

class ObservedPin1 {

    private static final Map<Character, String> ADJACENTS = new HashMap<Character, String>() {{
        put('1', "124");
        put('2', "2135");
        put('3', "326");
        put('4', "4157");
        put('5', "54268");
        put('6', "6953");
        put('7', "748");
        put('8', "87590");
        put('9', "986");
        put('0', "08");
    }};

    public static void main(String[] args) {
        getPINs("159");
    }

    public static List<String> getPINs(String observed) {

        List<String> ans = Arrays.asList("");

        // для каждого элемента входной строки, переведённой в массив
        for (char c : observed.toCharArray()) {

            List<String> tmp = new ArrayList<String>();
            // перебор массива значений мапы (числа и его соседей) по соответстующему ключу
            for (char cc : ADJACENTS.get(c).toCharArray()) {
                // перебор элементов из результирующего листа
                for (String s : ans) tmp.add(s + cc);
            }
            ans = tmp;
        }
        return ans;
    }

}
