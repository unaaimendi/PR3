package es.deusto.prog3.cap03.resueltos.miniAmazon;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class Main extends JFrame {
	
	
	private JTextArea taDatos;
	private ArrayList<Producto> listaProds;
	
	public Main() {
		
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setSize(500, 400);
		setTitle("Ejercicio 3.6 de base de datos" );
		taDatos = new JTextArea();
		taDatos.setFont(new Font( "Arial", Font.PLAIN, 10));
		JButton bProductos = new JButton("Ver Productos");
		JButton bComprar = new JButton("Comprar");
		
		JPanel pBotonera = new JPanel();
		pBotonera.add(bProductos);
		pBotonera.add(bComprar);
		getContentPane().add(new JScrollPane(taDatos), BorderLayout.CENTER);
		getContentPane().add( pBotonera, BorderLayout.SOUTH);
		
		bComprar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				clickComprar();
				
			}
		});
		
		bProductos.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				clickVerProductos();
			}
		});
		
		addWindowListener(new WindowListener() {
			
			@Override
			public void windowOpened(WindowEvent e) {
				// TODO Auto-generated method stub
				BaseDatos.abrirConexion("miniAmazon");
			}
			
			@Override
			public void windowIconified(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void windowDeiconified(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void windowDeactivated(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void windowClosing(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void windowClosed(WindowEvent e) {
				// TODO Auto-generated method stub
				BaseDatos.cerrarConexion();
			}
			
			@Override
			public void windowActivated(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		
		
	}
	
	public ArrayList<Producto> clickVerProductos(){
		ArrayList<Producto> ret = new ArrayList<Producto>();
		Statement statement = conexion.createStatement();
		String sent = "select * from producto;";
		System.out.println(sent);
		ResultSet rs = statement.exe
	}
	public void clickComprar() {
		
	}
	
	
	public static void main(String[] args) {
		Main v  = new Main();
		v.setVisible(true);
	}

}
