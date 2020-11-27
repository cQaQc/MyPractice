package proxy;

public class Client {
    public static void main(String[] args) {
//        具体角色
        Host host = new Host();
//        代理角色
        ProxyInvocationHandler handler = new ProxyInvocationHandler();
//        设置被代理的对象
        handler.setTarget(host);
//        动态生成代理类
        IHost proxy = (IHost) handler.getProxy();
        proxy.say();

    }
}
