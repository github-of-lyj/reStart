package Sort_Collection;

import java.util.Arrays;

public class Quick_Sort {
    /*
     * @author 林英杰
     * @since JDK 版本 1.8++
     * @Method
     * @param arr:待排序数组 start:数组开始位置（从零开始） end：排序数组结束位置（直到 arr.length - 1 结束）
     * @return
     * @Address
     * @TitleName
     */
    void quick_sort(int[] arr, int start, int end){
        if (start >= end)
            return;
        int left = start,right = end;
        int key = arr[left];
        while(left < right){
            while (left < right && arr[right] >= key)
                right--;
            arr[left] = arr[right];
            while (left < right && arr[left] <= key)
                left++;
            arr[right] = arr[left];
        }
        arr[left] = key;
        quick_sort(arr,start,left - 1);
        quick_sort(arr,left + 1, end);
    }
}
