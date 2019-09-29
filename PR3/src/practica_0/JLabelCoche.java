package practica_0;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class JLabelCoche extends JLabel {
	private int ancho = 100;
	private int alto = 100;
	private String miCarro;

	public JLabelCoche() {
		// TODO Auto-generated constructor stub
		try {
			setIcon(new ImageIcon(JLabelCoche.class.getResource("Coche.png").toURI().toURL()));
		} catch (Exception e) {
			System.out.println("Error");
			e.printStackTrace();
		}
		setBounds(0, 0, alto, ancho);

	}

	@Override
	public void paintComponent(Graphics g) {
		Image imagen = ((ImageIcon) getIcon()).getImage();
		Dimension tmñ = new Dimension(imagen.getWidth(null), imagen.getHeight(null));
		Graphics2D g2 = (Graphics2D) g;
		setPreferredSize(tmñ);
		setSize(140, 100);
		g2.rotate(miGiro, 50, 50);
		g2.drawImage(imagen, 0, 0, 100, 100, null);

	}

	private double miGiro = Math.PI / 2;

	public void setGiro(double grados) {

		miGiro = grados / 180 * Math.PI;
		miGiro = -miGiro;
		miGiro = miGiro + Math.PI / 2;
	}

}
