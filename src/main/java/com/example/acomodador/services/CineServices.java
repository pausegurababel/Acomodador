package com.example.acomodador.services;

import com.example.acomodador.models.Butaca;
import com.example.acomodador.models.Cine;
import com.example.acomodador.repository.FakeDB;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CineServices implements ICineServices{

    private Cine cine;

    private FakeDB fakeDb;

    public CineServices() {
        this.cine = new Cine();
        this.fakeDb = new FakeDB();
    }

    public Cine getCine() {
        return cine;
    }
    public List<Butaca> comprarEntradas(int cantidad) {
        List<Butaca> butacasAsignadas = buscarMejorBloqueDeButacas(cantidad);
        if (!butacasAsignadas.isEmpty()) {
            for (Butaca butaca : butacasAsignadas) {
                asignarAsiento(butaca.getNumFila(), butaca.getNumColumna());
            }
        }
        return butacasAsignadas;
    }

    private List<Butaca> buscarMejorBloqueDeButacas(int cantidad) {
        int mejorDistancia = Integer.MAX_VALUE;
        List<Butaca> mejorBloque = null;
        Butaca[][] butacas = cine.getButacas();

        for (int i = 0; i < butacas.length; i++) {
            for (int j = 0; j <= butacas[i].length - cantidad; j++) {
                boolean todasLibres = true;
                for (int k = j; k < j + cantidad; k++) {
                    if (butacas[i][k].isOcupado()) {
                        todasLibres = false;
                        break;
                    }
                }

                if (todasLibres) {
                    int distanciaCentro = calcularDistanciaAlCentro(i, j, cantidad, butacas[i].length);
                    if (distanciaCentro < mejorDistancia) {
                        mejorDistancia = distanciaCentro;
                        mejorBloque = new ArrayList<>();
                        for (int k = j; k < j + cantidad; k++) {
                            mejorBloque.add(butacas[i][k]);
                        }
                    }
                }
            }
        }

        return mejorBloque;
    }

    private int calcularDistanciaAlCentro(int fila, int inicioBloque, int cantidad, int totalAsientos) {
        int centroFila = totalAsientos / 2;
        int centroBloque = inicioBloque + cantidad / 2;
        int distanciaCentralidad = Math.abs(centroBloque - centroFila);
        int distanciaPantalla = fila;
        int heuristica = distanciaCentralidad + distanciaPantalla;

        return heuristica;
    }



    public void asignarAsiento(int numFila, int numColumna) {
        for (int i = 0; i < cine.getButacas().length; i++) {
            for (int j = 0; j < cine.getButacas()[0].length; j++) {
                if (cine.getButacas()[i][j].getNumFila() == numFila && cine.getButacas()[i][j].getNumColumna() == numColumna) {
                    if (!cine.getButacas()[i][j].isOcupado()) {
                        cine.getButacas()[i][j].setOcupado(true);
                        fakeDb.ocuparButaca(cine.getButacas()[i][j]);
                    }
                }
            }
        }

    }

    public void imprimirCine() {
        for (int i = 0; i < cine.getButacas().length; i++) {
            for (int j = 0; j < cine.getButacas()[0].length; j++) {
                if (cine.getButacas()[i][j].isOcupado()) {
                    System.out.print("X");
                } else {
                    System.out.print("O");
                }
            }
            System.out.print("\n");

        }
    }
}

