package com.company.keliones

import com.company.kainosSkaiciavimas.StandartinesKainosSkaiciavimas

@throws[IllegalArgumentException]
@throws[UnsupportedOperationException]
class PrabangiuAutomobiliuStandartineKaina(override val priemoneId: Int, override val isvykimoTaskas: String)
  extends KelionePrabangiuAutomobiliu(priemoneId, isvykimoTaskas)
    with StandartinesKainosSkaiciavimas