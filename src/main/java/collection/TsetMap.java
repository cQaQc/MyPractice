package collection;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

//Map集合遍历键值对方式

//键值对方式：即通过集合中每个键值对(Entry)对象，获取键值对(Entry)对象中的键与值。
//         1.获取Map集合中，所有的(Entry)对象以Set集合形式返回。
//              Set<map.Entry<String,String>> entrySet = map.entrySet()
//         2.遍历包含键值对(Entry)对象的Set集合，得到每一个键值对(Entry)对象
//              foreach Entry<string,string> entry : entryset
//         3.通过键值对(Entry)对象，获取Entry对象中的键与值。
public class TsetMap {
    public static void main(String[] args) {

        //创建Map对象
        Map<String,String> map = new HashMap<String, String>();

        //给map中添加元素
        map.put("邓超", "孙俪");
        map.put("李晨", "范冰冰");
        map.put("刘德华", "柳岩");

        //获取Map中的所有key与value的对应关系
        Set<Map.Entry<String, String>> entrySet = map.entrySet();

        /*Iterator it = entrySet.iterator();
        while(it.hasNext()){
            System.out.println(it.next());
        }*/
        System.out.println(entrySet);
        for (Map.Entry<String, String> entry : entrySet) {
            System.out.println(entry);
            System.out.print("entry.getKey = "+entry.getKey());
            System.out.println("entry.getValue = "+entry.getValue());

        }


    }
}
