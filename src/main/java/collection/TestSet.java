package collection;

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;

public class TestSet {
    public static void main(String[] args) {
        Collection c = new HashSet();
        c.add(new Student(1001, "张三"));
        c.add(new Student(1002, "李四"));
        c.add(new Student(1003, "王五")); //10行
        c.add(new Student(1003, "王五"));
        c.add(new Student(1003, "王五"));
        c.add(new Student(1003, "王五"));
        c.add(new Student(1003, "王五1")); //14行

        Iterator<HashSet> i = c.iterator();
        while (i.hasNext()) {
            System.out.println(i.next());
            i.remove();
        }
        for (Object cc : c
             ) {
            System.out.println(cc+"123");
        }
    }
}
class Student {
    private int num;
    private String name;

    public Student() {
    }
    public Student(int num, String name) {
        this.num = num;
        this.name = name;
    }
    
    public String toString() {
        return "学号: " + this.num + ",  姓名: " + name;
    }

    public boolean equals(Object o){
        Student s = (Student)o;
        return this.num==s.num && this.name.equals(s.name);
    }
    public int hashCode() {
        return this.name.hashCode();
    }
}