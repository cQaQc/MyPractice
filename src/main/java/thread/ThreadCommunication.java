package thread;


/**
 *
 * @author 柯神_
 * @date 2020-11-29 17:17:17
 * @Description 线程间通信，
 *                  生产者消费者问题
 *                         解决方式：一、管程法
 *                                  二、信号灯法
*/
public class ThreadCommunication {
    public static void main(String[] args) {
        Buffer buffer = new Buffer();
        Producer producer = new Producer(buffer);
        Consumer consumer = new Consumer(buffer);

        new Thread(producer).start();
        new Thread(consumer).start();

    }
}

/**
 * 一、管程法
 */
//生产者
class Producer implements Runnable{
    Buffer buffer;

    public Producer(Buffer buffer) {
        this.buffer = buffer;
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            buffer.push(new Product(i));
            System.out.println("生产了" + i + "只鸡！");
        }
    }
}

//消费者
class Consumer implements Runnable{
    Buffer buffer;

    public Consumer(Buffer buffer) {
        this.buffer = buffer;
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println("消费了==>" + buffer.getP().id + "只鸡！");
        }
    }
}

//产品
class Product{
    int id;

    public Product(int id) {
        this.id = id;
    }
}

//缓冲区
class Buffer{

    //定义一个容器大小
    Product[] products = new Product[10];

    //容器计数器
    int count = 0;

    //1.生产者生产产品
    public synchronized void push(Product product){
        /**
         * 缓冲区满了，生产等待，通知消费
         */
        if (count == products.length - 1){
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        /**
         * 缓冲区未满，可以生产
         */
        products[count] = product;
        count++;

        /**
         * 有产品了
         * 通知消费者消费
         */
        this.notifyAll();
    }

    //2.消费者消费产品
    public synchronized Product getP(){
        /**
         * 缓冲区空了，等待消费，通知生产
         */
        if (count == 0){
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        /**
         * 缓冲区有产品，可以消费
         */
        count--;
        Product product = products[count];

        /**
         * 吃了，缓冲区没满了
         * 通知生产者生产
         */
        this.notifyAll();
        return product;
    }




}


