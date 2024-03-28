package com.example.acomodador.models;

public class Cine {

    private Butaca[][] butacas;

    public Cine() {
        this.butacas = new Butaca[9][10];
        inicializarButacas();
    }

    private void inicializarButacas(){
        int[] ordenAsientos = {8, 6, 4, 2, 0, 1, 3, 5, 7, 9};

        for (int i = 0; i < 9; i ++){
            for (int j = 0; j < ordenAsientos.length;j++){
                Butaca butaca = new Butaca(i+1,ordenAsientos[j] + 1, false);
                butacas[i][j] = butaca;
            }
        }
    }

    public Butaca[][] getButacas() {
        return butacas;
    }

    public void setButacas(Butaca[][] butacas) {
        this.butacas = butacas;
    }
}
