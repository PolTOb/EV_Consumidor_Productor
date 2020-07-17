/*
 * 
 *
 */
package productorconsumidor;

import java.util.concurrent.Semaphore;

/**
 *
 * 
 */
public class Consumidor extends Thread{
    

    private Buffer miBuffer;
    private Semaphore s;
    private String nombre;
    
    public Consumidor( String nombre, Buffer miBuffer, Semaphore s)
        {
    		this.nombre = nombre;
            this.miBuffer = miBuffer;
            this.s = s;
        }  
    
    public void run()
    {
    	while(true)
    	{
    		try {
				s.acquire();
				System.out.print(nombre + "<- ");
				char dev = miBuffer.quitar();
				if(dev != 0)
				{
					System.out.println(dev);
					
				}
				s.release();
				
				Thread.sleep((int)(Math.random() * 500) + 500);				
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    	}
    }
}