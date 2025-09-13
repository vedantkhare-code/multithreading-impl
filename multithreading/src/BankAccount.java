import java.time.LocalDate;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class BankAccount {
    Lock lock =new ReentrantLock();
    private int balance = 100;
    public  void withdraw(int amount) {
        System.out.println(Thread.currentThread().getName() + " is waiting to withdraw");
        try {
            if(lock.tryLock(10000, TimeUnit.MILLISECONDS)) {
                try {
                    if (balance >= amount) {
                        System.out.println(Thread.currentThread().getName() + " is  withdrawing");
                        Thread.sleep(2000);
                        balance -= amount;
                    } else {
                        System.out.println(Thread.currentThread().getName() + " insufficient balance.....");
                    }
                    System.out.println(Thread.currentThread().getName() + " balance left : " + balance);
                }catch (Exception e){
                    Thread.interrupted(); // always interupt the thread when flow comed to the catch block.
                }
                finally {
                    System.out.println(Thread.currentThread().getName()+"  Releasing the lock");
                    lock.unlock();

                }
            }else{
                System.out.println(Thread.currentThread().getName() + " was not able to acquire lock ");
            }
        }catch(Exception e){
            Thread.interrupted();
        }
    }

}