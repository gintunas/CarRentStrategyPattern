package com.company.kainosSkaiciavimas;

import com.company.enums.Intervalas;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class StandartinesKainosSkaiciavimas {

    public BigDecimal apskaiciuotiKelionesKaina(double atstumas, double laikas, Ikainiai ikainiai) {
        BigDecimal sumineKaina;
        BigDecimal atstumasDecimal = new BigDecimal(atstumas).divide(new BigDecimal(1000), RoundingMode.HALF_EVEN);
        BigDecimal laikasDecimal = new BigDecimal(laikas);

        BigDecimal virsytasAtstumas = atstumasDecimal.subtract(new BigDecimal(25));
        BigDecimal virsytasLaikas = laikasDecimal.subtract(new BigDecimal(30));

        sumineKaina = ikainiai.getPradineKaina().add(
                ikainiai.getKilometroKaina()
                        .multiply(atstumasDecimal));

        if (virsytasAtstumas.signum() == 1) sumineKaina = sumineKaina.add(
                virsytasAtstumas.multiply(ikainiai.getVirsytoAtstumoKaina()));

        sumineKaina = sumineKaina.add(
                ikainiai.getMinutesKaina()
                        .multiply(laikasDecimal)
        );

        if (virsytasLaikas.signum() == 1) sumineKaina = sumineKaina.add(
                virsytasLaikas.multiply(ikainiai.getVirsytoLaikoKaina()));

        return sumineKaina;
    }

    public BigDecimal koreguotiSumineKaina(String is, String i, BigDecimal kaina) {
        if (is.equals("Vilniaus oro uostas") || i.equals("Vilniaus oro uostas")) {
            kaina = kaina.add(new BigDecimal(200));
            System.out.println("Prie Jusu keliones mokescio prideta 2 € suma, nes keliavote pro Vilniaus oro uosta.");
        }
        return kaina;
    }

    public BigDecimal skaiciuotiIlgalaikeKaina(Ikainiai ikainiai, Intervalas intervalas) throws IllegalArgumentException {
        BigDecimal sumineKaina;
        switch (intervalas) {
            case PARA:
                sumineKaina = ikainiai.getParosKaina();
                break;
            case SAVAITE:
                sumineKaina = ikainiai.getSavaitesKaina();
                break;
            case MENESIS:
                sumineKaina = ikainiai.getMenesioKaina();
                break;
            default:
                throw new IllegalArgumentException("Nenustatytas nuomos intervalas.");
        }
        return sumineKaina;
    }
}