package Sort_Collection;

public class Simple_Select_Sort {
    /*
     * @author 林英杰
     * @since JDK 版本 1.8++
     * @Method select_sort
     * @param int[] arr：待排序数组  int n：待排序数组的长度
     * @return void
     */
    void select_sort(int[] arr,int n){
        //n 个元素进行 n-1 趟简单选择排序后有序
        for (int i = 0;i < n - 1;i++){
            //假设最小值为当前趟排序的第一个元素
            int Min = i;
            //循环寻找实际上最小的元素
            for (int j = i+1;j < n;j++){
                if (arr[j] < arr[Min])
                    Min = j;
            }
            //进行相应的交换操作
            int temp = arr[i];
            arr[i] = arr[Min];
            arr[Min] = temp;
        }
    }
}
