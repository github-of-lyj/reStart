package Sort_Collection;

public class Shell_Sort {
    /*
     * @author 林英杰
     * @since JDK 版本 1.8++
     * @Method shell_sort：希尔排序
     * @param int[] arr：待排序数组  int n：待排序数组的长度
     * @return 已排序数组
     */
    void shell_sort(int[] arr,int n){
        //初始增量
        int increase;
        //初始增量设置为长度的一半，每轮循环过后变为原来的一半，直到增量为 1，即可得到有序数组
        for (increase = n/2;increase >= 1;increase=increase/2){
            //根据不同的增量情况对相应的分块数据进行直接插入排序
            for (int i = increase + 1;i < n;i++){
                //待插入数据
                int data = arr[i];
                if (arr[i] < arr[i - increase]){
                    //待插入数据的位置
                    int index;
                    //查找相应的插入位置
                    //从下标为 i 处向前查找
                    //这里可能存在这样的疑问：所进行排序的分块数组仅仅是以 increase 为分量构造的数组的一部分
                    //事实上，同一数组后续的数据会在 i 值增加到对应值的时候进行排序
                    //可以认为将一个完整的插入排序分为了多个部分在不同的循环中（i值不同）完成
                    for(index = i - increase;index >=0 && data < arr[index]; index-=increase)
                        //对元素进行移动
                        arr[index + increase] = arr[index];
                    //将元素插入到对应的位置
                    arr[index + increase] = data;
                }
            }
        }
    }
}
