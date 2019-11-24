package es.deusto.prog3.cap03.resueltos.miniAmazon;

public class Compra {

	private int id;
	private long fecha;
	private int cantidad;
	private Producto producto;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public long getFecha() {
		return fecha;
	}
	public void setFecha(long fecha) {
		this.fecha = fecha;
	}
	public int getCantidad() {
		return cantidad;
	}
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	public Producto getProducto() {
		return producto;
	}
	public void setProducto(Producto producto) {
		this.producto = producto;
	}
	public Compra(int id, long fecha, int cantidad, Producto producto) {
		super();
		this.id = id;
		this.fecha = fecha;
		this.cantidad = cantidad;
		this.producto = producto;
	}
	
}
