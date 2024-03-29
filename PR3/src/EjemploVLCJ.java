

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

// Con versión 4 de vlcj: http://capricasoftware.co.uk/projects/vlcj
//	http://capricasoftware.co.uk/downloads/vlcj/vlcj-4.1.0-dist.zip

import uk.co.caprica.vlcj.player.component.EmbeddedMediaPlayerComponent;
import uk.co.caprica.vlcj.factory.discovery.NativeDiscovery;


public class EjemploVLCJ extends JFrame {
	private static final long serialVersionUID = 1L;
	
	private static EjemploVLCJ miVentana;
	private EmbeddedMediaPlayerComponent mediaPlayerComponent;

	public EjemploVLCJ() {
		setTitle("Prueba vlcj");
		setSize(800, 600);
		mediaPlayerComponent = new EmbeddedMediaPlayerComponent();
		add( mediaPlayerComponent, BorderLayout.CENTER );
		JPanel pBotonera = new JPanel();
		JButton bPlayPausa = new JButton( "Play/Pausa" );
		pBotonera.add( bPlayPausa );
		add( pBotonera, BorderLayout.SOUTH );
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setVisible(true);
		addWindowListener( new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				mediaPlayerComponent.mediaPlayer().controls().stop();
				mediaPlayerComponent.mediaPlayer().release();
			}
		});
		bPlayPausa.addActionListener( new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (mediaPlayerComponent.mediaPlayer().status().isPlaying())
					mediaPlayerComponent.mediaPlayer().controls().pause();
				else
					mediaPlayerComponent.mediaPlayer().controls().play();
			}
		});
	}

	private void lanza(String mrl) {
		mediaPlayerComponent.mediaPlayer().audio().setVolume( 100 );
		mediaPlayerComponent.mediaPlayer().media().play(mrl);
	}

	public static void main(String[] args) {
		boolean found = (new NativeDiscovery()).discover();
    	if (!found) System.setProperty("jna.library.path", "c:\\Archivos de programa\\videolan\\vlc-2.1.5");
		miVentana = new EjemploVLCJ();
		miVentana.lanza(
				"C:\\Users\\UNAI\\Desktop\Los Vengadores 3 - Infinity War (2018) [HDRip][Ac3-5.1] Castellano"
				);
	}
	
}
