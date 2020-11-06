package com.company.keliones

import com.company.kainosSkaiciavimas.Ikainiai

trait PrabangusAutomobilis{
  private val transportoPriemonesPavadinimas = "Lexus RC 300"
  val _ikainiai = new Ikainiai(300, 50, 20, 10, 10, 4000, 20000, 400000)

  def gautiTransportoPriemonesPavadinima: String = transportoPriemonesPavadinimas

  def gautiIkainius: Ikainiai = _ikainiai

  def pranestiApieNetiketuma(): Unit = System.out.println("Dekojame uz pranesta Lexus RC 300 apgadinima.")

  protected def paliktiTransportoPriemone(priemoneId : Int): Unit = { //palikti priemoneId
    System.out.println("Paliktas Lexus RC 300, id: " + priemoneId)
  }
}