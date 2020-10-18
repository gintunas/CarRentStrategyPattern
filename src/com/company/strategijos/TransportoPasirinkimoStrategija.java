package com.company.strategijos;

import com.company.kainosSkaiciavimas.Ikainiai;

public interface TransportoPasirinkimoStrategija {
    String pasirinktiTransportoPriemone(int priemoneId);
    void paliktiTransportoPriemone();
    void pranestiApieNetiketuma();
    Ikainiai gautiTransportoPriemonesIkainius();
}
