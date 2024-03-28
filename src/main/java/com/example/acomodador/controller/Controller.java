package com.example.acomodador.controller;

import com.example.acomodador.models.Butaca;
import com.example.acomodador.services.ICineServices;
import org.springframework.stereotype.Component;
import org.yaml.snakeyaml.emitter.ScalarAnalysis;

import javax.swing.plaf.synth.SynthDesktopIconUI;
import java.util.List;
import java.util.Scanner;

@Component
public class Controller {

    private final ICineServices cineServices;

    public Controller(ICineServices cineServices){
        this.cineServices = cineServices;
    }

    public void run() {
        Scanner scanner = new Scanner(System.in);
        imprimirBienvenida();
        while (true) {
            imprimirOpciones();
            int opt = scanner.nextInt();
            if (opt == 1) {
                System.out.println("Cuantas entradas quieres comprar?");
                int entradas = scanner.nextInt();
                List<Butaca> butacaList = cineServices.comprarEntradas(entradas);
                imprimirEntradas(butacaList);
            } else if (opt == 2) {
                System.out.println("ESTADO CINE");
                this.cineServices.imprimirCine();
            } else if (opt == 3) {
                return;
            } else {
                System.out.println("Opcion no válida");
            }

        }
    }

    private void imprimirBienvenida(){
        System.out.println("Bienvenido al Cine Paradiso");
    }
    private void imprimirOpciones(){
        System.out.println("Que quieres hacer?");
        System.out.println(
                "1. Comprar entradas\n" +
                "2. Ver estado del cine\n" +
                "3. Salir");
    }
    private void imprimirEntradas(List<Butaca> lista){
        for (int i = 0; i < lista.size();i++){
            System.out.println("BUTACA EN:");
            System.out.println("FILA " + lista.get(i).getNumFila() + " COLUMNA " + lista.get(i).getNumColumna());
        }
    }
}


