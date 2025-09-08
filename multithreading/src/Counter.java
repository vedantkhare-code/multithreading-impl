public class Counter {
    private int count;
    public  void  increment(){
      synchronized (this){ // this represents current thread.
        this.count++;
    }
    }
    public int getCount(){
        return count;
    }
}