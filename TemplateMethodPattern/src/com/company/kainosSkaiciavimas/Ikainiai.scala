package com.company.kainosSkaiciavimas

import java.math.BigDecimal

/**
 * Kainos turi buti nurodytos centais.
 */
class Ikainiai(_pradineKaina: Int, _kilometroKaina: Int, _minutesKaina: Int, _virsytoLaikoKaina: Int,
               _virsytoAtstumoKaina: Int = 0, _parosKaina: Int = 0, _savaitesKaina: Int = 0, _menesioKaina: Int = 0) {

  def pradineKaina : BigDecimal = new BigDecimal(_pradineKaina)

  def kilometroKaina : BigDecimal = new BigDecimal(_kilometroKaina)

  def minutesKaina : BigDecimal = new BigDecimal(_minutesKaina)

  def virsytoLaikoKaina : BigDecimal = new BigDecimal(_virsytoLaikoKaina)

  def virsytoAtstumoKaina : BigDecimal = new BigDecimal(_virsytoAtstumoKaina)

  def parosKaina : BigDecimal = new BigDecimal(_parosKaina)

  def savaitesKaina : BigDecimal = new BigDecimal(_savaitesKaina)

  def menesioKaina : BigDecimal = new BigDecimal(_menesioKaina)
}