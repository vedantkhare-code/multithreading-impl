

 class SharedResources{
    int data;
    boolean hasData;
    synchronized void produce(int data){
        while(hasData){
            try {
                wait();
            }catch (InterruptedException e){
                System.out.println("thread Interupted");
            }
        }
        this.data=data;
        this.hasData=true;
        System.out.println(Thread.currentThread().getName()+" produced : "+data);
        notify();

    }
     synchronized int consume (){
        while (!hasData){
            try {
                wait();
            }catch (InterruptedException e){
                System.out.println("thread Interupted");
            }
        }
        System.out.println(Thread.currentThread().getName()+" Consumed : "+data);
        hasData=false;
        notify();
        return data;
    }

}
class Producer implements  Runnable{
    SharedResources sharedResources;

     Producer(SharedResources sharedResources) {
        this.sharedResources = sharedResources;
    }
    @Override
    public void run() {
         for(int i=0;i<10;i++){
        sharedResources.produce(i);
    }
     }
}
class Consumer implements  Runnable{
    SharedResources sharedResources;

    Consumer(SharedResources sharedResources) {
        this.sharedResources = sharedResources;
    }
    @Override
    public void run() {
         for(int i=0;i<10;i++){
        sharedResources.consume();
    }
     }
}



public class ThreadCommunication {

    public static void main(String[] args) {
        SharedResources sharedResources = new SharedResources();
        Thread t1 = new Thread(new Producer(sharedResources),"T1");
        Thread t2 = new Thread(new Consumer(sharedResources),"T2");
        t1.start();
        t2.start();

    }
    }
