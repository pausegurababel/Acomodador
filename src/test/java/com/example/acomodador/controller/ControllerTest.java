package com.example.acomodador.controller;

import com.example.acomodador.services.ICineServices;
import com.example.acomodador.services.IImpresoraServices;
import com.example.acomodador.services.IMenuServices;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;

class ControllerTest {

    private Controller sut;
    private IImpresoraServices impresoraServices ;

    private IMenuServices menuServices;

    @BeforeEach
    void setUp(){
        impresoraServices = Mockito.mock(IImpresoraServices.class);
        menuServices = Mockito.mock(IMenuServices.class);
        sut = new Controller(menuServices, impresoraServices);

    }






}