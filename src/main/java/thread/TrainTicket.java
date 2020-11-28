package thread;

/**
 *
 * @author 柯神_
 * @date 2020-11-28 15:45:54
 * @Description  多线程操作同一个对象
 *                      多个线程操作同一个资源，线程不安全，数据紊乱
 *
*/
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

    public static void main(String[] args) {

        //多线程操作同一对象
        TrainTicket ticket = new TrainTicket();

        new Thread(ticket,"小明").start();
        new Thread(ticket,"的老师").start();
        new Thread(ticket,"老老老贺").start();
    }
}
