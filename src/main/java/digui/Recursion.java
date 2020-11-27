package digui;

import javax.xml.crypto.Data;
import java.sql.Time;
import java.time.LocalDateTime;

/**
 *作者: 柯神_
 *时间: 13:55
 *日期: 2020/11/8
 *User: 蜘蛛啊全是腿儿
 *
 * 递归算法,函数自己调用自己
**/
public class Recursion {

    //1.斐波那契数列,输出第n项（an = an_2 + an_1）,n<=39
    public int fBNQ(int n){
        if (n==0){
            return 0;
        }
        if (n==1){
            return 1;
        }
        return fBNQ(n-2) + fBNQ(n-1);
    }

    //1.1.当n较大时，运行速度比较慢，可以使用迭代去以空间换时间
    public int fBNQ1(int n){
        if (n<2){
            return n;
        }
        int a = 0;
        int b = 1;
        int result = 0;
        for (int i=1; i<n; i++){
            result = a + b;
            a = b;
            b = result;
        }
        return result;
    }

    //普通计算阶乘
    public int ff(int n){
        int res = 1;
        for(int i=2;i<=n;i++){
            res = res * i;
        }
        return res;
    }

    //递归计算n的阶乘
    public int f(int n){
        if (n<=2){
            return n;
        }

        System.out.println(n);

        return n*f(n-1);
    }









    public static void main(String[] args) {
        Recursion r = new Recursion();
/*        System.out.println(LocalDateTime.now());
        System.out.println(r.fBNQ(39));
        System.out.println(LocalDateTime.now());

        System.out.println(LocalDateTime.now());
        System.out.println(r.fBNQ1(39));
        System.out.println(LocalDateTime.now());*/

        System.out.println(LocalDateTime.now());
        System.out.println(r.ff(10));
        System.out.println(LocalDateTime.now());
    }
}
