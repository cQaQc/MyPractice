package listNode;
public class ReverseNode {
    public static void main(String[] args) {
        Node head  = new Node(0);
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);

        head.setNext(node1);
        node1.setNext(node2);
        node2.setNext(node3);
        // 打印反转前的链表
        Node h = head;
        System.out.println("原链表:");
        while (null != h) {
            System.out.print(h.getData() + " ");
            h = h.getNext();
        }
        // 调用反转方法
        // head = reverse1(head);
        Node rehead = revers1(head);
        System.out.println("\n*********两极反转*********");
        System.out.println("反转后的链表:");
        // 打印反转后的结果
        while (null != rehead) {
            System.out.print(rehead.getData() + " ");
            rehead = rehead.getNext();
        }
    }






    /**
     * 遍历，将当前节点的下一个节点缓存后更改当前节点指针
     */
    public static Node reverse2(Node head) {
        if (head == null)
            return null;
        Node pre = head;// 上一结点
        Node cur = head.getNext();// 当前结点
        Node tmp;// 临时结点，用于保存当前结点的指针域（即下一结点）
        while (cur != null) {// 当前结点为null，说明位于尾结点
            tmp = cur.getNext();
            cur.setNext(pre);// 反转指针域的指向
            // 指针往下移动
            pre = cur;
            cur = tmp;
        }
        // 最后将原链表的头节点的指针域置为null，还回新链表的头结点，即原链表的尾结点
        head.setNext(null);
        return pre;
    }

    //递归反转单链表
    public static Node revers1(Node head){
        //链表为空、或者只有一个节点时，直接返回原链表
        if (head==null||head.getNext()==null){
            return head;
        }

        Node newNode = revers1(head.getNext());//递归，直到找到尾结点
        System.out.println(newNode);
        head.getNext().setNext(head); //当前节点的指针指向上一个节点
        head.setNext(null); //断开原来的指针
        return newNode;//返回原链表的尾节点，也就是新链表的头节点
    }


}






/**
 *作者: 柯神_
 *时间: 13:58
 *日期: 2020/10/24
 *User: 蜘蛛啊全是腿儿
**/

class Node {
    private int Data;// 数据域
    private Node Next;// 指针域

    public Node(int Data) {
        // super();
        this.Data = Data;
    }

    public int getData() {
        return Data;
    }

    public void setData(int Data) {
        this.Data = Data;
    }

    public Node getNext() {
        return Next;
    }

    public void setNext(Node Next) {
        this.Next = Next;
    }

    @Override
    public String toString() {
        return "Node{" +
                "Data=" + Data +
                ", Next=" + Next +
                '}';
    }
}