package com.company.pavezimai;

import com.company.kainosSkaiciavimas.Ikainiai;
import com.company.kainosSkaiciavimas.KarantinoKainosSkaiciavimas;

import java.math.BigDecimal;

public class PavezimasKarantinoKaina extends Pavezimas {
    private final KarantinoKainosSkaiciavimas kainosSkaiciavimas;

    public PavezimasKarantinoKaina(int vairuotojasId, String isvykimoTaskas) {
        super(vairuotojasId, isvykimoTaskas);
        kainosSkaiciavimas = new KarantinoKainosSkaiciavimas();
    }

    @Override
    protected BigDecimal koreguotiSumineKaina(String isvykimoTaskas, String atvykimoTaskas, BigDecimal sumineKaina) {
        return kainosSkaiciavimas.koreguotiSumineKaina(isvykimoTaskas, atvykimoTaskas, sumineKaina);
    }

    @Override
    protected BigDecimal apskaiciuotiKelionesKaina(double atstumas, double laikas, Ikainiai ikainiai) {
        return kainosSkaiciavimas.apskaiciuotiKelionesKaina(atstumas, laikas, ikainiai);
    }
}
