package com.example.acomodador.services;

import com.example.acomodador.models.Butaca;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Scanner;

@Service
public class MenuServices implements IMenuServices {

    private IImpresoraServices impresoraServices;

    private ICineServices cineServices;

    Scanner scanner;
    public MenuServices(ICineServices cineServices, IImpresoraServices impresoraServices){
        this.cineServices = cineServices;
        this.impresoraServices = impresoraServices;
        this.scanner = new Scanner(System.in);
    }
    @Override
    public void menu(int opt) {
        if (opt == 1) {
            impresoraServices.imprimirHeaderEntradas();
            int entradas = scanner.nextInt();
            List<Butaca> butacaList = cineServices.comprarEntradas(entradas);
            impresoraServices.imprimirEntradas(butacaList);
        } else if (opt == 2) {
            impresoraServices.imprimirHeaderButacasOcupadas();
            impresoraServices.imprimirEstadoCine();
        } else if (opt == 3) {
            return;
        } else {
            impresoraServices.imprimirOpcionEquivocada();
        }

    }
}
