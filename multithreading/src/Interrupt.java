public class Interrupt extends Thread{
    @Override
    public void run() {
        System.out.println("Thread is runninggg....");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            System.out.println("Thread interrupted "+ e);
        }
    }

    public static void main(String[] args) {
        Interrupt i = new Interrupt();
        i.start();
        i.interrupt();

    }
}
