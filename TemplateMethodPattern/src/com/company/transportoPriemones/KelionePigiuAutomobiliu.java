package com.company.transportoPriemones;

import com.company.Kelione;
import com.company.kainosSkaiciavimas.Ikainiai;
import com.company.kainosSkaiciavimas.IkainiaiBuilder;

public abstract class KelionePigiuAutomobiliu extends Kelione {
    private int priemoneId;

    public KelionePigiuAutomobiliu(int priemoneId, String isvykimoTaskas) {
        super(priemoneId, isvykimoTaskas);

        transportoPriemonesPavadinimas = pasirinktiTransportoPriemone(priemoneId);
        if (transportoPriemonesPavadinimas.isEmpty())
            throw new UnsupportedOperationException("Nepavyko pasirinkti transporto priemones.");

        ikainiai = gautiTransportoPriemonesIkainius();
    }


    @Override
    public Ikainiai gautiTransportoPriemonesIkainius() {
        return new IkainiaiBuilder()
                .setPradineKaina(100)
                .setKilometroKaina(30)
                .setMinutesKaina(14)
                .setVirsytoLaikoKaina(6)
                .setVirsytoAtstumoKaina(5)
                .setParosKaina(1500)
                .setSavaitesKaina(7500)
                .setMenesioKaina(30000)
                .createIkainiai();
    }

    @Override
    public String pasirinktiTransportoPriemone(int priemoneId) {
        //if(priemoneID nepasirinktas) pasirinkti
        this.priemoneId = priemoneId;
        return "Honda Civic 5 gen.";
        //else return null;
    }

    @Override
    public void paliktiTransportoPriemone() {
        //palikti priemoneId
        System.out.println("Paliktas Honda Civic, id: " + priemoneId);
    }

    @Override
    public void pranestiApieNetiketuma() {
        System.out.println("Dekojame uz pranesta Honda Civic, id: " + priemoneId + " apgadinima.");
    }
}
