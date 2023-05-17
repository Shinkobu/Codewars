import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PickPeaks {
    public static void main(String[] args) {

        int[] myArr = {1,2,3,2,1};
        int[] myArr1 = {1,2,3,2,3,1};
        int[] myArr3 = {1,2,3,4,4,4,3,3,1};
        int[] myArr4 = {1,2,3,4,4,4,4};
        System.out.println(getPeaks(myArr));
        System.out.println(getPeaks(myArr1));
        System.out.println(getPeaks(myArr3));
        System.out.println(getPeaks(myArr4));
    }

    public static Map<String, List<Integer>> getPeaks(int[] arr) {

        Map<String, List<Integer>> myMap = new HashMap<>();

        List<Integer> posArrayList = new ArrayList<>();
        List<Integer> peaksArrayList = new ArrayList<>();
        boolean plateausCheck = false;
        int plateausStartPos = 0;
        int plateausStartPeak = 0;

        for (int i = 1; i < arr.length - 1; i++) {

            if ((arr[i] > arr[i-1]) && (arr[i] > arr[i+1])){
                posArrayList.add(i);
                peaksArrayList.add(arr[i]);
                plateausCheck = false;
                continue;
            }

            if ((arr[i] > arr[i-1]) && (arr[i] == arr[i+1])){
                plateausCheck = true;
                plateausStartPos = i;
                plateausStartPeak = arr[i];
                continue;
            }

            if (plateausCheck){
                if ((arr[i] == arr[i-1]) && (arr[i] == arr[i+1])){
                    continue;
                }
                if ((arr[i] == arr[i-1]) && (arr[i] > arr[i+1])){
                    posArrayList.add(plateausStartPos);
                    peaksArrayList.add(plateausStartPeak);
                    plateausCheck = false;
                }
                if ((arr[i] == arr[i-1]) && (arr[i] < arr[i+1])){
                    plateausCheck = false;
                }
            }


        }

        myMap.put("pos", posArrayList);
        myMap.put("peaks", peaksArrayList);

        return myMap;
    }
}
