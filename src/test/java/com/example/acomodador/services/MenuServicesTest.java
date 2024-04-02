package com.example.acomodador.services;

import com.example.acomodador.models.Butaca;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.test.util.ReflectionTestUtils;

import java.nio.Buffer;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.*;

class MenuServicesTest {

    private ICineServices cineServices;

    private IImpresoraServices impresoraServices;

    private MenuServices sut;

    private Scanner scannerMock;

    @BeforeEach
    void setUp(){
        cineServices = Mockito.mock(ICineServices.class);
        impresoraServices = Mockito.mock(IImpresoraServices.class);
        this.scannerMock = Mockito.mock(Scanner.class);
        sut = new MenuServices(cineServices, impresoraServices);
        ReflectionTestUtils.setField(this.sut, "scanner", this.scannerMock);

    }
    @Test
    void menu_shouldComprarEntradas_when_optIs1AndEntradasIs2(){

        //Given
        when(this.scannerMock.nextInt()).thenReturn(2);
        List<Butaca> butacasExpected = new ArrayList<>();
        butacasExpected.add(new Butaca(1,1,false));
        butacasExpected.add(new Butaca(25,90,false));
        when(this.cineServices.comprarEntradas(eq(2))).thenReturn(butacasExpected);
        //When
        this.sut.menu(1);
        //Then
        verify(this.impresoraServices, times(1)).imprimirEntradas(eq(butacasExpected));
    }

    @Test
    void menu_shouldImprimirCine_when_optIs2(){
        //Given
        //When
        this.sut.menu(2);
        //Then
        verify(this.impresoraServices, times(1))
                .imprimirHeaderButacasOcupadas();

        verify(this.impresoraServices,times(1)).imprimirEstadoCine();

    }

}