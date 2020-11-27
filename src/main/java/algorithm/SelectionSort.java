package algorithm;

import java.util.Arrays;

/**
 *作者: 柯神_
 *时间: 14:23
 *日期: 2020/10/25
 *User: 蜘蛛啊全是腿儿
 * 选择排序： 在未排序的序列中，找到最大的元素，放在排序序列的起始位置，重复找到最大元素放在已排序序列的末尾
**/

public class SelectionSort {

    public static int[] selectSort(int[] array){
        int n = array.length;
        for (int i=0; i<n; ++i){
            int max = i;
            for(int j=i+1; j<n; ++j){
                if (array[j] > array[max]){
                    max = j;
                }
            }
            int temp = array[max];
                array[max] = array[i];
                array[i] = temp;
        }
        /*for (int i = 0; i < n; i++){
            int min = i;
            for(int j = i; j < n; j++){
                if (array[min] > array[j]){
                    min = j;
                }
                int tmp = array[min];
                    array[min] = array[i];
                    array[i] = tmp;
            }
        }*/
        return array;
    }

    public static void main(String[] args) {
        int[] array = {6,5,4,3,1,2};
        selectSort(array);
        int i=0;
        for (int a:array
             ) {
            System.out.print(a + "-->");
        }
        System.out.println();
        Arrays.sort(array);
        for (int a:array
        ) {
            System.out.print(a + "-->");
        }
    }
}
