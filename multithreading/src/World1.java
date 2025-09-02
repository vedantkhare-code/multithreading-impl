public class World1 implements Runnable{
    @Override
    public void run() {
        for(;;)
            System.out.println("Name of the World1 : "+Thread.currentThread().getName());
    }
}
