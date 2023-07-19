public class MultiThreading {
    public static void main(String[] args){
        ForMultiThread thread=new ForMultiThread();
        thread.start();
    }
}
class ForMultiThread extends Thread{
    @Override
    public void run(){
        for(int i=0; i<10; i++){
            System.out.println(i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
