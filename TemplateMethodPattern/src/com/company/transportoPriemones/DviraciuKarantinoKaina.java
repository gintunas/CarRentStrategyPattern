package com.company.transportoPriemones;

import com.company.enums.Intervalas;
import com.company.kainosSkaiciavimas.Ikainiai;
import com.company.kainosSkaiciavimas.KarantinoKainosSkaiciavimas;

import java.math.BigDecimal;

public class DviraciuKarantinoKaina extends KelioneDviraciu {
    private final KarantinoKainosSkaiciavimas kainosSkaiciavimas;

    public DviraciuKarantinoKaina(int priemoneId, String isvykimoTaskas) throws IllegalArgumentException, UnsupportedOperationException {
        super(priemoneId, isvykimoTaskas);
        kainosSkaiciavimas = new KarantinoKainosSkaiciavimas();
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