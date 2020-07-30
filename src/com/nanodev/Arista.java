package com.nanodev;


import java.util.ArrayList;

public class Arista {
	public static final int MAX_DIST = Integer.MAX_VALUE/2;
	private int distancia;
	private static int numArista = 0;
	private int id;
	//private ArrayList<Nodo> nodos;
	//private boolean dirigido = false;
	private Nodo nodoInicio;
	private Nodo nodoFin;

	public Arista(Nodo nodoInicio, Nodo nodoFin, int distancia){
		/*this.nodos = new ArrayList<Nodo>();
		nodos.add(n1);
		nodos.add(n2);*/
		numArista++;
		id = numArista;
		this.setNodoInicio(nodoInicio);
		this.setNodoFin(nodoFin);
		this.setDistancia(distancia);
		//n1.addArista(this);
		//n2.addArista(this);
	}

	/*public Arista(Nodo nodoInicio, Nodo nodoFin, int distancia, boolean dirigido) {
		this(nodoInicio,nodoFin,distancia);
		this.dirigido = dirigido;
	}*/

	public Nodo getNodoInicio() {
		return nodoInicio;
	}

	public void setNodoInicio(Nodo nodoInicio) {
		this.nodoInicio = nodoInicio;
	}

	public Nodo getNodoFin() {
		return nodoFin;
	}

	public void setNodoFin(Nodo nodoFin) {
		this.nodoFin = nodoFin;
	}

	/*public ArrayList<Nodo> getNodos() {
		return nodos;
	}*/

	/*public void setNodos(ArrayList<Nodo> nodos) {
		this.nodos = nodos;
	}*/

	public int getDistancia() {
		return distancia;
	}

	public void setDistancia(int distancia) {
		this.distancia = distancia;
	}

	/*public boolean isDirigido() {
		return dirigido;
	}

	public void setDirigido(boolean dirigido) {
		this.dirigido = dirigido;
	}*/

	public boolean equalsArista(Arista v){
		return this.id == v.id;
	}

}
