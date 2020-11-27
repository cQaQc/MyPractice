package proxy;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
    public void test1(){
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        IUser user = (IUser) context.getBean("user");
        user.add();
        user.delete();
        user.update();
        user.query();
    }

    public static void main(String[] args) {
        new Test().test1();
    }
}
