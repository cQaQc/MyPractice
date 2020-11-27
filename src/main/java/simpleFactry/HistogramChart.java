package simpleFactry;
/**
 *作者: 柯神_
 *时间: 20:36
 *日期: 2020/11/1
 *User: 蜘蛛啊全是腿儿
 *
 * 具体产品类---柱状图类
**/
public class HistogramChart implements Chart {

    public HistogramChart(){
        System.out.println("创建柱状图。。。");
    }

    @Override
    public void display() {
        System.out.println("显示柱状图！");
    }
}
