package Pro_Con;


public class Consumidor extends Thread{
	private Buffer b;
	private int iter;
	public Consumidor(Buffer b,int iter) {
		this.b=b;
		this.iter=iter;
	}
	@Override
	public void run() {
		for(int i=0;i<iter;i++) {
			int aux;
			try{
				aux=b.extraer();
				System.out.println(i+" :Consumidor consume "+aux);
			}catch (InterruptedException ex) {
				ex.printStackTrace();
			}
			
		}
	}
	public static void main(String[] args) {
		Buffer b=new Buffer(5);
		Productor p=new Productor(b,100);
		Consumidor c=new Consumidor(b,100);
		p.start();
		c.start();
	}

}
