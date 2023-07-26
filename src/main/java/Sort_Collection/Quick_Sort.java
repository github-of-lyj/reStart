package Sort_Collection;

import java.util.Arrays;

public class Quick_Sort {
    /*
     * @author 林英杰
     * @since JDK 版本 1.8++
     * @Method
     * @param arr:待排序数组 start:数组开始位置（从零开始） end：排序数组结束位置（直到 arr.length - 1 结束）
     * @return void
     */
    void quick_sort(int[] arr, int start, int end){
        //排序的起始位置大于结束位置，直接结束
        if (start >= end)
            return;
        int left = start,right = end;
        //默认基准值为第一个元素
        int key = arr[left];
        //循环寻找基准值的位置
        while(left < right){
            //寻找小于基准值却在数组右方的元素
            while (left < right && arr[right] >= key)
                right--;
            //此时的 left 值已经被保存在 key 当中，不必担心元素丢失
            //同时相应 right 下标所指定的位置空出
            arr[left] = arr[right];
            //寻找大于基准值却在数组左方的元素
            while (left < right && arr[left] <= key)
                left++;
            //对先前空出的位置进行赋值
            arr[right] = arr[left];
        }
        //left、right均可，因为此时 left = right
        arr[left] = key;
        //递归进行排序
        quick_sort(arr,start,left - 1);
        quick_sort(arr,left + 1, end);
    }
}
