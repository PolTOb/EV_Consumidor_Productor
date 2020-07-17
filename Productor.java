/*
 * 
 
 */
package productorconsumidor;

import java.util.concurrent.Semaphore;

/**
 *
 * 
 */
public class Productor extends Thread{
    //private ProductorConsumidorGUI miPantalla;
    private Buffer miBuffer;
    private Semaphore s;
    String nombre;
    
    public Productor(String nombre, Buffer miBuffer, Semaphore s)
    {
    	this.nombre = nombre;
        this.miBuffer = miBuffer;
        //this.miPantalla = miPantalla;
        this.s = s;
    }
    public void run()
    {
       while(true)
       {
   		try {
				s.acquire();
				char caracter = (char)((Math.random() * ('z'-'a')) + 'a');
				System.out.print(nombre + "-> ");
				if((miBuffer.agregar(caracter) == true))
				{
					System.out.println(caracter);
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

