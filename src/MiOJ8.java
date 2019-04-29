import java.util.*;

/**
 * 题目描述
 *
 * 给出一个无序数列，每次只能交换相邻两个元素，求将原数列变成递增数
 * 列的最少交换次数。 如：数列：2,3,1，交换3和1后变成：2,1,3；交
 * 换1和2之后变成：1,2,3。总共交换2次。
 */

public class MiOJ8 {

    public static void main(String args[]) {
        Scanner scan = new Scanner(System.in);
        String line;
        while (scan.hasNextLine()) {
            line = scan.nextLine().trim();
            // please write your code here

            //将输入的字符串转为数组
            int res = 0, index = 0;
            int[] arr1 = new int[line.length()/2 + 1];
            for (String item : line.split(",")) {
                arr1[index] = Integer.valueOf(item);
                index++;
            }

            //冒泡计算swap次数
            for (int i = arr1.length - 1; i >= 0; i--) {
                for (int j = 0; j < i; j++) {
                    if (arr1[j] > arr1[j + 1]) {
                        int temp = arr1[j];
                        arr1[j] = arr1[j + 1];
                        arr1[j + 1] = temp;
                        res++;
                    }
                }
            }

            //输出结果
            System.out.println(res);

            // System.out.println("answer");
        }
    }
}
