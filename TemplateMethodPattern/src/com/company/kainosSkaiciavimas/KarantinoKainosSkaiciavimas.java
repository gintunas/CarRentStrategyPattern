package com.company.kainosSkaiciavimas;

import com.company.enums.Intervalas;
import com.company.strategijos.KainosSkaiciavimoStrategija;

import java.math.BigDecimal;

public class KarantinoKainosSkaiciavimas {
    private final StandartinesKainosSkaiciavimas standartinesKainosSkaiciavimas = new StandartinesKainosSkaiciavimas();

    public BigDecimal apskaiciuotiKelionesKaina(double atstumas, double laikas, Ikainiai ikainiai) {
        return standartinesKainosSkaiciavimas.apskaiciuotiKelionesKaina(atstumas, laikas, ikainiai).multiply(new BigDecimal("0.95"));
    }

    public BigDecimal koreguotiSumineKaina(String is, String i, BigDecimal kaina) {
        return standartinesKainosSkaiciavimas.koreguotiSumineKaina(is, i, kaina);
    }

    public BigDecimal skaiciuotiIlgalaikeKaina(Ikainiai ikainiai, Intervalas intervalas) {
        return standartinesKainosSkaiciavimas.skaiciuotiIlgalaikeKaina(ikainiai, intervalas).multiply(new BigDecimal("0.6"));
    }
}
