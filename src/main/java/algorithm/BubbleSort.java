package algorithm;

/**
 *作者: 柯神_
 *时间: 22:18
 *日期: 2020/10/22
 *User: 蜘蛛啊全是腿儿
 * 冒泡排序，数组（长度为n）中两两比较，把最大的数往后移
 * n-1次外循环，n-1-i次0内循环
**/
public class BubbleSort {

    public static int[] bubbling(int[] array){
        int n = array.length;
        for (int i=0; i<n-1; ++i){
            for (int j=0; j<n-1-i; ++j){
                if (array[j] > array[j+1]){
                    int temporary = array[j];
                        array[j] = array[j+1];
                        array[j+1] = temporary;
                }
            }
        }
        return array;
    }

    public static void main(String[] args) {
        int[] a = {0,3,6,4,6,42,2,422};
        for (int aa:bubbling(a)
             ) {
            System.out.print(aa+",");
        }
        System.out.println("\n"+a);
    }
}