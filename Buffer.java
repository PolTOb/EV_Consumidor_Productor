package Pro_Con;

import java.util.concurrent.*;

public class Buffer {
	private int[] b;
	private int i=0,j=0;
	private Semaphore mutex=new Semaphore(1,true);
	private Semaphore hayDatos =new Semaphore(0,true);
	private Semaphore hayEspacio;
	
	public Buffer(int tam) {
		b=new int[tam];
		hayEspacio=new Semaphore(b.length,true);
	}
	public void poner (int dato) throws InterruptedException {
		hayEspacio.acquire();
		mutex.acquire();
		b[i]=dato;
		System.out.print("Productor produce "+dato);
		i=(1+i)%b.length;
		mutex.release();
		hayDatos.release();
	}
	public int extraer() throws InterruptedException {
		hayDatos.acquire();
		mutex.acquire();
		int aux=j;
		j=(j+1)%b.length;
		System.out.print("Consumidor consume "+b[aux]);
		mutex.release();
		hayEspacio.release();
		return b[aux];
	}

}
