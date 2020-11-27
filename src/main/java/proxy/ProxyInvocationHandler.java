package proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 *作者: 柯神_
 *时间: 14:00
 *日期: 2020/11/5
 *User: 蜘蛛啊全是腿儿
 *
 * 会用到这个类，自动生成代理类
**/
public class ProxyInvocationHandler implements InvocationHandler {
//被代理类的接口
    private Object target;

    public void setTarget(Object target) {
        this.target = target;
    }
//Proxy生成动态代理对象，返回代理对象
    public Object getProxy(){
        return Proxy.newProxyInstance(this.getClass().getClassLoader(),
                target.getClass().getInterfaces(),this);
    }

//处理代理实例，返回结果
    @Override
    public Object invoke(Object proxy, Method method,
                         Object[] args) throws Throwable {
    kanF();
        Object invoke = method.invoke(target, args);
    heT();
        return invoke;
    }


    public void kanF(){
        System.out.println("带领客户看房。。。");
    }

    public void heT(){
        System.out.println("成功签订租赁合同！！！");
    }

}
