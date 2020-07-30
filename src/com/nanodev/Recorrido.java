package com.nanodev;

import java.util.ArrayList;

public class Recorrido
{
	private ArrayList<Nodo> recorridoNodos;
	private Nodo nodoFuente;
	private Nodo nodoDestino;
	private int distanciaAcumulada;

	public Recorrido(Nodo nodoFuente, Nodo nodoDestino) {
		this.recorridoNodos = new ArrayList<>();
		this.nodoFuente = nodoFuente;
		this.nodoDestino = nodoDestino;
	}

	public  void addRecorridoNodos(Nodo nodo){
		this.recorridoNodos.add(nodo);
	}

	public ArrayList<Nodo> getRecorridoNodos() {
		return this.recorridoNodos;
	}

	public Nodo getNodoFuente() {
		return nodoFuente;
	}

	public void setNodoFuente(Nodo nodoFuente) {
		this.nodoFuente = nodoFuente;
	}

	public Nodo getNodoDestino() {
		return nodoDestino;
	}

	public void setNodoDestino(Nodo nodoDestino) {
		this.nodoDestino = nodoDestino;
	}

	public int getDistanciaAcumulada() {
		return distanciaAcumulada;
	}

	public void setDistanciaAcumulada(int distanciaAcumulada) {
		this.distanciaAcumulada = distanciaAcumulada;
	}
	public void addDistanciaAcumulada(int distanciaAcumulada) {
		this.distanciaAcumulada += distanciaAcumulada;
	}
}
