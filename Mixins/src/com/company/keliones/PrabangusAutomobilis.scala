package com.company.keliones

import com.company.kainosSkaiciavimas.Ikainiai

@throws[UnsupportedOperationException]
trait PrabangusAutomobilis extends Kelione {
  private val transportoPriemonesPavadinimas = "Lexus RC 300"
  val _ikainiai = new Ikainiai(300, 50, 20, 10, 10, 4000, 20000, 400000)

  override def gautiTransportoPriemonesPavadinima: String = transportoPriemonesPavadinimas

  override def gautiIkainius: Ikainiai = _ikainiai

  override def pranestiApieNetiketuma(): Unit = System.out.println("Dekojame uz pranesta Lexus RC 300, id: " + priemoneId + " apgadinima.")

  protected override def paliktiTransportoPriemone(): Unit = { //palikti priemoneId
    System.out.println("Paliktas Lexus RC 300, id: " + priemoneId)
  }
}