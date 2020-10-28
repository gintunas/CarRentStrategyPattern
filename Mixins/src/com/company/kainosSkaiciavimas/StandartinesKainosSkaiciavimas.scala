package com.company.kainosSkaiciavimas

import java.math.{BigDecimal, RoundingMode}

import com.company.enums.Intervalas

trait StandartinesKainosSkaiciavimas {
  def apskaiciuotiKelionesKaina(atstumas: Double, laikas: Double, ikainiai: Ikainiai): BigDecimal = {
    var sumineKaina: BigDecimal = null
    val atstumasDecimal = new BigDecimal(atstumas).divide(new BigDecimal(1000), RoundingMode.HALF_EVEN)
    val laikasDecimal = new BigDecimal(laikas)
    val virsytasAtstumas = atstumasDecimal.subtract(new BigDecimal(25))
    val virsytasLaikas = laikasDecimal.subtract(new BigDecimal(30))
    sumineKaina = ikainiai.pradineKaina.add(ikainiai.kilometroKaina.multiply(atstumasDecimal))
    if (virsytasAtstumas.signum == 1) sumineKaina = sumineKaina.add(virsytasAtstumas.multiply(ikainiai.virsytoAtstumoKaina))
    sumineKaina = sumineKaina.add(ikainiai.minutesKaina.multiply(laikasDecimal))
    if (virsytasLaikas.signum == 1) sumineKaina = sumineKaina.add(virsytasLaikas.multiply(ikainiai.virsytoLaikoKaina))
    sumineKaina
  }

  def koreguotiSumineKaina(is: String, i: String, kaina: BigDecimal): BigDecimal = {
    var naujaKaina: BigDecimal = kaina
    if (is == "Vilniaus oro uostas" || i == "Vilniaus oro uostas") {
      naujaKaina = kaina.add(new BigDecimal(200))
      System.out.println("Prie Jusu keliones mokescio prideta 2 € suma, nes keliavote pro Vilniaus oro uosta.")
    }
    naujaKaina
  }

  @throws[IllegalArgumentException]
  def skaiciuotiIlgalaikeKaina(ikainiai: Ikainiai, intervalas: Intervalas.Value): BigDecimal = {
    var sumineKaina: BigDecimal = null
    intervalas match {
      case Intervalas.PARA =>
        sumineKaina = ikainiai.parosKaina
      case Intervalas.SAVAITE =>
        sumineKaina = ikainiai.savaitesKaina
      case Intervalas.MENESIS =>
        sumineKaina = ikainiai.menesioKaina
      case _ =>
        throw new IllegalArgumentException("Nenustatytas nuomos intervalas.")
    }
    sumineKaina
  }
}