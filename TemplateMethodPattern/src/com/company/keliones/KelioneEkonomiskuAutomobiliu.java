package com.company.keliones;

import com.company.kainosSkaiciavimas.Ikainiai;
import com.company.kainosSkaiciavimas.IkainiaiBuilder;

public abstract class KelioneEkonomiskuAutomobiliu extends Kelione {
    private final String transportoPriemonesPavadinimas = "Honda Civic 5 gen.";
    private final Ikainiai ikainiai = new IkainiaiBuilder()
            .setPradineKaina(100)
            .setKilometroKaina(30)
            .setMinutesKaina(14)
            .setVirsytoLaikoKaina(6)
            .setVirsytoAtstumoKaina(5)
            .setParosKaina(1500)
            .setSavaitesKaina(7500)
            .setMenesioKaina(30000)
            .createIkainiai();

    public KelioneEkonomiskuAutomobiliu(int priemoneId, String isvykimoTaskas) {
        super(priemoneId, isvykimoTaskas);
    }

    @Override
    public Ikainiai gautiTransportoPriemonesIkainius() {
        return ikainiai;
    }

    @Override
    public String gautiTransportoPriemonesPavadinima() {
        return transportoPriemonesPavadinimas;
    }

    @Override
    public void paliktiTransportoPriemone() {
        //palikti priemoneId
        System.out.println("Paliktas Honda Civic, id: " + getPriemoneId());
    }

    @Override
    public void pranestiApieNetiketuma() {
        System.out.println("Dekojame uz pranesta Honda Civic, id: " + getPriemoneId() + " apgadinima.");
    }
}
