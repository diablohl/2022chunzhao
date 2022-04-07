package com.hl.chunzhao.yuanjing;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

class Mission {
    public static boolean flag=true; //默认开启
     BlockingQueue blockingQueue = null;
    static AtomicInteger atomicInteger = new AtomicInteger(); //作为消费的对象

    public Mission(BlockingQueue blockingQueue) {
        this.blockingQueue = blockingQueue;
    }

    public  void produce() throws InterruptedException {
        String s;
        while (flag) {
            s=String.valueOf(atomicInteger.getAndIncrement());
            boolean offer = false;
            try {
                offer = blockingQueue.offer(s, 6L, TimeUnit.SECONDS);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (offer) {
                System.out.println(Thread.currentThread().getName() + "生产成功" + s);
            } else {
                System.out.println(Thread.currentThread().getName() + "生产失败" + s);
            }
//            TimeUnit.SECONDS.sleep(1);
        }
        System.out.println("produce stop");
    }
    public  void custom() throws InterruptedException {
        String s=null;
        while (flag) {
            TimeUnit.SECONDS.sleep(2);

            try {
                s = (String) blockingQueue.poll(4L, TimeUnit.SECONDS);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (s == null) {
                flag = false;
                //poll方法4s内没取到数据就失败,结束返回
                System.out.println(Thread.currentThread().getName()+"消费失败"+s);
                return;
            }
            //否则成功
            System.out.println(Thread.currentThread().getName()+"消费成功"+s);
        }
    }
    public void stop(){
        flag = false; //停止系统
    }

}
class Test{
    public static void main(String[] args) throws InterruptedException {
        Mission mymission = new Mission(new ArrayBlockingQueue(10));
        ExecutorService service = Executors.newCachedThreadPool();
        Thread producer=new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    mymission.produce();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"producer");
        service.execute(producer);
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    mymission.custom();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"custumor").start();

        TimeUnit.SECONDS.sleep(30);

        mymission.stop();
        service.shutdown();
    }
}
