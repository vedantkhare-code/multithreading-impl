public class ThreadMethod extends Thread{
    public ThreadMethod(String name) {
        super(name);
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + "is runnning with priority :"+ Thread.currentThread().getPriority());
    }

    public static void main(String[] args) {
        ThreadMethod l = new ThreadMethod("Low Priority");
        ThreadMethod m = new ThreadMethod("Med Priority");
        ThreadMethod h = new ThreadMethod("High Priority");
        l.setPriority(MIN_PRIORITY);
        m.setPriority(NORM_PRIORITY);
        h.setPriority(MAX_PRIORITY);
        l.start();
        m.start();
        h.start();

    }
}
