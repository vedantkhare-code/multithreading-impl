import javax.security.auth.login.AppConfigurationEntry;

class Pen {

    synchronized void writeWithPenAndPaper(Paper paper){
        System.out.println(Thread.currentThread().getName()+" Start Wrting with Pen");
        paper.finishWithPaper();
    }
    synchronized  void finishWithPen(){
        System.out.println("Using Pen to Write");
    }
}
class Paper {

    synchronized void  writeWithPenAndPaper(Pen pen){
        System.out.println(Thread.currentThread().getName()+" Start Wrting with Paper");
        pen.finishWithPen();
    }
    synchronized void finishWithPaper(){
        System.out.println("Using Paper to Write");
    }
}
class Task1 implements Runnable {
    private Pen pen;
    private Paper paper;

    public Task1(Pen pen, Paper paper) {
        this.pen = pen;
        this.paper=paper;
    }

    @Override
    public void run() {
        paper.writeWithPenAndPaper(pen);   //it has locked paper and trying to lock pen.
    }

}
class Task2 implements Runnable {
    private Pen pen;
    private Paper paper;

    public Task2(Pen pen, Paper paper) {
        this.pen = pen;
        this.paper=paper;
    }

    @Override
    public void run() {
        synchronized (paper) {  //lock paper only when it was lock of paper(to avoid deadlock)
            pen.writeWithPenAndPaper(paper);  //it has locked pen and trying to lock paper.
        }
    }

}
class DeadLockExample{
    public static void main(String[] args) throws InterruptedException {
        Pen pen = new Pen();
        Paper paper = new Paper();
        Task1 task1  = new Task1(pen,paper);
        Task2 task2  = new Task2(pen,paper);
        Thread t1 = new Thread(task1);
        Thread t2 = new Thread(task2);
        t1.start();
        t2.start();
        t1.join();
        t2.join();

    }
}
