package com.company.keliones;

import com.company.kainosSkaiciavimas.Ikainiai;
import com.company.kainosSkaiciavimas.IkainiaiBuilder;

public abstract class KelioneDviraciu extends Kelione {
    private final String transportoPriemonesPavadinimas = "Rambynas 300";
    private final Ikainiai ikainiai = new IkainiaiBuilder()
            .setPradineKaina(10)
            .setKilometroKaina(0)
            .setMinutesKaina(0)
            .setVirsytoLaikoKaina(20)
            .setVirsytoAtstumoKaina(0)
            .setParosKaina(300)
            .setSavaitesKaina(1500)
            .setMenesioKaina(3000)
            .createIkainiai();

    public KelioneDviraciu(int priemoneId, String isvykimoTaskas) throws IllegalArgumentException, UnsupportedOperationException {
        super(priemoneId, isvykimoTaskas);
    }

    @Override
    public String gautiTransportoPriemonesPavadinima() {
        return transportoPriemonesPavadinimas;
    }

    @Override
    public Ikainiai gautiTransportoPriemonesIkainius() {
        return ikainiai;
    }

    @Override
    public void paliktiTransportoPriemone() {
        //palikti priemoneId
        System.out.println("Paliktas Rambynas 300, id: " + getPriemoneId());
    }

    @Override
    public void pranestiApieNetiketuma() {
        System.out.println("Dekojame uz pranesta dviracio Rambynas 300, id: " + getPriemoneId() + " apgadinima.");
    }
}