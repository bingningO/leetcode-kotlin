package date0809;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class test4 {

    public static void main(String[] args) throws IOException {
        Data data = new Data();
        int k, v;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            String input = br.readLine();
            if (input.equals("exit")) break;

            String[] params = input.split(" ");
            switch (params[0]) {
                case "add":
                    k = Integer.parseInt(params[1]);
                    v = Integer.parseInt(params[2]);
                    data.add(k, v);
                    break;
                case "get":
                    k = Integer.parseInt(params[1]);
                    System.out.println(data.get(k));
                    break;
                case "evict":
                    data.evict();
                    break;
                case "remove":
                    k = Integer.parseInt(params[1]);
                    System.out.println(data.remove(k));
                    break;
                case "exit":
                    return;
            }
        }
    }

    public static class Data {
        private Map<Integer, Integer> map = new HashMap<>();
        private List<Integer[]> list = new LinkedList<>();

        public void add(int k, int v) {
            list.forEach(e -> e[0]++);
            if (!map.containsKey(k)) {
                list.add(new Integer[]{0, k});
            } else {
                list.stream().filter(e -> e[1] == k).findFirst().get()[0] = 0;
            }
            map.put(k, v);
        }

        public int get(int k) {
            if (!map.containsKey(k)) return -1;
            list.forEach(e -> {
                if (e[1] == k) {
                    e[0] = 0;
                } else {
                    ++e[0];
                }
            });
            return map.get(k);
        }

        public int remove(int k) {
            if (!map.containsKey(k)) return -1;
            list.removeIf(e -> e[1] == k);
            return map.remove(k);
        }

        public void evict() {
            if (list.isEmpty()) return;
            Integer[] value = list.stream().max(Comparator.comparingInt(e -> e[0])).get();
            list.remove(value);
            map.remove(value[1]);
        }
    }


}
