package reflect;

import lombok.Data;

import java.lang.annotation.*;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 *作者: 柯神_
 *时间: 10:52
 *日期: 2020/11/9
 *User: 蜘蛛啊全是腿儿
 *
 * 所有类型的class:
 **/
public class Reflect {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchFieldException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {

        Class<?> aClass = Class.forName("reflect.User");

//        通过过反射获取注解
        Annotation[] annotations = aClass.getDeclaredAnnotations();
        for (Annotation annotation: annotations) {
            System.out.println(annotation);
        }
//        通过过反射获取注解的值
        DIY diy = aClass.getDeclaredAnnotation(DIY.class);
        System.out.println(diy.value());
//        获得属性的注解
        Field name = aClass.getDeclaredField("name");
        DIYField diyField = name.getAnnotation(DIYField.class);
        System.out.println(diyField.value());

    }
}

@DIY("t_user")
@Data
class User{

    @DIYField("克尔克")
    private String name;
    @DIYField("99")
    private int age;
    @DIYField("ashdbjhaskgsauihb")
    public String sss;

    public User() {
    }

    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }
}


@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@interface DIY{
    String value();
}

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@interface DIYField{
    String value();
}


