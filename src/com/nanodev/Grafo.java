package com.nanodev;


import java.util.ArrayList;

public class Grafo {
	private ArrayList<Nodo> nodos;
	private ArrayList<Arista> aristas;
	private Arista[][] matriz;

	public Grafo(){
		this.nodos = new ArrayList<Nodo>();
		this.aristas = new ArrayList<Arista>();
	}

	public void addNodo(Nodo n){
		this.nodos.add(n);
		/*for (Arista v : n.getVertices()) {
			this.aristas.add(v);
		}*/
	}public void addNodos(Nodo... nodos){
		for (Nodo nodo : nodos){
			this.addNodo(nodo);
		}
	}

	public Nodo getNodo(int index){
		return this.nodos.get(index);
	}

	public void addArista(Nodo n1, Nodo n2, int distancia){
		this.addArista(n1, n2, distancia, false);
	}
	public void addArista(Nodo n1, Nodo n2, int distancia,boolean dirigido){
		this.aristas.add(new Arista(n1,n2,distancia));
		if(!dirigido){
			this.aristas.add(new Arista(n2,n1,distancia));
		}
	}

	public ArrayList<Nodo> getNodos() {
		return nodos;
	}

	public ArrayList<Arista> getAristas() {
		return aristas;
	}

	public int indexOfNodo(Nodo n){
		int pos = 0;
		for (Nodo n2 : nodos) {
			if (n.equalsNodo(n2)) break;
			pos++;
		}
		return pos;
	}

	public Arista[][] getMatriz() {
		if(this.matriz==null)this.generarMatriz();
		return matriz;
	}

	public void generarMatriz(){
		this.matriz = new Arista[this.getNodos().size()][this.getNodos().size()];
		for (int i = 0; i < this.getNodos().size(); i++){
			for (int j = 0; j < this.getNodos().size(); j++) {
				if (i == j) this.matriz[i][j] = new Arista(null,null,0);
			}
		}
		for (Arista a : this.getAristas()){
			//Nodo n1 = a.getNodos().get(0);
			//Nodo n2 = a.getNodos().get(1);
			int i = this.indexOfNodo(a.getNodoInicio());
			int j = this.indexOfNodo(a.getNodoFin());
			this.matriz[i][j] = a;
			/*if(!a.isDirigido()){
				this.matriz[j][i] = a;
			}*/
		}
	}
	public ArrayList<Recorrido> calcularDistancias(Nodo source){

		int n = this.nodos.size();
		ArrayList<Recorrido> recorrido = new ArrayList<>();
		int flag[] = new int[n];
		int i = 0,minpos=0,k,c,minimum;
		boolean agregar;

		this.generarMatriz();
		int p = this.indexOfNodo(source);

		if(p!=-1){
			for(i=0;i<n;i++) {
				recorrido.add(new Recorrido(source,this.getNodo(i)));
				recorrido.get(i).setDistanciaAcumulada(
					this.matriz[p][i]==null ? Arista.MAX_DIST : this.matriz[p][i].getDistancia()
				);
			}
			c=0;
			while(c<n) {
				minimum= Arista.MAX_DIST;
				for(k=0;k<n;k++) {
					if(recorrido.get(k).getDistanciaAcumulada()<minimum && flag[k]!=1) {
						minimum = recorrido.get(k).getDistanciaAcumulada();
						minpos=k;
					}
				}
				c++;
				flag[minpos]=1;
				for(k=0;k<n;k++) {
					if(this.matriz[minpos][k]!=null) {
						if (recorrido.get(minpos).getDistanciaAcumulada() + this.matriz[minpos][k].getDistancia() < recorrido.get(k).getDistanciaAcumulada()
								&& flag[k] != 1
						) {
							for(Nodo nod: recorrido.get(minpos).getRecorridoNodos()){
								agregar = true;
								for(Nodo nod2: recorrido.get(k).getRecorridoNodos()){
									if(nod2.equalsNodo(nod)){
										agregar = false;
										break;
									}
								}
								if(agregar)recorrido.get(k).addRecorridoNodos(nod);
							}
							recorrido.get(k).addRecorridoNodos(this.matriz[minpos][k].getNodoInicio());
							recorrido.get(k).setDistanciaAcumulada(recorrido.get(minpos).getDistanciaAcumulada()+this.matriz[minpos][k].getDistancia());
						}
					}
				}
			}
		}
		return recorrido;
	}
}
