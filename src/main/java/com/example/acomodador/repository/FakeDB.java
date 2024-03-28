package com.example.acomodador.repository;

import com.example.acomodador.models.Butaca;

import java.util.ArrayList;
import java.util.List;

public class FakeDB {

    private static List<Butaca> butacasOcupadas;

    public FakeDB(){
        butacasOcupadas = new ArrayList<>();
    }


    public void ocuparButaca(Butaca butaca) {
        butacasOcupadas.add(butaca);
    }

    public static List<Butaca> getButacasOcupadas() {
        return butacasOcupadas;
    }
}
