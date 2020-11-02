package com.company.keliones;

import com.company.enums.Intervalas;
import com.company.kainosSkaiciavimas.Ikainiai;
import com.company.kainosSkaiciavimas.IkainiaiBuilder;
import com.company.kainosSkaiciavimas.StandartinesKainosSkaiciavimas;

import java.math.BigDecimal;

public class EkonomiskuAutomobiliuStandartineKaina extends KelioneEkonomiskuAutomobiliu {
    private final StandartinesKainosSkaiciavimas kainosSkaiciavimas;

    public EkonomiskuAutomobiliuStandartineKaina(int priemoneId, String isvykimoTaskas) throws IllegalArgumentException, UnsupportedOperationException {
        super(priemoneId, isvykimoTaskas);
        kainosSkaiciavimas = new StandartinesKainosSkaiciavimas();
    }

    @Override
    public Ikainiai gautiIkainius() {
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
    protected BigDecimal apskaiciuotiKelionesKaina(double atstumas, double laikas, Ikainiai ikainiai) {
        return kainosSkaiciavimas.apskaiciuotiKelionesKaina(atstumas, laikas, ikainiai);
    }

    @Override
    protected BigDecimal koreguotiSumineKaina(String is, String i, BigDecimal kaina) {
        return kainosSkaiciavimas.koreguotiSumineKaina(is, i, kaina);
    }

    @Override
    protected BigDecimal skaiciuotiIlgalaikeKaina(Ikainiai ikainiai, Intervalas intervalas) {
        return kainosSkaiciavimas.skaiciuotiIlgalaikeKaina(ikainiai, intervalas);
    }
}
