public class Synchronization {
    public static void main(String[] args) throws InterruptedException {
        Counter counter = new Counter();
        TestThread t1 = new TestThread(counter);
        TestThread t2 = new TestThread(counter);
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println(counter.getCount());
    }
}
