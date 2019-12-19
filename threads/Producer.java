/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ads
 */
public class Producer extends Thread {
    
    Programa programa;
    Semaphore semaphore;    
    int contador;
    
    public Producer(Programa x) {
       this.programa = x;
       contador =0;
    }

	public void run() {
       try {
           while (true) {        	   
               while (this.programa.itemCount == 10)
            	   	sleep(100);
                contador ++;
                this.programa.mutex.down();
                this.programa.buffer.add(contador);
           		this.programa.items.up();
           		this.programa.mutex.up();
                this.programa.itemCount++;
                System.out.println("produtor: producing item "+contador);
                for (int i =0;i<10000;i++);
           }

       } catch(InterruptedException e) {
               e.printStackTrace(); 
       }
    }
}
