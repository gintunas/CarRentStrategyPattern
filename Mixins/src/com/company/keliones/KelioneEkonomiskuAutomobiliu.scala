package com.company.keliones

import com.company.kainosSkaiciavimas.Ikainiai

@throws[UnsupportedOperationException]
abstract class KelioneEkonomiskuAutomobiliu(override val priemoneId: Int, override val isvykimoTaskas: String) extends Kelione(priemoneId, isvykimoTaskas) {
  transportoPriemonesPavadinimas = pasirinktiTransportoPriemone(priemoneId)
  if (transportoPriemonesPavadinimas.isEmpty) throw new UnsupportedOperationException("Nepavyko pasirinkti transporto priemones.")
  ikainiai = gautiTransportoPriemonesIkainius

  override def gautiTransportoPriemonesIkainius = new Ikainiai(100, 30, 14, 6, 5, 1522, 7500, 30000)

  override def pasirinktiTransportoPriemone(priemoneId: Int): String = { //if(priemoneID nepasirinktas) pasirinkti
    "Honda Civic 5 gen."
    //else return null;
  }

  override def paliktiTransportoPriemone(): Unit = { //palikti priemoneId
    System.out.println("Paliktas Honda Civic, id: " + priemoneId)
  }

  override def pranestiApieNetiketuma(): Unit = System.out.println("Dekojame uz pranesta Honda Civic, id: " + priemoneId + " apgadinima.")
}