package TwoPoint;


class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
        next = null;
    }
}

public class Linked_List_Cycle_II {
    /*
     * @author 林英杰
     * @since JDK 版本 1.8++
     * @Method detectCycle:查找循环结点
     * @param ListNode head：头结点
     * @return ListNode result 循环结点
     * @Address https://leetcode.cn/problems/linked-list-cycle-ii/
     * @TitleName 142. 环形链表 II
     */
    public ListNode detectCycle(ListNode head) {
        //快慢指针
        if(head == null)
            return null;
        ListNode low = head;
        ListNode fast = head;
        //null说明已经到了终点，直接认为无环
        if(head.next != null){
            low = head.next;
            fast = low.next;
        }
        else
            return null;
        //没有第三个结点的情况，即只有两个结点且无环
        if(fast == null)
            return null;
        //判断是否存在环
        while(fast != null && fast != low){
            if(fast.next != null)
                fast = fast.next.next;
            else
                return null;
            low = low.next;
        }
        //确定存在环，将快速指针再次设为头结点
        fast = head;
        //当快速指针和慢速指针相等时即为所要查找的点的位置
        //因为此时必然存在环，因此不可能出现空指针的情况
        while(fast != low){
            fast = fast.next;
            low = low.next;
        }
        return fast;
    }
}
