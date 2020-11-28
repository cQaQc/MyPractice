package Lamda;

/**
 *
 * @author 柯神_
 * @date 2020-11-28 18:48:20
 * @Description  Lambda表达式,
 *                  演化：外部类 --> 静态内部类 --> 局部类 --> 匿名内部类（借助接口或父类实现）
 *                              --> lambda表达式【 （参数）-> { 方法体 } 】
 * @param
 * @return
*/
public class TestLambda {
    public static void main(String[] args) {

        //Lambda表达式
        Like l0 = (int a)->{
            System.out.println("I like Lambda!" + a);
        };
        l0.le(0);

        //简化参数类型
        Like l1 = (a)->{
            System.out.println("I like Lambda!" + a);
        };
        l1.le(1);

        //简化括号, 只有一个参数时
        Like l2 = a->{
            System.out.println("I like Lambda!" + a);
        };
        l2.le(2);

        //简化花括号, 只有一条语句时
        Like l3 = a->System.out.println("I like Lambda!" + a);
        l3.le(3);
    }
}

interface Like{
    void le(int a);
}
