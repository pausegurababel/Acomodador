package com.example.acomodador.models;

public class Butaca {

    int numFila;
    int numColumna;

    boolean ocupado;

    public Butaca(int numFila, int numColumna, boolean ocupado) {
        this.numFila = numFila;
        this.numColumna = numColumna;
        this.ocupado = ocupado;
    }

    public int getNumFila() {
        return numFila;
    }

    public void setNumFila(int numFila) {
        this.numFila = numFila;
    }

    public int getNumColumna() {
        return numColumna;
    }

    public void setNumColumna(int numColumna) {
        this.numColumna = numColumna;
    }

    public boolean isOcupado() {
        return ocupado;
    }

    public void setOcupado(boolean ocupado) {
        this.ocupado = ocupado;
    }
}
