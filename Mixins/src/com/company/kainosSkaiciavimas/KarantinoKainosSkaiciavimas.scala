package com.company.kainosSkaiciavimas

import java.math.BigDecimal

import com.company.enums.Intervalas

trait KarantinoKainosSkaiciavimas {

  object standartinesKainosSkaiciavimas extends StandartinesKainosSkaiciavimas

  def apskaiciuotiKelionesKaina(atstumas: Double, laikas: Double, ikainiai: Ikainiai): BigDecimal = standartinesKainosSkaiciavimas.apskaiciuotiKelionesKaina(atstumas, laikas, ikainiai).multiply(new BigDecimal("0.95"))

  def koreguotiSumineKaina(is: String, i: String, kaina: BigDecimal): BigDecimal = standartinesKainosSkaiciavimas.koreguotiSumineKaina(is, i, kaina)

  def skaiciuotiIlgalaikeKaina(ikainiai: Ikainiai, intervalas: Intervalas.Value): BigDecimal = standartinesKainosSkaiciavimas.skaiciuotiIlgalaikeKaina(ikainiai, intervalas).multiply(new BigDecimal("0.6"))
}