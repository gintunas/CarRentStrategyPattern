package com.company.keliones;

import com.company.enums.Intervalas;
import com.company.kainosSkaiciavimas.Ikainiai;
import com.company.kainosSkaiciavimas.StandartinesKainosSkaiciavimas;

import java.math.BigDecimal;

public class DviraciuStandartineKaina extends KelioneDviraciu {
    private final StandartinesKainosSkaiciavimas kainosSkaiciavimas;

    public DviraciuStandartineKaina(int priemoneId, String isvykimoTaskas) throws IllegalArgumentException, UnsupportedOperationException {
        super(priemoneId, isvykimoTaskas);
        kainosSkaiciavimas = new StandartinesKainosSkaiciavimas();
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