package productorconsumidor;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.util.concurrent.Semaphore;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.JLabel;

public class ProductorConsumidorGUI {

	private JFrame frame;
	private JTextField textField;
	
	Semaphore s = new Semaphore(1);
	
	Consumidor c1, c2;
	Productor p1, p2;
	
	Buffer buffer;
	boolean Pestado1 = false, Pestado2 = false;
	boolean Cestado1 = false, Cestado2 = false;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ProductorConsumidorGUI window = new ProductorConsumidorGUI();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ProductorConsumidorGUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 553, 371);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(162, 123, 221, 79);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JButton iniciarP1 = new JButton("iniciar");
		iniciarP1.setForeground(Color.BLACK);
		iniciarP1.setBackground(Color.WHITE);
		iniciarP1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(Pestado1 == false)
				{
					p1=new Productor("Productor 1 ", buffer, s);
					p1.start();
					Pestado1 = true;
				}
				else
				{
					p1.resume();
				}
			}
		});
		iniciarP1.setBounds(34, 38, 89, 23);
		frame.getContentPane().add(iniciarP1);
		
		JButton pararP1 = new JButton("parar");
		pararP1.setBackground(Color.WHITE);
		pararP1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				p1.suspend();
			}
		});
		pararP1.setBounds(34, 72, 89, 23);
		frame.getContentPane().add(pararP1);
		
		JButton iniciarP2 = new JButton("iniciar");
		iniciarP2.setBackground(Color.WHITE);
		iniciarP2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(Pestado2 == false)
				{
					p2 = new Productor("Productor 2 ",buffer, s);
					p2.start();
					Pestado2 = true;
				}
				else
				{
					p2.resume();
				}
			}
		});
		iniciarP2.setBounds(34, 198, 89, 23);
		frame.getContentPane().add(iniciarP2);
		
		JButton pararP2 = new JButton("parar");
		pararP2.setBackground(Color.WHITE);
		pararP2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				p2.suspend();
			}
		});
		pararP2.setBounds(34, 232, 89, 23);
		frame.getContentPane().add(pararP2);
		
		buffer = new Buffer(20, textField);
		
		JButton iniciarC1 = new JButton("iniciar");
		iniciarC1.setBackground(Color.WHITE);
		iniciarC1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(Cestado1 == false)
				{
					c1 = new Consumidor("consumidor 1", buffer, s);
					c1.start();
					Cestado1 = true;
				}
				else
				{
					c1.resume();
				}
			}
		});
		iniciarC1.setBounds(412, 38, 89, 23);
		frame.getContentPane().add(iniciarC1);
		
		JButton pararC1 = new JButton("parar");
		pararC1.setBackground(Color.WHITE);
		pararC1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				c1.suspend();
			}
		});
		pararC1.setBounds(412, 72, 89, 23);
		frame.getContentPane().add(pararC1);
		
		JButton iniciarC2 = new JButton("iniciar");
		iniciarC2.setBackground(Color.WHITE);
		iniciarC2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(Cestado2 == false)
				{
					c2 = new Consumidor("Consumidor 2", buffer, s);
					c2.start();
					Cestado2 = true;
				}
				else
				{
					c2.resume();
				}
			}
		});
		iniciarC2.setBounds(412, 198, 89, 23);
		frame.getContentPane().add(iniciarC2);
		
		JButton pararC2 = new JButton("parar");
		pararC2.setBackground(Color.WHITE);
		pararC2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				c2.suspend();
			}
		});
		pararC2.setBounds(412, 232, 89, 23);
		frame.getContentPane().add(pararC2);
		
		JButton btnSalir = new JButton("Salir");
		btnSalir.setBackground(Color.WHITE);
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		btnSalir.setBounds(218, 249, 89, 23);
		frame.getContentPane().add(btnSalir);
		
		JLabel lblProductor = new JLabel("Productor 1");
		lblProductor.setBounds(34, 22, 69, 14);
		frame.getContentPane().add(lblProductor);
		
		JLabel lblProductor_1 = new JLabel("Productor 2");
		lblProductor_1.setBounds(34, 175, 69, 14);
		frame.getContentPane().add(lblProductor_1);
		
		JLabel lblConsumidor = new JLabel("Consumidor 1");
		lblConsumidor.setBounds(416, 22, 69, 14);
		frame.getContentPane().add(lblConsumidor);
		
		JLabel lblConsumidor_1 = new JLabel("Consumidor 2");
		lblConsumidor_1.setBounds(412, 175, 69, 14);
		frame.getContentPane().add(lblConsumidor_1);
	
		JLabel lblBuffer = new JLabel("Buffer");
		lblBuffer.setBounds(235, 100, 46, 14);
		frame.getContentPane().add(lblBuffer);
	}
}
