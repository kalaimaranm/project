
package iopackages;


public class RunnableDemo extends Object implements Runnable{
    
    
    @Override
    public void run() {
        
        Runnable r = new RunnableDemo();
        Thread t = new Thread(r);
        t.setName("runnable-demo");
        
    }
    
}
