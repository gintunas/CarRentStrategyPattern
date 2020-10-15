package com.company;

import com.company.enums.Intervalas;
import com.company.enums.KainosTipas;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        Naudotojas stasys = new Naudotojas(new ArrayList<>(), new ArrayList<>());
        Kelione kelione;

        kelione = stasys.pradetiKelione(515, "Aukstieji Paneriai", KainosTipas.STANDARTINE);
        kelione.getTransportoPriemone().pranestiApieNetiketuma();
        stasys.uzbaigtiKelione(3000, 20, "Neries stotele");

        System.out.println();

        kelione = stasys.pradetiKelione(16450, "Daniliskes", KainosTipas.KARANTINO);
        System.out.println(kelione.getTransportoPriemonesPavadinimas());
        stasys.uzbaigtiKelione(20000, Intervalas.PARA);

        System.out.println();

        stasys.pradetiPavezima(35000, "Fabijoniskiu g. 99C", KainosTipas.KARANTINO);
        stasys.uzbaigtiPavezima(7000, 15, "Vilniaus oro uostas");

        System.out.println();

        stasys.pradetiPavezima(35000, "Fabijoniskiu g. 99C", KainosTipas.KARANTINO);
        stasys.uzbaigtiPavezima(7000, 15, "Pilaites pr. 66");
    }
}
