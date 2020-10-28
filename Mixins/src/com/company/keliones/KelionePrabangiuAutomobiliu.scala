package com.company.keliones

import com.company.kainosSkaiciavimas.Ikainiai

@throws[UnsupportedOperationException]
abstract class KelionePrabangiuAutomobiliu
(override val priemoneId: Int, override val isvykimoTaskas: String) extends Kelione(priemoneId, isvykimoTaskas) {
  transportoPriemonesPavadinimas = pasirinktiTransportoPriemone(priemoneId)
  if (transportoPriemonesPavadinimas.isEmpty) throw new UnsupportedOperationException("Nepavyko pasirinkti transporto priemones.")
  ikainiai = gautiTransportoPriemonesIkainius

  override def pasirinktiTransportoPriemone(priemoneId: Int): String = { //if(priemoneID nepasirinktas) pasirinkti
    "Lexus RC 300"
    //else return null;
  }

  override def gautiTransportoPriemonesIkainius = new Ikainiai(300, 50, 20, 10, 10, 4000, 20000, 400000)

  override def paliktiTransportoPriemone(): Unit = { //palikti priemoneId
    System.out.println("Paliktas Lexus RC 300, id: " + priemoneId)
  }

  override def pranestiApieNetiketuma(): Unit = System.out.println("Dekojame uz pranesta Lexus RC 300, id: " + priemoneId + " apgadinima.")
}