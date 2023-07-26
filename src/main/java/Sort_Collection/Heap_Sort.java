package Sort_Collection;

public class Heap_Sort {
    /*
     * @author 林英杰
     * @since JDK 版本 1.8++
     * @Method buildMaxHeapL：构建最大堆  HeadAdjust：调整堆  heap_sort：堆排序
     * @param int[] arr：待排序数组  int n：待排序数组的长度  int index：当前根节点的下标
     * @return  void
     */
    //将以零为开始下标的数组看作是一棵二叉树，则首个非叶子结点的下标为 (n - 1)/2 - 1
    void buildMaxHeap(int[] arr,int n){
        //从第一个非叶子结点开始，由下至上进行大根堆的调整
        for (int i = (n - 1)/2 - 1;i >=0;i--)
            HeadAdjust(arr,i,n);
    }

    //调整堆操作
    //根元素不断下降的过程
    void HeadAdjust(int[] arr,int root,int n){
        //暂存根节点元素
        int rootData = arr[root];
        //进行大根堆调整
        for (int i = 2*root + 1;i < n;i = 2*i + 1){
            //得到叶子结点中较大的那一个
            //i < n-1 确保结点存在右孩子
            if (i < n-1 && arr[i] < arr[i+1])
                i++;
            //如果根节点元素比最大的孩子结点还要大，则已经符合大根堆的要求，无需调整
            if (rootData > arr[i])
                break;
            else {
                //将较大值赋值给根节点原本的位置（index）
                arr[root] = arr[i];
                //记录原根节点的新位置
                //还不能直接赋值，原因是先前结点元素的交换可能导致当前大根堆的性质被破坏，需要再次进行调整
                root = i;
            }
        }
        //将原根节点的值赋值给最终得到的位置
        arr[root] = rootData;
    }

    //堆排序
    void heap_sort(int[] arr,int n){
        //初始构造大根堆
        buildMaxHeap(arr,n);
        //排序 n 个元素需要进行 n-1 次循环
        for (int i = 0;i < n - 1;i++){
            //互换 根元素（最大元素）和 堆底元素
            int temp = arr[0];
            arr[0] = arr[n-1-i];
            arr[n-1-i] = temp;
            //重新对堆进行调整
            HeadAdjust(arr,0,n-i-1);
        }
    }


}
