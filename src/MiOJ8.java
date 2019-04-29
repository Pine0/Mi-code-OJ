import java.util.*;


public class MiOJ8 {
    public static void main(String args[]) {
        Scanner scan = new Scanner(System.in);
        String line;
        while (scan.hasNextLine()) {
            line = scan.nextLine().trim();
            // please write your code here
            int res = 0, index = 0;
            int[] arr1 = new int[line.length()/2 + 1];

            for (String item : line.split(",")) {
                arr1[index] = Integer.valueOf(item);
                index++;
            }

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


            System.out.println(res);
            // System.out.println("answer");
        }
    }
}
