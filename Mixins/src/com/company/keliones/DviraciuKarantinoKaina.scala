package com.company.keliones

import com.company.kainosSkaiciavimas.KarantinoKainosSkaiciavimas

@throws[IllegalArgumentException]
@throws[UnsupportedOperationException]
class DviraciuKarantinoKaina(override val priemoneId: Int, override val isvykimoTaskas: String)
  extends KelioneDviraciu(priemoneId, isvykimoTaskas)
    with KarantinoKainosSkaiciavimas