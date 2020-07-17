package Pro_Con;
import java.util.Random;
public class Productor extends Thread {
	private Random r =new Random();
	private Buffer b;
	private int iter;
	public Productor(Buffer b,int iter) {
		this.b=b;
		this.iter=iter;
	}
	@Override
	public void run() {
		for(int i=0;i<iter;i++) {
			try {
				int aux=r.nextInt(100);
				System.out.println(i+" :Productor produce "+aux);
				b.poner(aux);
			}catch (InterruptedException ex) {
				ex.printStackTrace();
			}
			
		}
	}

}
