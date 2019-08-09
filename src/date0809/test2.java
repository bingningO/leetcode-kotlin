package date0809;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class test2 {
    public static void main(String[] args) {
        System.out.println(maxMultiple("3,1,2,5,4"));
        System.out.println(maxMultiple(""));
        System.out.println(maxMultiple("-1,1,2,4,0,1"));
        System.out.println(maxMultiple("-1,4,1,1,-2,1,0"));
    }

    private static int maxMultiple(String input) {
        List<Integer> inputList = new ArrayList<>();
        for (String a : input.split(",")) {
            if (a == null || a.equals("")) continue;
            inputList.add(Integer.parseInt(a));
        }

        if (inputList.size() < 3) return -1;

        Collections.sort(inputList);

        int size = inputList.size();
        int max = inputList.get(size - 1) * inputList.get(size - 2) * inputList.get(size - 3);

        if (inputList.get(0) < 0 && inputList.get(1) < 0) {
            int maxOther = inputList.get(size - 1) * inputList.get(0) * inputList.get(1);
            return Math.max(max, maxOther);
        } else {
            return max;
        }
    }
}
