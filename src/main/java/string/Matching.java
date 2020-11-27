package string;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

//字符串匹配
public class Matching {

    public static void main(String[] args) {
        String parent = "abkkabkkabbab";
        String child = "ab";
        Matching m = new Matching();
        System.out.println("throughIndex(): " + m.throughIndex(parent,child));
        System.out.println("throughPattern(): " + m.throughPattern(parent,child));
        System.out.println("throughSplit(): " + m.throughSplit(parent,child));
    }

//    1.通过String类的indexOf（）方法，从指定的索引处开始查找
    public int throughIndex(String parent, String child){
        int count = 0;
        int start = 0;
        while(parent.indexOf(child,start) != -1){
            start = parent.indexOf(child,start) + child.length();
            count++;
        }
        return count;
    }

//    2.通过正则表达式,主要的两类Pattern、Matcher
public int throughPattern(String parent,String child) {
    int count = 0;
    Pattern p = Pattern.compile(child);
    Matcher m = p.matcher(parent);
    while (m.find()){
        count++;
    }

    return count;
    }

//    3.通过String类的split（）方法根据给定的正则表达式拆分字符串
public int throughSplit(String parent,String child){
    int count = 0;

    String[] array = parent.split(child);
    int i = parent.length() - child.length();

    if (parent.indexOf(child,i)!=-1){
        count = array.length;
    }
    else count = array.length-1;
    return count;
    }
}
