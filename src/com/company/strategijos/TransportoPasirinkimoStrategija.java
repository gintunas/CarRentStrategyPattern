package com.company.strategijos;

import com.company.kainosSkaiciavimas.Ikainiai;

public interface TransportoPasirinkimoStrategija {
    String pasirinktiTransportoPriemone(int priemoneId);
    Ikainiai gautiTransportoPriemonesIkainius();
    void paliktiTransportoPriemone();
    void pranestiApieNetiketuma();
}
