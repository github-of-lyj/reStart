package Sort_Collection;

import java.util.Arrays;

public class Test {
    public static void main(String[] args) {
        int[] arr = {5,4,3,2,1};
        Directly_Insert directly_insert = new Directly_Insert();
        Shell_Sort shell_sort = new Shell_Sort();
        shell_sort.shell_sort(arr,arr.length);
//        directly_insert.directly_insert_brevity(arr,arr.length);
        System.out.println(Arrays.toString(arr));
    }
}
