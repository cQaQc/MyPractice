package thread;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 *
 * @author 柯神_
 * @date 2020-11-29 20:21:10
 * @Description
 *                  测试线程池
*/
public class PoolTest {
    public static void main(String[] args) {
        //创建线程服务，线程池，参数为线程池的大小
        ExecutorService service = Executors.newFixedThreadPool(10);
        service.execute(new MyPool());
        service.execute(new MyPool());
        service.execute(new MyPool());
        service.execute(new MyPool());

        service.shutdown();
    }
}

class MyPool implements Runnable {

    @Override
    public void run() {
            System.out.println(Thread.currentThread().getName());
    }
}
