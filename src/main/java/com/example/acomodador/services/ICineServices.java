package com.example.acomodador.services;

import com.example.acomodador.models.Butaca;

import java.util.List;

public interface ICineServices {
    void imprimirCine();

    void asignarAsiento(int numFila, int numColumna);


    List<Butaca> comprarEntradas(int entradas);
}
