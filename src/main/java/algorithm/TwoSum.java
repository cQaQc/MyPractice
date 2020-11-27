package algorithm;

import javax.sound.midi.Soundbank;
import java.util.*;

/**
 *作者: 柯神_
 *时间: 22:21
 *日期: 2020/10/22
 *User: 蜘蛛啊全是腿儿
 * 有一数组、目标值  --求数组中两个数的和为目标值的索引
**/
public class TwoSum {
//  1.1 暴力遍历找两个，最容易想到
    public static int[] twoIndex(int[] array, int target){
        int n = array.length;
        for(int i=0; i<n; ++i){
            for (int j=i+1; j<n; ++j){
                if(target == array[i]+array[j]){
                    return new int[]{i,j};
                }
            }
        }
    return new int[0];
    }

//  1.2 暴力遍历找所有
    public static Map<Integer, Integer> allIndex(int[] array, int target){
        int n = array.length;
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<n; ++i){
            for (int j=i+1; j<n; ++j){
                if(target == array[i]+array[j]){
                    map.put(i,j);
                }
            }
        }
        return map;
    }

//    2.哈希查找
    public static int[] hashSelect(int[] array, int target){
        int n = array.length;
        Map<Integer,Integer> map = new HashMap<>();
        for (int i=0; i<n; ++i){
            if (map.containsKey(target - array[i])){
                return new int[]{map.get(target - array[i]),i};
            }
            map.put(array[i],i);
        }
        return new int[0];
    }

    public static void main(String[] args) {

        int[] array = {1,2,3,3,4,5,6};
        int target = 100;

//      1.1 对应暴力遍历找两个，测试
        System.out.println("暴力遍历找两个:");
        for (int aa:twoIndex(array,target)
        ) {
            System.out.print(aa+",");
        }

//       1.2 对应暴力遍历，找所有
        System.out.println("\n暴力遍历，找所有:");
        Map<Integer,Integer> map = allIndex(array,target);
        Set<Map.Entry<Integer, Integer>> entries = map.entrySet();
        System.out.println(entries);

//        2.对应哈希查找，找两个
        System.out.println("哈希查找，找两个:");
        for (int aa:hashSelect(array,target)
        ) {
            System.out.print(aa+",");
        }

    }
}
