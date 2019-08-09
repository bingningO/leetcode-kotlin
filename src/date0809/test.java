package date0809;
import java.util.HashMap;

public class test {
    public static void main(String[] args) {
        System.out.println(findDuplicate("aabbcdc"));
        System.out.println(findDuplicate(""));
        System.out.println(findDuplicate("abcaaa"));
        System.out.println(findDuplicate("forfor"));
    }

    private static int findDuplicate(String input) {
        HashMap<Character, Integer> map = new HashMap<>();
        int dupCount = 0;
        for (int i = 0 ; i< input.length(); i++) {
            char a = input.charAt(i);
            if (map.containsKey(a)) {
                map.put(a, map.get(a) + 1);
            } else {
                map.put(a, 1);
            }
        }
        for (char a : map.keySet()) {
            if (map.get(a) > 1) {
                dupCount++;
            }
        }
        return dupCount;
    }
}
