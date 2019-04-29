package SimilarQuestions;

import java.util.*;


public class MiOJ8SimilarQuestions {
    public static void main(String args[]) {
        Scanner scan = new Scanner(System.in);
        String line;
        while (scan.hasNextLine()) {
            line = scan.nextLine().trim();
            // please write your code here
            int res = 0;
            String[] temp = line.split(",");
            int[] arr1 = new int[temp.length];

            for (int i = 0; i < temp.length; i++) {
                arr1[i] = Integer.valueOf(temp[i]);
            }

            int[] arr2 = Arrays.copyOf(arr1, arr1.length);
            Arrays.sort(arr2);

            Map<Integer, Integer> map = new HashMap<>();
            Set<Integer> set = new HashSet<>();
            for (int i = 0; i < arr1.length; i++) {
                if (arr1[i] != arr2[i]) {
                    map.put(arr2[i], i);
                }
            }

            Iterator<Map.Entry<Integer, Integer>> iter = map.entrySet().iterator();
            while (map.size() != 0) {
                Map.Entry<Integer, Integer> item = iter.next();
                Integer key = item.getKey();
                while (!set.contains(key)) {
                    set.add(key);
                    key = arr1[map.get(key)];

                }
                for (Integer k : set) {
                    map.remove(k);
                }
                res += set.size() - 1;
                set.clear();
            }

            System.out.println(res);
            // System.out.println("answer");
        }
    }
}
