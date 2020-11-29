package thread;

import lombok.SneakyThrows;

import java.util.concurrent.locks.ReentrantLock;

/**
 *
 * @author 柯神_
 * @date 2020-11-29 14:49:40
 * @Description  测试Lock,使用了Lock后，线程排队一个一个来
*/
public class LockTest {
    public static void main(String[] args) {
        LockT lockT = new LockT();
        new Thread(lockT,"1").start();
        new Thread(lockT,"22").start();
        new Thread(lockT,"333").start();
    }
}

class LockT implements Runnable {

    private int tic = 10;

    private ReentrantLock lock = new ReentrantLock();

    @SneakyThrows
    @Override
    public void run() {
        while (true) {
            try {
                lock.lock();

                if (tic > 0){
                    Thread.sleep(1000);
                    System.out.println(Thread.currentThread().getName() + "==>" + tic--);
                }else return;
            }finally {
                lock.unlock();
            }

        }
    }
}
