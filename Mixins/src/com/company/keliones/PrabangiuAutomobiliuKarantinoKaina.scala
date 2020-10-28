package com.company.keliones

import com.company.kainosSkaiciavimas.KarantinoKainosSkaiciavimas

@throws[IllegalArgumentException]
@throws[UnsupportedOperationException]
class PrabangiuAutomobiliuKarantinoKaina(override val priemoneId: Int, override val isvykimoTaskas: String)
  extends KelionePrabangiuAutomobiliu(priemoneId, isvykimoTaskas)
    with KarantinoKainosSkaiciavimas