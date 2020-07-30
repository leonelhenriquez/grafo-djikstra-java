package com.nanodev;


import java.util.ArrayList;

public class Nodo {
	private String nombre;
	//private ArrayList<Arista> aristas;

	public Nodo(String nombre){
		this.setNombre(nombre);
		//aristas = new ArrayList<Arista>();
	}

	/*public void addArista(Arista v){
		this.aristas.add(v);
	}

	public ArrayList<Arista> getVertices() {
		return aristas;
	}*/

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public boolean equalsNodo(Nodo n){
		return this.nombre.equals(n.nombre);
	}

}
