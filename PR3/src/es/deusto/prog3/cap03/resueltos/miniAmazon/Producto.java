package es.deusto.prog3.cap03.resueltos.miniAmazon;

import java.util.ArrayList;

public class Producto {

	private int id;
	public Producto(int id, String nombre, float precio, ArrayList<Compra> listaCompra) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.precio = precio;
		this.listaCompra = listaCompra;
	}
	private String nombre;
	private float precio;
	private ArrayList<Compra> listaCompra;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public float getPrecio() {
		return precio;
	}
	public void setPrecio(float precio) {
		this.precio = precio;
	}
	public ArrayList<Compra> getListaCompra() {
		return listaCompra;
	}
	public void setListaCompra(ArrayList<Compra> listaCompra) {
		this.listaCompra = listaCompra;
	}
	
}
