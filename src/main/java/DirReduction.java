import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class DirReduction {

    public static void main(String[] args) {
//        System.out.println(Arrays.toString(dirReduc(new String[]{"NORTH", "SOUTH", "SOUTH", "EAST", "WEST", "NORTH", "WEST"})));
//        System.out.println(Arrays.toString(dirReduc(new String[]{"NORTH","SOUTH","SOUTH","EAST","WEST","NORTH"})));
        System.out.println(Arrays.toString(dirReduc1(new String[]{"NORTH", "SOUTH", "SOUTH", "EAST", "WEST", "NORTH", "WEST"})));
    }

    public static String[] dirReduc(String[] arr) {

        List<String> resultList = new ArrayList<>(Arrays.stream(arr).toList());

        int initialSize;
        int resultSize;

        do {
            initialSize = resultList.size();
            resultSize = resultList.size();
            String lastString = resultList.get(0);
            String currentString;
            for (int i = 1; i < resultList.size(); i++) {
                currentString = resultList.get(i);

                if (currentString.equals("NORTH") && lastString.equals("SOUTH") ||
                        currentString.equals("SOUTH") && lastString.equals("NORTH") ||
                        currentString.equals("EAST") && lastString.equals("WEST") ||
                        currentString.equals("WEST") && lastString.equals("EAST")) {
                    resultList.remove(i);
                    resultList.remove(i - 1);
                    resultSize = resultList.size();
                    break;
                }
                lastString = resultList.get(i);
            }
        } while (initialSize>resultSize && resultSize>0);


        return resultList.toArray(new String[0]);
    }


    public static String[] dirReduc1(String[] arr) {
        final Stack<String> stack = new Stack<>();

        for (final String direction : arr) {
            final String lastElement = stack.size() > 0 ? stack.lastElement() : null;

            switch(direction) {
                case "NORTH": if ("SOUTH".equals(lastElement)) { stack.pop(); } else { stack.push(direction); } break;
                case "SOUTH": if ("NORTH".equals(lastElement)) { stack.pop(); } else { stack.push(direction); } break;
                case "EAST":  if ("WEST".equals(lastElement)) { stack.pop(); } else { stack.push(direction); } break;
                case "WEST":  if ("EAST".equals(lastElement)) { stack.pop(); } else { stack.push(direction); } break;
            }
        }
        return stack.stream().toArray(String[]::new);
    }

}



