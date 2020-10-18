package com.company.strategijos;

import com.company.enums.Intervalas;
import com.company.kainosSkaiciavimas.Ikainiai;

import java.math.BigDecimal;

public interface KainosSkaiciavimoStrategija {
    /**
     *
     * @param atstumas Atstumas metrais
     * @param laikas Laikas minutemis.
     * @return keliones kaina
     */
    BigDecimal apskaiciuotiKelionesKaina(double atstumas, double laikas, Ikainiai ikainiai);

    BigDecimal koreguotiSumineKaina(String is, String i, BigDecimal kaina);

    BigDecimal skaiciuotiIlgalaikeKaina(Ikainiai ikainiai, Intervalas intervalas);
}
