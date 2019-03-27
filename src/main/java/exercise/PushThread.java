package exercise;
interface StackInterface
{
    public int[] push(int n);
    public int []pop();
}
public class PushThread implements Runnable{
    private  StackInterface s;
    public PushThread(StackInterface s)
    {
this.s=s;
    }
public void run()
{
    int i=0;
    while (true)
    {
        java.util.Random r=new java.util.Random();
        i=r.nextInt(10);
        s.push(i);
        try{
            Thread.sleep(100);
        }
        catch (InterruptedException e){}
    }
}
}
class PopThread implements Runnable
{
    private StackInterface s;
    public PopThread(StackInterface s)
    {
        this.s=s;
    }
    public void run()
    {
        while (true)
        {
            System.out.println("->"+s.pop()[0]+"<-");
            try{
                Thread.sleep(100);
            }
            catch(InterruptedException e){}
        }
    }
}

class SafeStack implements StackInterface{
    private int top =0;
    private int[] values= new int[20];
    private boolean dataAvailable =false;
    public int[] push(int n){
        synchronized(this){
            while (dataAvailable)
            {
                try{
                    wait();
                }catch(InterruptedException e){
                }
            }
            System.out.println("弹出");
            top--;
            int[] test={values[top],top};
            dataAvailable=false;
            notifyAll();
            return test;
        }
    }

    @Override
    public int[] pop() {
        return new int[0];
    }

}
class TestSafeStack{
    public static void main(String[] args){
        SafeStack s=new SafeStack();
        PushThread r1=new PushThread(s);
        PopThread r2=new PopThread(s);
        PopThread r3=new PopThread(s);
        Thread t1=new Thread(r1);
        Thread t2=new Thread(r2);
        Thread t3=new Thread(r3);
        t1.start();
        t2.start();
        t3.start();

    }
}