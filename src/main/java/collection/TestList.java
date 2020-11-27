package collection;

import java.util.*;

import static java.lang.Thread.sleep;

public class TestList {
    public static void main(String[] args) {
//        list集合
        List c = new ArrayList();
        c.add(100);
        c.add("aaaaaa");
        c.add(999);
        c.add(0000);
//        数组
        int[] a = new int[3];
        a[0]=1;
        a[1]=2;
        a[2]=3;
        System.out.println(a);
        try {
            sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(c);
        /*ListIterator iterator = c.listIterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }*/

    }
}
