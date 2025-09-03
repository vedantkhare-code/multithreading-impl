import java.util.Scanner;


public class MyThread1 extends Thread {
    public static String s;
    public static void main(String[] args) throws InterruptedException {
        MyThread1 t1 = new MyThread1();
        System.out.println("Write your full name in 5 sec");
        t1.start();
//        Scanner sc = new Scanner(System.in);
//        String s = sc.nextLine();
        try {
            for (int i = 0; i < 5; i++) {
                Thread.sleep(1000);
                System.out.println(i);
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);

        }

//        t1.join();
        System.out.println("you have written : "+ s);
    }

    @Override
    public void run() {
        Scanner sc = new Scanner(System.in);
        s = sc.next();
    }
}
