import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Test11 {
    public static Lock lock = new ReentrantLock();
    public static void main(String[] args)  {
        Runnable even = () -> {


                    for (int i = 1; i < 20; i = i + 2) {

                            System.out.println(i);
//                            lock.unlock();

                        Thread.yield();

                    }

        };
        Runnable odd = () -> {


                    for (int i = 2; i < 20; i = i + 2) {
//                        if (lock.tryLock(100, TimeUnit.MILLISECONDS)) {
                            System.out.println(i);
//                            lock.unlock();
//                            Thread.sleep(50);
                            Thread.yield();
//                        }
                    }




        };
        Thread t1 = new Thread(even);
        Thread t2 = new Thread(odd);
        t1.start();
        t2.start();


    }
}
