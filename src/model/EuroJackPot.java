package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class EuroJackPot {
    private EuroJackPot1 a;
    private EuroJackPot2 b;

    public EuroJackPot(){
        a = new EuroJackPot1();
        b = new EuroJackPot2();
    }

    public EuroJackPot(List<Byte> lista1, List<Byte> lista2 ) {
        a = new EuroJackPot1(lista1);
        b = new EuroJackPot2(lista2);
    }

    public List<Byte> getLista(){
        return a.getLista_wynikow();
    }

    public List<Byte> getListb(){

        return b.getLista_wynikow();
    }
    public Set<Byte> getZbiora() {

        return a.zbior_wynikow;
    }
    public Set<Byte> getZbiorb() {
        return b.zbior_wynikow;
    }
}
