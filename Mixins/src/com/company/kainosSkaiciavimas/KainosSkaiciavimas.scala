package com.company.kainosSkaiciavimas

import java.math.BigDecimal

import com.company.enums.Intervalas

trait KainosSkaiciavimas {

  protected def apskaiciuotiKelionesKaina(atstumas: Double, laikas: Double, ikainiai: Ikainiai): BigDecimal

  protected def koreguotiSumineKaina(is: String, i: String, kaina: BigDecimal): BigDecimal

  protected def skaiciuotiIlgalaikeKaina(ikainiai: Ikainiai, intervalas: Intervalas.Value): BigDecimal

}
