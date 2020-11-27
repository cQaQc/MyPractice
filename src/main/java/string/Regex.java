package string;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


/**
 *
 * @author 柯神_
 * @date 2020-11-27 19:00:28
 * @Description 正则表达式：    1.字符串的匹配
 *                              2.字符串的切割
 *                                  3.字符串的替换
 * @param
 * @return
*/
public class Regex {
    public static void main(String[] args) {

        //1.匹配字符串
        String str0 = "i love you";
        String regex0 = "[a-zA-Z]{1,4}";

        Pattern p = Pattern.compile(regex0);
        Matcher matcher = p.matcher(str0);

        while (matcher.find()){
            System.out.println(matcher.group());
        }


        String str = "IamGoodBoy";
        String regex = "[A-Z]";

        System.out.println(str.matches(regex));

        //2.切割字符串
         String[] split = str.split(regex);
        for (String s1:split
             ) {
            System.out.println(s1);
        }

        //3.字符串替换
        String s = str.replaceAll(regex, "---");
        System.out.println(s);



    }
}
