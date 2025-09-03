public class Yield extends Thread{

    // Yield : Gives hint to OS that the current thread is willing to yield its current use of processor.
    //(Hathiyar Daalna Chahta hai Current Thread............)
    //Gives Hint only i.e. it is not neccessary that yielding for that thread will happen(Scheduler is free to ignore this hint).
    public Yield(String name) {
        super(name);
    }
    public static void main(String[] args) {
        Yield y1 = new Yield("y1");
        Yield y2 = new Yield("y2");
        y1.start();
        y2.start();
    }


    @Override
    public void run() {
        for (int i=0;i<5;i++){
            System.out.println(Thread.currentThread().getName());
            Thread.yield();
        }
    }
}
