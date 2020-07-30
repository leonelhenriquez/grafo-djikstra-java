package com.nanodev;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        Grafo g1 = new Grafo();
        Nodo A = new Nodo("A");
        Nodo B = new Nodo("B");
        Nodo C = new Nodo("C");
        Nodo D = new Nodo("D");
        Nodo E = new Nodo("E");
        Nodo F = new Nodo("F");
        Nodo G = new Nodo("G");


        g1.addNodos(A,B,C,D,E,F,G);

        g1.addArista( A, B, 3);
        g1.addArista( A, C, 2);
        g1.addArista( A, E, 7);
        g1.addArista( A, F, 2);

        //g1.addArista( B, A, 3);
        g1.addArista( B, C, 3);

        //g1.addArista( C, A, 2);
        //g1.addArista( C, B, 3);
        g1.addArista( C, D, 20);

        //g1.addArista( D, C, 20);
        g1.addArista( D, E, 8);
		g1.addArista( D, G, 3);

        //g1.addArista( E, A, 7);
        //g1.addArista( E, D, 8);
		g1.addArista( E, F, 3);
		g1.addArista( E, G, 2);

		//g1.addArista( F, A, 2);
		//g1.addArista( F, E, 3);
		g1.addArista( F, G, 5);

		//g1.addArista( G, F, 5);
		//g1.addArista( G, E, 5);
		//g1.addArista( G, D, 5);

        g1.generarMatriz();
        Arista[][] matriz = g1.getMatriz();
        for (int i = 0; i < g1.getNodos().size(); i++) {
            for (int j = 0; j < g1.getNodos().size(); j++) {
                System.out.print((matriz[i][j]==null ? "▀" :
                        matriz[i][j].getDistancia())  + "\t");
            }
            System.out.println();
        }

        int source = 3;
        ArrayList<Recorrido> dist = g1.calcularDistancias(D);

        System.out.println("\nFuente \t"+source+"\t resultados : ");
        for(int i=0;i<dist.size();i++){
            System.out.println("\nfuente :"+D.getNombre()+"\t destino :"+g1.getNodo(i).getNombre()+"\t distancia:"+dist.get(i).getDistanciaAcumulada()+"\t");


            System.out.print("Recorrido:\n"+dist.get(i).getNodoFuente().getNombre()+"-");
            for(Nodo a: dist.get(i).getRecorridoNodos()){
                System.out.print(a.getNombre()+"-");
            }
            System.out.print(dist.get(i).getNodoDestino().getNombre()+"\n");
        }
    }
}
