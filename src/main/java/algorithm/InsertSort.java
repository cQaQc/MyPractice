package algorithm;
/**
 *作者: 柯神_
 *时间: 15:55
 *日期: 2020/10/25
 *User: 蜘蛛啊全是腿儿
 * 插入排序，依次将后面的元素取出，与前面按大小插入后的元素进行比较，然后插入。
**/

public class InsertSort {

    public static int[] insertSort(int[] array){
        int current = 0;
        for (int i = 0; i<array.length-1; ++i){
            current = array[i+1];
            int pre = i;
            while (pre>=0 && current<array[pre]){
                array[pre+1] = array[pre];
                pre--;
            }
            array[pre+1] = current;
        }
        return array;
    }


    public static void main(String[] args) {
        int[] array = {1,3,5,4,465,654,2};
        insertSort(array);
        for (int a:array
        ) {
            System.out.print(a);
        }
    }
}
