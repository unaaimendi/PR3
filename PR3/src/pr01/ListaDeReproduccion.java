package pr01;

import java.io.File;
import java.util.ArrayList;
import java.util.logging.FileHandler;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

import javax.swing.ListModel;
import javax.swing.event.ListDataEvent;
import javax.swing.event.ListDataListener;

/**
 * Clase para crear instancias como listas de reproducci�n, que permite
 * almacenar listas de ficheros con posici�n de �ndice (al estilo de un array /
 * arraylist) con marcas de error en los ficheros y con m�todos para cambiar la
 * posici�n de los elementos en la lista, borrar elementos y a�adir nuevos.
 */
public class ListaDeReproduccion implements ListModel<String> {
	ArrayList<File> ficherosLista; // ficheros de la lista de reproducci�n
	int ficheroEnCurso = -1; // Fichero seleccionado (-1 si no hay ninguno seleccionado)
	private static final boolean ANYADIR_FIC_A_LOG = true;

	private static Logger logger = Logger.getLogger(ListaDeReproduccion.class.getName());
	static {
		try {
			logger = Logger.getLogger("ListaDeReporduccion", null);
			Handler h = new FileHandler("ListaRepLogger.xml", true);
			logger.setLevel(Level.FINEST);
			h.setLevel(Level.FINEST);
		} catch (Exception e) {

		}
	}

	/**
	 * 
	 */
	public ListaDeReproduccion() {
		ficherosLista = new ArrayList<File>();
	}

	/**Intercamba las posiciones de la lista
	 * @param posi1
	 * @param posi2
	 */
	public void intercambia(int posi1, int posi2) {
		int posi_1 = posi2;
		int posi_2 = posi1;
		posi1 = posi_2;
		posi2 = posi_1;

	}

	/**Devuelve el tama�o de la lista
	 * @return
	 */
	public int size() {
		return ficherosLista.size();
	}

	/**A�ade un elemento a la lista
	 * @param f
	 */
	public void add(File f) {

		ficherosLista.add(f);

	}

	/**Borra el elemento en la posicion que se pasa de la lista
	 * @param posi
	 */
	public void removeFic(int posi) {

		ficherosLista.remove(posi);

	}

	/**Borra todos los elementos de la lista
	 * 
	 */
	public void clear() {

		ficherosLista.clear();

	}

	/**
	 * Devuelve uno de los ficheros de la lista
	 * 
	 * @param posi Posici�n del fichero en la lista (de 0 a size()-1)
	 * @return Devuelve el fichero en esa posici�n
	 * @throws IndexOutOfBoundsException Si el �ndice no es v�lido
	 */
	public File getFic(int posi) throws IndexOutOfBoundsException {
		return ficherosLista.get(posi);
	}

	/**
	 * A�ade a la lista de reproducci�n todos los ficheros que haya en la carpeta
	 * indicada, que cumplan el filtro indicado. Si hay cualquier error, la lista de
	 * reproducci�n queda solo con los ficheros que hayan podido ser cargados de
	 * forma correcta.
	 * 
	 * @param carpetaFicheros Path de la carpeta donde buscar los ficheros
	 * @param filtroFicheros  Filtro del formato que tienen que tener los nombres de
	 *                        los ficheros para ser cargados. String con cualquier
	 *                        letra o d�gito. Si tiene un asterisco hace referencia
	 *                        a cualquier conjunto de letras o d�gitos. Por ejemplo
	 *                        p*.* hace referencia a cualquier fichero de nombre que
	 *                        empiece por p y tenga cualquier extensi�n.
	 * @return N�mero de ficheros que han sido a�adidos a la lista
	 */
	public int add(String carpetaFicheros, String filtroFicheros) {
		// TODO: Codificar este m�todo de acuerdo a la pr�ctica (pasos 3 y sucesivos)
		int ficsAnyadidos = 0;
		if (carpetaFicheros != null) {
			logger.log(Level.INFO, "A�adiendo ficheros con filtro " + filtroFicheros);
			try {
				filtroFicheros = filtroFicheros.replaceAll("\\.", "\\\\."); // Pone el s�mbolo de la expresi�n regular
																			// \. donde figure un .
				filtroFicheros = filtroFicheros.replaceAll("\\*", ".*"); // Pone el s�mbolo de la expresi�n regular .*
																			// donde figure un *
				logger.log(Level.INFO, "expresi�n regular del filtro: " + filtroFicheros);
				
				Pattern p = Pattern.compile(filtroFicheros);
				File fInic = new File(carpetaFicheros);
				if (fInic.isDirectory()) {
					for (File f : fInic.listFiles()) {
						logger.log(Level.FINE, "Procesando fichero " + f.getName());
						if (p.matcher(f.getName()).matches()) {
							ficsAnyadidos++;
							logger.log(Level.INFO, "Despues del filtro: " + f.getName());
							add(f);
						}
					}
				}
			} catch (PatternSyntaxException e) {
				logger.log(Level.SEVERE, "Error en patr�n de expresi�n regular ", e);
			}
		}
		logger.log(Level.INFO, "ficheros a�adidos: " + ficsAnyadidos);
		return ficsAnyadidos;
	}

	//
	// M�todos de selecci�n
	//

	/**
	 * Seleciona el primer fichero de la lista de reproducci�n
	 * 
	 * @return true si la selecci�n es correcta, false si hay error y no se puede
	 *         seleccionar
	 */
	public boolean irAPrimero() {
		ficheroEnCurso = 0; // Inicia
		if (ficheroEnCurso >= ficherosLista.size()) {
			ficheroEnCurso = -1; // Si no se encuentra, no hay selecci�n
			return false; // Y devuelve error
		}
		return true;
	}

	/**
	 * Seleciona el �ltimo fichero de la lista de reproducci�n
	 * 
	 * @return true si la selecci�n es correcta, false si hay error y no se puede
	 *         seleccionar
	 */
	public boolean irAUltimo() {
		ficheroEnCurso = ficherosLista.size() - 1; // Inicia al final
		if (ficheroEnCurso == -1) { // Si no se encuentra, no hay selecci�n
			return false; // Y devuelve error
		}
		return true;
	}

	/**
	 * Seleciona el anterior fichero de la lista de reproducci�n
	 * 
	 * @return true si la selecci�n es correcta, false si hay error y no se puede
	 *         seleccionar
	 */
	public boolean irAAnterior() {
		if (ficheroEnCurso >= 0)
			ficheroEnCurso--;
		if (ficheroEnCurso == -1) { // Si no se encuentra, no hay selecci�n
			return false; // Y devuelve error
		}
		return true;
	}

	/**
	 * Seleciona el siguiente fichero de la lista de reproducci�n
	 * 
	 * @return true si la selecci�n es correcta, false si hay error y no se puede
	 *         seleccionar
	 */
	public boolean irASiguiente() {
		ficheroEnCurso++;
		if (ficheroEnCurso >= ficherosLista.size()) {
			ficheroEnCurso = -1; // Si no se encuentra, no hay selecci�n
			return false; // Y devuelve error
		}
		return true;
	}

	/**
	 * Devuelve el fichero seleccionado de la lista
	 * 
	 * @return Posici�n del fichero seleccionado en la lista de reproducci�n (0 a
	 *         n-1), -1 si no lo hay
	 */
	public int getFicSeleccionado() {
		return ficheroEnCurso;
	}

	//
	// M�todos de DefaultListModel
	//

	@Override
	public int getSize() {
		return ficherosLista.size();
	}

	@Override
	public String getElementAt(int index) {
		return ficherosLista.get(index).getName();
	}

	// Escuchadores de datos de la lista
	ArrayList<ListDataListener> misEscuchadores = new ArrayList<>();

	@Override
	public void addListDataListener(ListDataListener l) {
		misEscuchadores.add(l);
	}

	@Override
	public void removeListDataListener(ListDataListener l) {
		misEscuchadores.remove(l);
	}

	// Llamar a este m�todo cuando se a�ada un elemento a la lista
	// (Utilizado para avisar a los escuchadores de cambio de datos de la lista)
	private void avisarAnyadido(int posi) {
		for (ListDataListener ldl : misEscuchadores) {
			ldl.intervalAdded(new ListDataEvent(this, ListDataEvent.INTERVAL_ADDED, posi, posi));
		}
	}
}
