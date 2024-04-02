package com.example.acomodador.controller;

import com.example.acomodador.models.Butaca;
import com.example.acomodador.services.ICineServices;
import com.example.acomodador.services.IImpresoraServices;
import com.example.acomodador.services.IMenuServices;
import org.springframework.stereotype.Component;
import org.yaml.snakeyaml.emitter.ScalarAnalysis;

import javax.swing.plaf.synth.SynthDesktopIconUI;
import java.util.List;
import java.util.Scanner;

@Component
public class Controller {



    private final IMenuServices menuServices;
    private final IImpresoraServices impresoraServices;

    public Controller(IMenuServices menuServices, IImpresoraServices impresoraServices){
        this.menuServices = menuServices;
        this.impresoraServices = impresoraServices;
    }

    public void run() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            impresoraServices.imprimirMenu();
            int opt = scanner.nextInt();
            menuServices.menu(opt);

        }
    }

}


