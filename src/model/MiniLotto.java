package model;

import java.util.ArrayList;
import java.util.List;

public class MiniLotto extends Losowanie {

    public MiniLotto(){
        super((byte) 5,(byte) 42);
    }

    public MiniLotto(List<Byte> lista_wlasna) {
       super(lista_wlasna, (byte) 6);
    }

}
