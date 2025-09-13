import java.sql.SQLOutput;
import java.time.LocalDate;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReadWriteCounter {
     private final ReadWriteLock lock = new ReentrantReadWriteLock();
     Lock readLock =   lock.readLock();
     Lock writeLock =   lock.writeLock();

    public int count=0;
    public void increment(){
        writeLock.lock();
        try {
            count++;
            Thread.sleep(50);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            writeLock.unlock();
        }
    }
    public int getCount(){
        readLock.lock();
        try {
            return count;
        }finally {
            readLock.unlock();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        ReadWriteCounter counter = new ReadWriteCounter();
        Runnable readTask = ()->{
            for(int i = 0; i<10 ;i++) {
                System.out.println(Thread.currentThread().getName() + " : " + counter.getCount());
            }
        };
        Runnable writeTask = ()->{

            for(int i = 0; i<10 ;i++){
                System.out.println(Thread.currentThread().getName() +  " Incrementing ");
                counter.increment();
            }
        };
        Thread writeThread = new Thread(writeTask);
        Thread readThread1 = new Thread(readTask);
        Thread readThread2 = new Thread(readTask);
        writeThread.start();
        readThread1.start();
        readThread2.start();

        writeThread.join();
        readThread1.join();
        readThread2.join();
    }
}
