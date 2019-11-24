

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

import javax.swing.*;

/** Ejemplo/ejercicio para mostrar la sintaxis funcional de Java 8
 * Ejercicio: haz que el botón procese la lista de strings que mete el usuario en el cuadro de texto
 * y que muestre los enteros uno a uno (2 segundos cada uno) en el label de mensaje
 * UTILIZANDO EN LO POSIBLE JAVA FUNCIONAL
 * ¿Cómo harías además que se pudiera elegir la acción entre una lista de acciones
 * (por ejemplo [a] sacar los enteros cada 2 segundos y también [b] calcular la media y [c] solo visualizar)
 * también utilizando java funcional?
 */
public class JavaFuncional {

	private static JLabel lSalida = new JLabel( " " );
	private static JTextField tfEntrada = new JTextField( 20 );
	private static JButton bProcesar;
	private static ArrayList<String> nombreOpcion = new ArrayList<>();
	private static ArrayList<Runnable> nombreCodigo = new ArrayList<>();
	
	private static void init() {
		nombreOpcion.add("Visualizar cada 2 seg");
		nombreOpcion.add("Calcular media");
		nombreOpcion.add("Visualizar lista");
		//Nombre de clase/ instancia :: nombre del metodo
		//el metodo tiene que tener un arraylist de integers para que funcione y delvover void
		nombreOpcion.add(JavaFuncional :: cada2segundos);
		nombreOpcion.add(JavaFuncional :: calculaMedia);
		nombreOpcion.add (l) -> {lSalida.setText(l.toString());
		};
		
		for(String s : nombreOpcion) {
			cbOpciones.addItem(s);
		}
	}
	private static JComboBox<String> cbOpciones = new JComboBox<>();
	
	/** Crea ventana de ejemplo con un cuadro de texto y un botón
	 * @param args	No utilizado
	 */
	public static void main(String[] args) {
		init();
		// Creación y configuración ventana
		JFrame f = new JFrame( "Ejemplo de lambda en Java 8" );
		f.setDefaultCloseOperation( JFrame.DISPOSE_ON_CLOSE );
		// Componentes
		JPanel pEntrada = new JPanel();
		JButton bProcesar = new JButton( "Procesar" );
		pEntrada.add( new JLabel( "lista de enteros entre comas:" ) );
		pEntrada.add( tfEntrada );
		pEntrada.add( bProcesar );
		f.add( pEntrada, BorderLayout.NORTH );
		f.add( lSalida, BorderLayout.SOUTH );
		f.add(cbOpciones, BorderLayout.CENTER);
		//Programas eventos
		bProcesar.addActionListener((ActionEvent jj) -> {procesoBoton(); } );
		
		
		// Visualizar
		f.pack();
		f.setLocationRelativeTo( null );
		f.setVisible( true );
	}
	
	public static void procesoBoton() {
		ArrayList<String> lStrings = listaDeStrings(tfEntrada.getText());
		ArrayList<Integer> lEnteros = listaDeInts(lStrings);
		if(lEnteros == null || lEnteros.isEmpty()) {
			return;
		}
		if(cbOpciones.getSelectedIndex() != -1) {
			nombreCodigo.get(cbOpciones.getSelectedIndex()).procesaLE(lEnteros);
		}
		
		
	}
	private static void cada2segundos(ArrayList<Integer> lEnteros) {
	
		Thread t = new Thread(
				()->  {
					bProcesar.setEnabled(false);
			for(int i : lEnteros) {
				lSalida.setText(i + "");
				try {Thread.sleep(2000);} catch(InterruptedException e) {}
				
			}
			lSalida.setText("");
			bProcesar.setEnabled(true);
		}
		);
		
	}
	private static void calculaMedia(ArrayList<Integer> l) {
		int suma = 0;
		for(int i : l) suma +=1;
		lSalida.setText("" + 1.0 * suma/l.size());
	}
	/** Devuelve un arraylist de strings partiendo de un string con comas
	 * @param lista	Lista de substrings separados por comas
	 * @return	Devuelve una lista de strings separando los substrings que estén con comas (quitando los espacios)
	 */
	private static ArrayList<String> listaDeStrings( String lista ) {
		ArrayList<String> ret = new ArrayList<String>();
		StringTokenizer st = new StringTokenizer( lista, "," );
		while (st.hasMoreTokens()) {
			ret.add( st.nextToken().trim() );  // Mete el siguiente substring quitando espacios
		}
		return ret;
	}
	
	/** Devuelve una lista de enteros partiendo de una lista de strings
	 * @param lista	Lista de strings que representan a enteros
	 * @return	Lista de los enteros en la lista de strings (si algún string no es un entero válido, se ignora)
	 */
	private static ArrayList<Integer> listaDeInts( ArrayList<String> lista ) {
		ArrayList<Integer> ret = new ArrayList<Integer>();
		for (String string : lista) {
			try {
				ret.add( Integer.parseInt( string ) );
			} catch (NumberFormatException e) {
				// Se ignora el string que no es un entero válido
			}
		}
		return ret;
	}

}
