package com.company.keliones

import com.company.kainosSkaiciavimas.Ikainiai

trait TransportoPriemone {
  def gautiTransportoPriemonesPavadinima: String

  def gautiIkainius: Ikainiai

  def pranestiApieNetiketuma()

  protected def paliktiTransportoPriemone(priemoneId : Int)
}
