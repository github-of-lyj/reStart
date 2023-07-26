package Sort_Collection;

public class Merge_Sort {
    /*
     * @author 林英杰
     * @since JDK 版本 1.8++
     * @Method merge；将 start 到 center 和 center+1 到 end 的有序数组进行合并  merge_sort：归并排序
     * @param int[] arr：待排序数组  start、center、end：表示待排序数组的开头、中间、结尾
     * @return void
     */
    void merge(int[] arr,int start,int center,int end){
        //用于进行合并的临时数组
        int[] temp = new int[end+1];
        //数组元素复制
        for (int i = start;i <= end;i++)
            temp[i] = arr[i];
        //待排序的初始下标
        int index;
        //两数组的起始下标
        int left,right;
        for (left = start,right = center+1,index = left;left <= center && right <= end;index++){
            //二者之间较小的元素率先赋值
            if (temp[left] <= temp[right])
                arr[index] = temp[left++];
            else
                arr[index] = temp[right++];
        }
        //出现一个数组全部赋值完毕的情况，此时将另外一个数组剩余的元素全部赋值给 arr
        while (left <= center)
            arr[index++] = temp[left++];
        while (right <= end)
            arr[index++] = temp[right++];
    }
    //归并排序过程
    void merge_sort(int[] arr,int start,int end){
        //当 start > end 时，直接返回
        if (start < end){
            int center = (start + end) / 2;
            merge_sort(arr,start,center);
            merge_sort(arr,center + 1, end);
            merge(arr,start,center,end);
        }
    }
}
