import model.*;

public class Main {

    public static void main(String[] args) {
        LosowanieGlowne glowne = new LosowanieGlowne();
        glowne.setPula(Kumulacje.getInstance());
        glowne = new LosowanieGlowne();

        Thread t = new Thread(glowne);
        t.start();

    }
}
