package model;

import java.util.ArrayList;
import java.util.List;

public class EuroJackPot1 extends Losowanie {

    public EuroJackPot1(){
        super((byte) 5,(byte) 50);
    }

    public EuroJackPot1(List<Byte> lista_wlasna) {
        super(lista_wlasna, (byte)5);
    }
}
