package model;

import java.util.*;

public class Losowanie {

    private byte ilosc;
    private byte zakres;
    Set<Byte> zbior_wynikow = new HashSet<>();
    List<Byte> lista_wynikow = new ArrayList<>();

    // konstruktor jako parametr przyjmujący ilość liczb oraz zakres losowania

    public Losowanie(Byte ilosc, Byte zakres) {
        if (ilosc <= 0) {
            throw new IllegalArgumentException("Ilość musi być większa od 0");
        }
        if (zakres <= 0) {
            throw new IllegalArgumentException("Zakres musi być większy od 0");
        }
        this.ilosc = ilosc;
        this.zakres = zakres;
        this.zbior_wynikow = new HashSet<>();
        this.lista_wynikow = new ArrayList<>();
        losuj();
        sort();
    }
    public Losowanie(List<Byte> lista_wlasna, byte ilosc) {
        if (lista_wlasna.size()!=ilosc) {
            throw new IllegalArgumentException("Niepoprawna lista!");
        } else {
            this.lista_wynikow = lista_wlasna;
            this.zbior_wynikow = new HashSet<>(lista_wlasna);
        }
    }

    private void losuj() {
        Random r = new Random();
        for (int i = 0; i < ilosc; i++) {
            if (!zbior_wynikow.add((byte) (r.nextInt(this.zakres) + 1)))    // lotto.add() zwraca false jesli proba dodania liczby nieudana
                i--;
        }
       // System.out.println("Wylosowane liczby " + zbior_wynikow);
    }

    private void sort() {
        Object[] tablica_wynikow = zbior_wynikow.toArray();
        Arrays.sort(tablica_wynikow);
        for(int i = 0; i < tablica_wynikow.length; i++){
            lista_wynikow.add((byte)tablica_wynikow[i]);
        }
       //System.out.println(lista_wynikow);

    }

    public byte getIlosc() {
        return ilosc;
    }

    public byte getZakres() {
        return zakres;
    }

    public Set<Byte> getZbior_wynikow() {
        return zbior_wynikow;
    }

    public List<Byte> getLista_wynikow() {
        return lista_wynikow;
    }

    public void setLista_wynikow(List<Byte> lista_wynikow) {
        this.lista_wynikow = lista_wynikow;
    }
}