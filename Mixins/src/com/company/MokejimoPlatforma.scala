package com.company

import java.math.{BigDecimal, RoundingMode}
import java.text.NumberFormat
import java.util.Locale

object MokejimoPlatforma{
  def sumoketi(kaina: BigDecimal) {
    val _kaina: BigDecimal = kaina.setScale(2, RoundingMode.HALF_EVEN).divide(new BigDecimal(100), RoundingMode.HALF_EVEN)
    val eurKainosFormatas: NumberFormat = NumberFormat.getCurrencyInstance(Locale.GERMANY)
    System.out.println("Uz kelione sumoketa " + eurKainosFormatas.format(_kaina))
  }
}