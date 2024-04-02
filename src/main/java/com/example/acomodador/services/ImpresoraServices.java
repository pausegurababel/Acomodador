package com.example.acomodador.services;

import com.example.acomodador.models.Butaca;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ImpresoraServices implements IImpresoraServices{

    private ICineServices cineServices;
    public ImpresoraServices(ICineServices cineServices){
        this.cineServices = cineServices;

    }
    @Override
    public void imprimirMenu() {
        System.out.println("Bienvenido al Cine Paradiso");
        System.out.println("Que quieres hacer?");
        System.out.println(
                "1. Comprar entradas\n" +
                        "2. Ver estado del cine\n" +
                        "3. Salir");
    }

    @Override
    public void imprimirEntradas(List<Butaca> lista) {
        for (int i = 0; i < lista.size();i++){
            System.out.println("BUTACA EN:");
            System.out.println("FILA " + lista.get(i).getNumFila() + " COLUMNA " + lista.get(i).getNumColumna());
        }

    }

    @Override
    public void imprimirHeaderEntradas() {
        System.out.println("Cuantas entradas quieres comprar?");
    }

    @Override
    public void imprimirHeaderButacasOcupadas() {
        System.out.println("ESTADO CINE");

    }

    @Override
    public void imprimirEstadoCine(){
        cineServices.imprimirCine();
    }

    @Override
    public void imprimirOpcionEquivocada() {
        System.out.println("Opcion no válida");
    }
}
