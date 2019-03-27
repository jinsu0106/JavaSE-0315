package exercise;

public class TimeThread extends Thread {
    public void run(){
        for (int i=0;i<10;i++){
            System.out.println("hello world");
            try{
                sleep(10000);
            }catch(InterruptedException e){
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        TimeThread tt=new TimeThread();
        tt.start();
    }

}
