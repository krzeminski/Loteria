package model;

import java.util.Arrays;
import java.util.Random;

public class LosowanieGlowne implements Runnable, Obserwowany {

    Lotto glowneLotto;
    MiniLotto glowneMiniLotto;
    EuroJackPot glowneJackPot;
    Kumulacje pula = Kumulacje.getInstance();
    int[] countL = new int[4];
    int[] countM = new int[3];
    int[] countE = new int[12];
    Random r = new Random();
    int l = r.nextInt(10000)+ 1500000;
    int e = r.nextInt(7500) + 1000000;
    int m = r.nextInt(5000) + 200000;
    Obserwator obserwator;

    public LosowanieGlowne() {
        this.glowneLotto = new Lotto();
        this.glowneMiniLotto = new MiniLotto();
        this.glowneJackPot = new EuroJackPot();
        run();
        this.pula.zmianaKumulacji(countL[0], countM[0], countE[0]);
    }

    public void porownaj(Lotto a) {
        //System.out.println("Twoje Lotto: " + a.getLista_wynikow());
        a.getZbior_wynikow().retainAll(glowneLotto.zbior_wynikow);
        //System.out.println("Trafiłeś " + a.getZbior_wynikow().size() + " następujących liczb " + a.getZbior_wynikow() + "\n");
        switch (a.getZbior_wynikow().size()) {
            case 6:
                this.countL[0]++;
            case 5:
                this.countL[1]++;
            case 4:
                this.countL[2]++;
            case 3:
                this.countL[3]++;
            default:
                break;
        }
    }

    public void porownaj(MiniLotto a) {
        //System.out.println("Twoje miniLotto " + a.getLista_wynikow());
        a.getZbior_wynikow().retainAll(glowneMiniLotto.zbior_wynikow);
        //System.out.println("Trafiłeś " + a.getZbior_wynikow().size() + " następujących liczb " + a.getZbior_wynikow() + "\n");
        switch (a.getZbior_wynikow().size()) {
            case 5:
                this.countM[0]++;
                break;
            case 4:
                this.countM[1]++;
                break;
            case 3:
                this.countM[2]++;
                break;
            default:
                break;
        }
    }

    public void porownaj(EuroJackPot a) {
        //System.out.println("Twój EuroJackPot" + a.getLista() + a.getListb());
        a.getZbiora().retainAll(glowneJackPot.getZbiora());
        a.getZbiorb().retainAll(glowneJackPot.getZbiorb());
        //System.out.println("Trafiłeś " + a.getZbiora().size() + "+" + a.getZbiorb().size() + " następujących liczb " + a.getZbiora() + a.getZbiorb() + "\n");

        switch (a.getZbiora().size()) {
            case 5: {
                if (a.getZbiorb().size() == 2) {
                    this.countE[0]++;
                    break;
                }
                if (a.getZbiorb().size() == 1) {
                    this.countE[1]++;
                    break;
                }
                if (a.getZbiorb().size() == 0) {
                    this.countE[2]++;
                    break;
                }
            }
            case 4: {
                if (a.getZbiorb().size() == 2) {
                    this.countE[3]++;
                    break;
                }
                if (a.getZbiorb().size() == 1) {
                    this.countE[4]++;
                    break;
                }
                if (a.getZbiorb().size() == 0) {
                    this.countE[5]++;
                    break;
                }
            }

            case 3: {

                if (a.getZbiorb().size() == 2) {
                    this.countE[6]++;
                    break;
                }
                if (a.getZbiorb().size() == 1) {
                    this.countE[8]++;
                    break;
                }
                if (a.getZbiorb().size() == 0) {
                    this.countE[9]++;
                    break;
                }
            }
            case 2: {
                if (a.getZbiorb().size() == 2) {
                    this.countE[7]++;
                    break;
                }
                if (a.getZbiorb().size() == 1) {
                    this.countE[11]++;
                    break;
                }
            }
            default: {
                if (a.getZbiora().size() == 1 && a.getZbiorb().size() == 2) {
                    this.countE[10]++;
                    break;
                }
            }

        }

    }

    public void wygrane() {
        System.out.println("Wygrywające liczby w Lotto to: " + glowneLotto.getLista_wynikow());
        System.out.println("Wygrywające liczby w miniLotto to: " + glowneMiniLotto.getLista_wynikow());
        System.out.println("Wygrywające liczby w EurojackPot to: " + glowneJackPot.getLista() + " " + glowneJackPot.getListb() + "\n");
    }

    public void run() {
        for (int i = 0; i < l; i++) {
            Lotto a = new Lotto();
            porownaj(a);
        }
        for(int i = 0; i<m; i++) {
            MiniLotto b = new MiniLotto();
            porownaj(b);
        }
        for(int i =0; i<e; i++) {
            EuroJackPot c = new EuroJackPot();
            porownaj(c);
        }
        if( obserwator != null )
            obserwator.inform();
    }

    public Lotto getGlowneLotto() {
        return glowneLotto;
    }

    public MiniLotto getGlowneMiniLotto() {
        return glowneMiniLotto;
    }

    public EuroJackPot getGlowneJackPot() {
        return glowneJackPot;
    }

    public int[] getCountL() { return countL; }

    public int[] getCountM() { return countM; }

    public int[] getCountE() {
        return countE;
    }

    public void setPula(Kumulacje pula) {
        this.pula = pula;
    }

    public Kumulacje getPula() {
        return pula;
    }
    public void subscribe( Obserwator ob ){
        this.obserwator = ob;
    }

    public void unsubscribe( Obserwator ob ){
        this.obserwator = ob;
    }

    public void informAll(){}
}
