package com.company.keliones

import com.company.kainosSkaiciavimas.StandartinesKainosSkaiciavimas

@throws[IllegalArgumentException]
@throws[UnsupportedOperationException]
class EkonomiskuAutomobiliuStandartineKaina(override val priemoneId: Int, override val isvykimoTaskas: String)
  extends KelioneEkonomiskuAutomobiliu(priemoneId, isvykimoTaskas)
    with StandartinesKainosSkaiciavimas
