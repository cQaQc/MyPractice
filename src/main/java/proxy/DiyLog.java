package proxy;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

//自定义切面，是一个类
@Aspect   //表明当前类是一个切面
public class DiyLog {
    @Before("execution(* proxy.User.*(..))")
    public void before(){
        System.out.println("======方法执行前=======");
    }
    @After("execution(* proxy.User.*(..))")
    public void after(){
        System.out.println("======方法执行后=======");
    }
}
