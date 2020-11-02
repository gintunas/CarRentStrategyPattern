package com.company.keliones;

import com.company.kainosSkaiciavimas.Ikainiai;
import com.company.kainosSkaiciavimas.IkainiaiBuilder;

public abstract class KelionePrabangiuAutomobiliu extends Kelione {
    private final Ikainiai ikainiai = new IkainiaiBuilder()
            .setPradineKaina(300)
            .setKilometroKaina(50)
            .setMinutesKaina(20)
            .setVirsytoLaikoKaina(10)
            .setVirsytoAtstumoKaina(10)
            .setParosKaina(4000)
            .setSavaitesKaina(20000)
            .setMenesioKaina(400000)
            .createIkainiai();
    private String transportoPriemonesPavadinimas = "Lexus RC 300";

    public KelionePrabangiuAutomobiliu(int priemoneId, String isvykimoTaskas) throws UnsupportedOperationException {
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
        System.out.println("Paliktas Lexus RC 300, id: " + getPriemoneId());
    }

    @Override
    public void pranestiApieNetiketuma() {
        System.out.println("Dekojame uz pranesta Lexus RC 300, id: " + getPriemoneId() + " apgadinima.");
    }
}
