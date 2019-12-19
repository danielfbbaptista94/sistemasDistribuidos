/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ads
 */
public class Consumer extends Thread {
    
    Programa programa;
    Semaphore semaphore;

    public Consumer(Programa x) {
       this.programa = x;
    }

	public void run() {
       try {
           while (true) {
               while (this.programa.itemCount == 0)
                   sleep(100);
               int item = 0;
               this.programa.items.down();
               this.programa.mutex.down();
               item = (Integer) this.programa.buffer.get(0);
               this.programa.buffer.remove(0);
               this.programa.mutex.up();
               this.programa.itemCount--; 
               System.out.println("consumer: consuming item "+item);
               for (int i =0;i<10000;i++);
           }
       } catch(InterruptedException e) {
               e.printStackTrace(); 
       }
    }
}
