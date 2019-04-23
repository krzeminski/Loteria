package model;

import java.util.Random;

public class Kumulacje {
    private static Kumulacje instance;
    int lottoKumulacja;
    int miniKumulacja;
    int euroKumulacja;

    private Kumulacje() {
        Random r = new Random();
        int l = r.nextInt(20);
        int m = r.nextInt(150);
        int e = r.nextInt(70);
        lottoKumulacja = l * 1000000;
        miniKumulacja = (m + 200) * 1000;
        euroKumulacja = (e + 100) * 1000000;
    }

    public static synchronized Kumulacje getInstance() {
        if (instance == null) {
            instance = new Kumulacje();
        }
        return instance;
    }

    public void zmianaKumulacji(int l, int m, int e) {
        if (l == 0) {
            this.lottoKumulacja += 1000000;
        } else {
            this.lottoKumulacja = 1000000;
        }
        if (m == 0) {
            this.miniKumulacja += 30000;
        } else {
            this.miniKumulacja = 200000;
        }
        if (e == 0) {
            this.euroKumulacja += 2000000;
        } else {
            this.euroKumulacja = 50000000;
        }
    }


    public int getLottoKumulacja() {
        return lottoKumulacja;
    }

    public int getMiniKumulacja() {
        return miniKumulacja;
    }

    public int getEuroKumulacja() {
        return euroKumulacja;
    }

}
