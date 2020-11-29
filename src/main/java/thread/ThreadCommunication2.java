package thread;


import lombok.SneakyThrows;

/**
 * 二、信号灯法：通过标志位来实现
 */
public class ThreadCommunication2 {
    public static void main(String[] args) {

        TV tv = new TV();
        Player player = new Player(tv);
        Watcher watcher = new Watcher(tv);

        new Thread(player).start();
        new Thread(watcher).start();

    }
}

//生产者 ==>演员录制
class Player implements Runnable{
    TV tv;

    public Player(TV tv) {
        this.tv = tv;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            if (i % 2 == 0) {
                this.tv.play("录制快本中。。。");
            } else {
                this.tv.play("新闻联播录制...");
            }
        }
    }
}

//消费者 ==>观众
class Watcher implements Runnable{
    TV tv;

    public Watcher(TV tv) {
        this.tv = tv;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            tv.watch();
        }
    }
}

//产品 ==>小视频节目
class TV{
    private String name;
    private boolean flag = true;   //标志位

    /**
     *  表演录制：观众等待
     */
    @SneakyThrows
    public synchronized void play(String name){
        if (!flag){
            wait();
        }

        System.out.println("演员表演了" + name);
        this.notify();
        this.name = name;
        this.flag = !this.flag;
    }

    /**
     * 观众观看：演员等待
     */
    @SneakyThrows
    public synchronized void watch(){
        if (flag){
            this.wait();
        }

        System.out.println("观众观看=======>" + name);
        this.notifyAll();
        this.flag = !this.flag;
    }
}
