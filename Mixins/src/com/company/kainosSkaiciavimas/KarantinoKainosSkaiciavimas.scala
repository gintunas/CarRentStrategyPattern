package com.company.kainosSkaiciavimas

import java.math.BigDecimal

import com.company.enums.Intervalas

trait KarantinoKainosSkaiciavimas extends KainosSkaiciavimas {

  private object ks extends StandartinesKainosSkaiciavimas

  def apskaiciuotiKelionesKaina(atstumas: Double, laikas: Double, ikainiai: Ikainiai): BigDecimal = ks.apskaiciuotiKelionesKaina(atstumas, laikas, ikainiai).multiply(new BigDecimal("0.95"))

  def koreguotiSumineKaina(is: String, i: String, kaina: BigDecimal): BigDecimal = ks.koreguotiSumineKaina(is, i, kaina)

  def skaiciuotiIlgalaikeKaina(ikainiai: Ikainiai, intervalas: Intervalas.Value): BigDecimal = ks.skaiciuotiIlgalaikeKaina(ikainiai, intervalas).multiply(new BigDecimal("0.6"))
}