

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.*;

/** Ejercicio de hilos  con ventanas. Esta clase carga el texto del Quijote en un área de texto,
 * y permite navegar por el área con la scrollbar y con botones de página arriba y página abajo.
 * 1. Modificarlo para que al pulsar los botones el scroll se haga con una animación 
 * a lo largo de un segundo, en lugar de en forma inmediata.
 * 2. Prueba a pulsar muy rápido varias páginas abajo. ¿Cómo lo arreglarías para que el scroll
 * en ese caso funcione bien y vaya bajando una página tras otra pero las baje *completas*?
 * @author andoni.eguiluz @ ingenieria.deusto.es
 */
public class VentanaQuijote extends JFrame {

	private JTextArea taTexto;
	private JScrollPane spTexto;
	
	
	public VentanaQuijote() {
		setDefaultCloseOperation( JFrame.DISPOSE_ON_CLOSE );
		setTitle( "Don Quijote de la Mancha" );
		setSize( 800, 600 );
		setLocationRelativeTo( null );  // Pone la ventana relativa a la pantalla
		taTexto = new JTextArea();
		spTexto = new JScrollPane( taTexto );
		add( spTexto, BorderLayout.CENTER );
		JPanel pBotonera = new JPanel();
		JButton bPagArriba = new JButton( "^" );
		JButton bPagAbajo = new JButton( "v" );
		pBotonera.add( bPagArriba );
		pBotonera.add( bPagAbajo );
		add( pBotonera, BorderLayout.SOUTH );
		bPagArriba.addActionListener( new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				muevePagina( -(spTexto.getHeight()-20) );
			}
		});
		bPagAbajo.addActionListener( new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				muevePagina( (spTexto.getHeight()-20) );
			}
		});
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosed() {
				
			}
		});
	}
	private ArrayList<Thread> hilosActivos = new ArrayList<>();
	private Thread hiloActual;
	
	private void muevePagina( int pixelsVertical ) {
		// TODO Cambiar este comportamiento de acuerdo a los comentarios de la cabecera de clase
		
	
		hiloActual = new Thread(new Runnable() {
			
			
				
			@Override
			public void run() {
				// TODO Auto-generated method stub
				//mirar si hay algun hilo funcionando y hasta qu eno soy el primero no me pongo a funcionar
				
				Thread yo = hiloActual;
				hilosActivos.add(yo);
				
				while(hilosActivos.get(0) != yo) {
					if(Interrupted()) return;
					try {
						Thread.sleep(10);
					}catch(InterruptedException e) {
					}
				}
				JScrollBar bVertical = spTexto.getVerticalScrollBar();
				System.out.println( "Moviendo texto de " + bVertical.getValue() + " a " + (bVertical.getValue()+pixelsVertical) );
				
				if(pixelsVertical> 0) {
					for(int i = 0; i< pixelsVertical; i++) {
						bVertical.setValue( bVertical.getValue() + 1 );
						try {Thread.sleep(10);} catch(InterruptedException e) {
						}
					}
				}else {
					for(int i = 0; i<Math.abs(pixelsVertical); i--) {
						bVertical.setValue( bVertical.getValue() - 1 );
						try {Thread.sleep(10);} catch(InterruptedException e) {
							
						}
					}
				}
				hilosActivos.remove(0);
			}
			
			
		});
				hiloActual.start();
		
	}
		
	
	private void cargaQuijote() {
		try {
			Scanner scanner = new Scanner( VentanaQuijote.class.getResourceAsStream( "DonQuijote.txt" ), "UTF-8" );
			while (scanner.hasNextLine()) {
				String linea = scanner.nextLine();
				taTexto.append( linea + "\n" );
			}
			scanner.close();
		} catch (Exception e) {
			JOptionPane.showMessageDialog( this, "No se ha podido cargar el texto" );
		}
	}

	public static void main(String[] args) {
		VentanaQuijote v = new VentanaQuijote();
		v.setVisible( true );
		v.cargaQuijote();
	}

}
