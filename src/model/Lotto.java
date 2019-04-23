package model;

import java.util.ArrayList;
import java.util.List;

public class Lotto extends Losowanie {

    public Lotto() {
        super((byte) 6, (byte) 49);
    }

    public Lotto(List<Byte> lista_wlasna) {
        super(lista_wlasna,(byte)6);
    }

}

