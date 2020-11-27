package algorithm;
/**
 *作者: 柯神_
 *时间: 13:54
 *日期: 2020/10/25
 *User: 蜘蛛啊全是腿儿
 *两链表求和，返回一个新链表，考虑进位问题
**/
class ListNode{
    int val;
    ListNode next;
    ListNode(int val){
        this.val = val;
    }
}

public class TwoNode {

    public static ListNode twoNode(ListNode l1, ListNode l2){
        ListNode pre = new ListNode(0);
        ListNode cur = pre;
        int carry = 0;

        while (l1 != null || l2 != null){
            int x = l1 == null? 0 : l1.val;
            int y = l2 == null? 0 : l2.val;
            int sum = x + y + carry;

            carry = sum / 10;
            sum = sum % 10;
            cur.next = new ListNode(sum);
            cur = cur.next;

            if(l1 != null){
                l1 = l1.next;
            }
            if(l2 != null){
                l2 = l2.next;
            }
        }
        if (carry == 1){
            cur.next = new ListNode(carry);
        }
        return pre.next;
    }

    public static void main(String[] args) {

        ListNode l1 = new ListNode(2);
        ListNode l2 = new ListNode(3);
        l1.next = l2;
        ListNode l3 = new ListNode(4);
        l2.next = l3;
        ListNode l4 = new ListNode(5);
        l3.next = l4;
        l4.next = null;

        ListNode ll1 = new ListNode(1);
        ListNode ll2 = new ListNode(1);
        ll1.next = ll2;
        ListNode ll3 = new ListNode(1);
        ll2.next = ll3;
        ListNode ll4 = new ListNode(5);
        ll3.next = ll4;
        ll4.next = null;

        ListNode l = twoNode(l1,ll1);
            while (l!=null){
                System.out.print(l.val + "—>");
                l = l.next;
            }
    }
}
