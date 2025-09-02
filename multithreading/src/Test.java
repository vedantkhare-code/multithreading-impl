public class Test {
    public static void main(String[] args) {
        World world = new World();
        world.start();
        World1 world1 = new World1();
        Thread t1 = new Thread(world1);
        t1.start();
        Runnable r1 =()->{
            for(;;)
                System.out.println("Thread FI");
        };
        Thread t2= new Thread(r1);
        t2.start();

        for( ; ; )
            System.out.println( "name of main thread : " + Thread.currentThread().getName());
    }
}
