package com.company.kainosSkaiciavimas;

import com.company.enums.Intervalas;
import com.company.strategijos.KainosSkaiciavimoStrategija;

import java.math.BigDecimal;

public class KarantinoKainosSkaiciavimas implements KainosSkaiciavimoStrategija {
    private final StandartinesKainosSkaiciavimas standartinesKainosSkaiciavimas = new StandartinesKainosSkaiciavimas();

    @Override
    public BigDecimal apskaiciuotiKelionesKaina(double atstumas, double laikas, Ikainiai ikainiai) {
        return standartinesKainosSkaiciavimas.apskaiciuotiKelionesKaina(atstumas, laikas, ikainiai).multiply(new BigDecimal("0.95"));
    }

    @Override
    public BigDecimal koreguotiSumineKaina(String is, String i, BigDecimal kaina) {
        return standartinesKainosSkaiciavimas.koreguotiSumineKaina(is, i, kaina);
    }

    @Override
    public BigDecimal skaiciuotiIlgalaikeKaina(Ikainiai ikainiai, Intervalas intervalas) {
        return standartinesKainosSkaiciavimas.skaiciuotiIlgalaikeKaina(ikainiai, intervalas).multiply(new BigDecimal("0.6"));
    }
}
