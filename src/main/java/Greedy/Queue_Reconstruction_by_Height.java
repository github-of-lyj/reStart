package Greedy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class Queue_Reconstruction_by_Height {
    /*
     * @author 林英杰
     * @since JDK 版本 1.8++
     * @Method reconstructQueue
     * @param int[][] people 初始数据
     * @return queue 最终数组
     */
    public static int[][] reconstructQueue(int[][] people) {
        int[][] queue = new int[people.length][];
        ArrayList<int[]> Queue = new ArrayList<>();
        //对初始数组进行多级排序，按照 第一个元素降序，第二个元素升序进行 排列
        Arrays.sort(people, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o2[0] - o1[0] == 0)
                    return o1[1] - o2[1];
                return o2[0] - o1[0];
            }
        });
        //构造结果集合
        int index = 0;
        //插入时判断当前索引是否大于 当前变量的第一个元素
        while (index != people.length){
            //若大于，将数据插入至尾部
            if (index <= people[index][1])
                Queue.add(people[index]);
            //若小于，则将数据插入至 Queue 中第 people[index][1] 个元素的前面
            else
                Queue.add(people[index][1],people[index]);
            index++;
        }
        //构造完成后赋值给 queue
        for (int i = 0;i < Queue.size();i++)
            queue[i] = Queue.get(i);
        return queue;
    }

    public static void main(String[] args) {
        int[][] people = {{7,0},{4,4},{7,1},{5,2},{6,1},{5,0}};
        int[][] ints = reconstructQueue(people);
        System.out.println(Arrays.deepToString(ints));
    }
}
