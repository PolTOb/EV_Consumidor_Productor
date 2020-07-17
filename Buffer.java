/*
x * 
 */
package productorconsumidor;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JTextField;

public class Buffer extends DefaultListModel{
    
    private int limite;
    private char [] buffer;
    private int contador;
    private JTextField text;
    
    public Buffer(int l, JTextField text)
    {
        this.limite = l;
        this.buffer = new char[limite];
        this.contador = 0;
        this.text = text;
    }
    
    public boolean agregar(char caracter)
    {
        if(contador == limite)
        {
        	System.out.println("El buffer esta lleno");
        	return false;
        }
        else
        {
        	buffer[contador++] = caracter;
        	String t = "";
        	for(int i = 0; i < contador; ++i)
        	{
        		t+=buffer[i];
        	}
        	text.setText(t);
        	return true;
        }
    }
    
    public char quitar()
    {
        if(contador == 0)
        {
        	System.out.println("El buffer esta vacio");
        	return 0;
        }
        else
        {
        	char ret = buffer[--contador];
        	buffer[contador] = ' ';
        	String t = "";
        	for(int i = 0; i < contador; ++i)
        	{
        		t+=buffer[i];
        	}
        	text.setText(t);
        	return ret;
        }
    }
}
