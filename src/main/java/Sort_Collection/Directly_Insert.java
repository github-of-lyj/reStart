package Sort_Collection;

public class Directly_Insert {
    /*
     * @author 林英杰
     * @since JDK 版本 1.8++
     * @Method directly_insert：直接插入排序
     * @param int[] arr：待排序数组 int n：待排序数组长度
     * @return void
     */

    void directly_insert(int[] arr, int n){
        //n个元素进行 n-1 次排序后有序
        for (int i = 0;i < n - 1;i++){
            //待插入元素，初始认为 arr[0]有序
            int data = arr[i+1];
            //待插入位置
            int index;
            for (index = i;index >= 0; index--)
                if (data < arr[index])
                    arr[index+1] = arr[index];
                else
                    //查找到相应位置，直接停止循环
                    break;
            //插入元素
            arr[index+1] = data;
        }
    }

    void directly_insert_brevity(int[] arr, int n){
        //n个元素进行 n-1 次排序后有序
        for (int i = 0;i < n - 1;i++){
            //待插入元素，初始认为 arr[0]有序
            int data = arr[i+1];
            //待插入位置
            int index;
            //简洁写法，比较清爽
            for (index = i;index >= 0 && data < arr[index];index--)
                    arr[index+1] = arr[index];
            //插入元素
            arr[index+1] = data;
        }
    }
}
