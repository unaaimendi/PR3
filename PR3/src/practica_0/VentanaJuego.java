package practica_0;

import javax.swing.JFrame;

import java.awt.BorderLayout;

import javax.swing.*;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VentanaJuego extends JFrame {
	private CocheJuego miCarro;
	private JPanel panel;

	public VentanaJuego() {
		// TODO Auto-generated constructor stub
		panel = new JPanel();
		setSize(600, 400);
		setTitle("Juego Coche");
		panel.setBackground(Color.WHITE);
		panel.setLayout(null);
		JPanel pBotonera = new JPanel();
		JButton bAcelera = new JButton("Acelera");
		JButton bFrena = new JButton("Frena");
		JButton bGiraIzq = new JButton("Gira Izq");
		JButton bGiraDer = new JButton("Gira Der");

		//JLabelCoche c = new JLabelCoche();
		//panel.add(c);

		pBotonera.add(bAcelera);
		pBotonera.add(bFrena);
		pBotonera.add(bGiraIzq);
		pBotonera.add(bGiraDer);

		bAcelera.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				miCarro.acelera(+5);
				System.out.println("Velocidad : " + miCarro.getMiVelocidad());

			}
		});

		bFrena.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				miCarro.acelera(-5);
				System.out.println("Velocidad : " + miCarro.getMiVelocidad());

			}
		});

		bGiraDer.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				miCarro.gira(-10);
				System.out.println("Dirección actual : " + miCarro.getMiDireccionActual());

			}
		});

		bGiraIzq.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				miCarro.gira(+10);
				System.out.println("Dirección actual : " + miCarro.getMiDireccionActual());

			}
		});

		add(panel, BorderLayout.CENTER);
		add(pBotonera, BorderLayout.SOUTH);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);

	}

	public void creaCoche(int posX, int posY) {
		// Crear y añadir el coche a la ventana
		miCarro = new CocheJuego();
		miCarro.setPosicion(posX, posY);
		panel.add(miCarro.getGrafico());
	}

	public static void main(String[] args) {
		VentanaJuego v = new VentanaJuego();
		v.setVisible(true);
		v.creaCoche( 150, 100 );
		v.miCarro.setPiloto( "Peter Pettigrew" );
		//no se ve el coche hasta que se pulsa el boton de giro
		
	}
}