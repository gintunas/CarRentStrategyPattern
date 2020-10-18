package com.company.transportoPriemones;

import com.company.Kelione;
import com.company.kainosSkaiciavimas.Ikainiai;
import com.company.kainosSkaiciavimas.IkainiaiBuilder;

public abstract class KelionePrabangiuAutomobiliu extends Kelione {
    private int priemoneId;

    public KelionePrabangiuAutomobiliu(int priemoneId, String isvykimoTaskas) throws IllegalArgumentException, UnsupportedOperationException {
        super(priemoneId, isvykimoTaskas);

        if (!((priemoneId > 20000) && (priemoneId < 30000)))
            throw new IllegalArgumentException("Nera transporto priemones su tokiu identifikaciniu numeriu.");

        transportoPriemonesPavadinimas = pasirinktiTransportoPriemone(priemoneId);
        if (transportoPriemonesPavadinimas.isEmpty())
            throw new UnsupportedOperationException("Nepavyko pasirinkti transporto priemones.");

        ikainiai = gautiTransportoPriemonesIkainius();
    }

    @Override
    public String pasirinktiTransportoPriemone(int priemoneId) {
        //if(priemoneID nepasirinktas) pasirinkti
        this.priemoneId = priemoneId;
        return "Lexus RC 300";
        //else return null;
    }

    @Override
    public Ikainiai gautiTransportoPriemonesIkainius() {
        return new IkainiaiBuilder()
                .setPradineKaina(300)
                .setKilometroKaina(50)
                .setMinutesKaina(20)
                .setVirsytoLaikoKaina(10)
                .setVirsytoAtstumoKaina(10)
                .setParosKaina(4000)
                .setSavaitesKaina(20000)
                .setMenesioKaina(400000)
                .createIkainiai();
    }

    @Override
    public void paliktiTransportoPriemone() {
        //palikti priemoneId
        System.out.println("Paliktas Lexus RC 300, id: " + priemoneId);
    }

    @Override
    public void pranestiApieNetiketuma() {
        System.out.println("Dekojame uz pranesta Lexus RC 300, id: " + priemoneId + " apgadinima.");
    }
}
