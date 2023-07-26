package Sort_Collection;

import java.util.Arrays;

public class Test {
    public static void main(String[] args) {
        int[] arr = {5,4,3,2,1};
        Directly_Insert directly_insert = new Directly_Insert();
        Shell_Sort shell_sort = new Shell_Sort();
        Bubble_Sort bubble_sort = new Bubble_Sort();
        Simple_Select_Sort simple_select_sort = new Simple_Select_Sort();
        Merge_Sort merge_sort = new Merge_Sort();
        merge_sort.merge_sort(arr,0,arr.length-1);
//        simple_select_sort.select_sort(arr,arr.length);
//        bubble_sort.bubble_sort(arr,arr.length);
//        shell_sort.shell_sort(arr,arr.length);
//        directly_insert.directly_insert_brevity(arr,arr.length);
        System.out.println(Arrays.toString(arr));
    }
}
