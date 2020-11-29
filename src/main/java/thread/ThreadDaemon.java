package thread;


/**
 *
 * @author 柯神_
 * @date 2020-11-29 12:03:02
 * @Description 测试守护线程
*/
public class ThreadDaemon {
    public static void main(String[] args) {
        ThreadUser user = new ThreadUser();
        ThreadDaem daem = new ThreadDaem();

        new Thread(user).start();   //用户线程启动

        Thread d = new Thread(daem);
        d.setDaemon(true);        //设置守护线程
        d.start();               //启动线程
    }
}

class ThreadDaem implements Runnable{
    @Override
    public void run() {
        while (true){
            System.out.println("上帝保佑你！");
        }
    }
}

class ThreadUser implements Runnable{

    @Override
    public void run() {
        for(int i=0;i<100;i++){
            System.out.println("哈哈");
        }
        System.out.println("goodBye world!");
    }
}
