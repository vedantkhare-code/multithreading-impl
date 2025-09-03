public class MyThread extends  Thread{
    public static void main(String[] args) throws InterruptedException {
        MyThread t1 = new MyThread();
        System.out.println("1"+t1.getState());
        System.out.println("2"+Thread.currentThread().getState());
        t1.start();
        System.out.println("3"+t1.getState());
        Thread.sleep(100);

        System.out.println("4"+t1.getState());
        t1.join();
        System.out.println("6"+t1.getState());
    }

    @Override
    public void run() {
        System.out.println("5 inside run");
        try {
            Thread.sleep(1110);
            for (int i =0;i<10;i++ )
                System.out.println(i);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
