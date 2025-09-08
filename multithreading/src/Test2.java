public class Test2 {
    public static void main(String[] args) {
        BankAccount account =new BankAccount();
        Runnable runnable =() -> {
            account.withdraw(50);
        };
        Thread t1 = new Thread(runnable,"Thread 1");
        Thread t2 = new Thread(runnable,"Thread 2");
        t1.start();
        t2.start();

    }
}
