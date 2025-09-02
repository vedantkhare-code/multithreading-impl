public class World extends Thread{
    @Override
    public void run() {
        for(;;)
            System.out.println("Name of this Thread : "+Thread.currentThread().getName());
    }
}
