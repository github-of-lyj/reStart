package Sort_Collection;

public class Bubble_Sort {
    /*
     * @author 林英杰
     * @since JDK 版本 1.8++
     * @Method bubble_sort：冒泡排序
     * @param int[] arr：待排序数组  int n：待排序数组的长度
     * @return void
     */
    void bubble_sort(int[] arr, int n){
        for (int i = 0;i < n-1;i++)
            for (int j = 0;j < n-1-i;j++)
                if (arr[j] > arr[j+1]){
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
    }
}
