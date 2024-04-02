package com.example.acomodador.services;

import com.example.acomodador.models.Butaca;

import java.util.List;

public interface IImpresoraServices {
    void imprimirMenu();

    void imprimirEntradas(List<Butaca> lista);

    void imprimirHeaderEntradas();

    void imprimirHeaderButacasOcupadas();

    void imprimirEstadoCine();

    void imprimirOpcionEquivocada();
}
