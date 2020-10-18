package com.company;

import com.company.enums.KainosTipas;
import com.company.kainosSkaiciavimas.Ikainiai;
import com.company.kainosSkaiciavimas.IkainiaiBuilder;
import com.company.kainosSkaiciavimas.KarantinoKainosSkaiciavimas;
import com.company.kainosSkaiciavimas.StandartinesKainosSkaiciavimas;
import com.company.strategijos.KainosSkaiciavimoStrategija;

import java.math.BigDecimal;

public class Pavezimas {
    private final KainosSkaiciavimoStrategija kss;
    private final Ikainiai ikainiai;
    private final int vairuotojasId;
    private final String vairuotojoVardas;
    private final String isvykimoTaskas;
    private String atvykimoTaskas;
    private double atstumas;
    private double laikas;
    private BigDecimal kaina;

    public Pavezimas(int vairuotojasId, String isvykimoTaskas, KainosTipas kainosTipas) {
        if (!(30000 < vairuotojasId && vairuotojasId < 40000))
            throw new IllegalArgumentException("Nera vairuotojo su tokiu identifikaciniu numeriu.");

        if (kainosTipas == KainosTipas.STANDARTINE) {
            kss = new StandartinesKainosSkaiciavimas();
        } else if (kainosTipas == KainosTipas.KARANTINO) {
            kss = new KarantinoKainosSkaiciavimas();
        } else throw new IllegalArgumentException("Nepavyko nustatyti kainos skaiciavimo tipo.");

        this.ikainiai = nustatytiIkainius();
        this.vairuotojoVardas = "Vėjas Nupūstas";
        this.vairuotojasId = vairuotojasId;
        this.isvykimoTaskas = isvykimoTaskas;
        System.out.println("Jusu pavezimas pradetas, vairuotojas " + vairuotojoVardas + ".");
    }

    private Ikainiai nustatytiIkainius() {
        return new IkainiaiBuilder()
                .setPradineKaina(100)
                .setKilometroKaina(100)
                .setMinutesKaina(12)
                .createIkainiai();
    }

    /**
     * @return Pavezimo kaina.
     */
    public BigDecimal uzbaigtiPavezima(double atstumas, double laikas, String atvykimoTaskas) throws UnsupportedOperationException {
        if (atvykimoTaskas.isEmpty()) {
            throw new UnsupportedOperationException("Nenustatytas atvykimo taskas.");
        }
        BigDecimal sumineKaina = kss.apskaiciuotiKelionesKaina(atstumas, laikas, ikainiai);
        sumineKaina = kss.koreguotiSumineKaina(isvykimoTaskas, atvykimoTaskas, sumineKaina);
        System.out.println("Ačiū, kad važiavote su " + vairuotojoVardas + ".");
        this.kaina = sumineKaina;
        this.atstumas = atstumas;
        this.laikas = laikas;
        this.atvykimoTaskas = atvykimoTaskas;
        return sumineKaina;
    }

    public int getVairuotojasId() {
        return vairuotojasId;
    }

    public String getVairuotojoVardas() {
        return vairuotojoVardas;
    }

    public String getIsvykimoTaskas() {
        return isvykimoTaskas;
    }

    public String getAtvykimoTaskas() {
        return atvykimoTaskas;
    }

    public double getAtstumas() {
        return atstumas;
    }

    public double getLaikas() {
        return laikas;
    }

    public BigDecimal getKaina() {
        return kaina;
    }
}
