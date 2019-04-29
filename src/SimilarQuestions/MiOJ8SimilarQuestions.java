package SimilarQuestions;

import java.util.*;

/**
 * 类似题目描述
 *
 * 给出一个无序数列，每次只能交换两个元素，求将原数列变成递增数
 * 列的最少交换次数。 如：数列：4,2,3,1，交换4和1后变成：1,2,
 * 3,4。总共交换1次。
 */
public class MiOJ8SimilarQuestions {
    public static void main(String args[]) {
        Scanner scan = new Scanner(System.in);
        String line;
        while (scan.hasNextLine()) {
            line = scan.nextLine().trim();
            // please write your code here

            //将输入的字符串转为数组
            int res = 0;
            String[] temp = line.split(",");
            int[] arr1 = new int[temp.length];
            for (int i = 0; i < temp.length; i++) {
                arr1[i] = Integer.valueOf(temp[i]);
            }

            //将arr1排序 并赋值给aar2
            int[] arr2 = Arrays.copyOf(arr1, arr1.length);
            Arrays.sort(arr2);

            //创建一个字典用于存需要交换的键值对，key为需要交换的元素值，value为需要将key放到下标为value的地方
            Map<Integer, Integer> map = new HashMap<>();
            Set<Integer> set = new HashSet<>();
            for (int i = 0; i < arr1.length; i++) {
                if (arr1[i] != arr2[i]) {
                    map.put(arr2[i], i);
                }
            }

            /**
             * 遍历这个字典，取出交换集合元素数。
             * 交换集合举例：
             * 例如 4,1,2,3 中的交换集合元素数为4，因为这四个元素每一个位置都要变。
             * 例如 5,2,4,1,3 中的交换集合元素数也为4，因为只有5,4,1,3这四个元素需要改变位置
             */
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

            //输出结果
            System.out.println(res);

            // System.out.println("answer");
        }
    }
}
