package thread;

import lombok.SneakyThrows;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 *
 * @author 柯神_
 * @date 2020-11-28 15:45:54
 * @Description  多线程操作同一个对象
 *                      多个线程操作同一个资源，线程不安全，数据紊乱
 *
 *      线程不安全的三个例子：买票，取钱，集合
*/


// 1. 买票问题
public class TrainTicket implements Runnable {

    private int tickets = 10;

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(30);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()
                    + "拿到了第==>" + tickets-- + "<==张票");
            if (tickets <= 0) {
                break;
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {

        /**
         *  买票问题
         */
        //多线程操作同一对象
/*
        TrainTicket ticket = new TrainTicket();

        new Thread(ticket,"小明").start();
        new Thread(ticket,"的老师").start();
        new Thread(ticket,"老老老贺").start();
*/

        /**
         * 取钱问题
         */
        Account account = new Account("小王",999);

        Take take0 = new Take(account,500,"自己");
        Take take1 = new Take(account,500,"其他人");
        take0.start();
        take1.start();

        /**
         * 3.集合
         *    两个或多个元素在同一时间被添加到了同一位置
         */
/*        List<String> list = new ArrayList<>();
//CopyOnWriteArrayList list = new CopyOnWriteArrayList();线程安全
        for (int i = 0; i < 1000; i++){
            new Thread(()->{
                list.add(Thread.currentThread().getName());
            }).start();
        }
        Thread.sleep(1000);
        System.out.println(list.size());*/

    }
}


//  2. 取钱问题
class Account{
    String name;
    int money;

    public Account(String name, int money) {
        this.name = name;
        this.money = money;
    }
}
class Take extends Thread{

    Account account;
    int take;
    int sum;

    public Take(Account account, int take, String name) {
        super(name);
        this.account = account;
        this.take = take;

    }

    //取钱操作
    @SneakyThrows
    @Override
    public void run() {

        synchronized (account){
            if (account.money - take < 0) {
                System.out.println(account.name + "余额不足");
                return;
            }
            Thread.sleep(1000);
            account.money = account.money - take;
            sum = sum + take;

            System.out.println(account.name + "余额：" + account.money);
            System.out.println(Thread.currentThread().getName() + "手里的钱：" + sum);
        } }
}

