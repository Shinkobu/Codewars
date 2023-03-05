import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class DescendingOrder {
    public static void main(String[] args) {

        sortDesc(42145);
        sortDesc(145263);
        sortDesc(123456789);
    }

    public static int sortDesc(int num) {
        ArrayList<Integer> myAL = new ArrayList<>();
        Integer result = 0;

        do{
            myAL.add(num % 10);
            num /= 10;
        } while  (num > 0);

        Collections.sort(myAL);
        Collections.reverse(myAL);

        for (int i = 0; i < myAL.size(); i++) {
            result = result*10 + myAL.get(i);
        }
        System.out.println(result);
        return result;
    }

    public class DescendingOrder1 {
        public static int sortDesc(final int num) {
            String[] array = String.valueOf(num).split("");
            Arrays.sort(array, Collections.reverseOrder());
            return Integer.valueOf(String.join("", array));
        }
    }
}
