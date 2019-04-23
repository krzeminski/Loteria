package model;

import java.util.ArrayList;
import java.util.List;

public class EuroJackPot2 extends Losowanie {

    public EuroJackPot2(){
        super((byte) 2,(byte) 10);
    }

    public EuroJackPot2(List<Byte> lista_wlasna) {
       super(lista_wlasna, (byte)2);
    }
}
