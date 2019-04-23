package view;


import model.*;
import javax.swing.*;
import javax.swing.text.BadLocationException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class LoteriaGUI implements Obserwator {
    private JPanel panel1;
    private JTabbedPane tabbedPane1;
    private JTextField KumulacjaLotto;
    private JPanel Play;
    private JButton chybiłTrafilLotto;
    private JTextArea YourBets;
    private JButton refreshButton;
    private JTextField KumulacjaMini;
    private JTextField KumulacjaEuro;
    private JTextField GL1;
    private JTextField GL2;
    private JTextField GL3;
    private JTextField GL4;
    private JTextField GL5;
    private JTextField GL6;
    private JTextField GM1;
    private JTextField GM2;
    private JTextField GM3;
    private JTextField GM4;
    private JTextField GM5;
    private JTextField GE1;
    private JTextField GE2;
    private JTextField GE3;
    private JTextField GE4;
    private JTextField GE5;
    private JTextField GE6;
    private JTextField GE7;
    private JTextField LottoLiczba6;
    private JTextField LottoLiczba5;
    private JTextField LottoLiczba4;
    private JTextField LottoLiczba3;
    private JTextField Lotto6Wy;
    private JTextField Lotto5Wy;
    private JTextField Lotto4Wy;
    private JTextField Lotto3Wy;
    private JTextField EuroStop1;
    private JTextField EuroStop2;
    private JTextField EuroStop3;
    private JTextField EuroStop4;
    private JTextField EuroStop5;
    private JTextField EuroStop6;
    private JTextField EuroStop7;
    private JTextField EuroStop8;
    private JTextField EuroStop9;
    private JTextField EuroStop10;
    private JTextField EuroStop11;
    private JTextField EuroStop12;
    private JTextField Euro1Wy;
    private JTextField Euro2Wy;
    private JTextField Euro3Wy;
    private JTextField Euro4Wy;
    private JTextField Euro5Wy;
    private JTextField Euro6Wy;
    private JTextField Euro7Wy;
    private JTextField Euro8Wy;
    private JTextField Euro9Wy;
    private JTextField Euro10Wy;
    private JTextField Euro11Wy;
    private JTextField Euro12Wy;
    private JTextField MiniLiczba5;
    private JTextField MiniLiczba4;
    private JTextField MiniLiczba3;
    private JTextField Mini5Wy;
    private JTextField Mini4Wy;
    private JTextField Mini3Wy;
    private JButton LottoAddButton;
    private JButton EuroAddButton;
    private JButton MiniAddButton;
    private JButton DeleteBetButton;
    private JButton chybiłTrafilEuro;
    private JButton chybiłTrafilMini;
    private JTextField ZL1;
    private JTextField ZL2;
    private JTextField ZL3;
    private JTextField ZL4;
    private JTextField ZL5;
    private JTextField ZE1;
    private JTextField ZE2;
    private JTextField ZE3;
    private JTextField ZE4;
    private JTextField ZE5;
    private JTextField ZE6;
    private JTextField ZE7;
    private JTextField ZM1;
    private JTextField ZM2;
    private JTextField ZM3;
    private JTextField ZM4;
    private JTextField ZM5;
    private JTextField ZL6;

    LosowanieGlowne losowaniex = null;
    Lotto kuponLotto = null;
    MiniLotto kuponMini = null;
    EuroJackPot kuponEuro = null;


    public LoteriaGUI( LosowanieGlowne losowanie) {
        inicjalizacja(losowanie);


        refreshButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                losowaniex = new LosowanieGlowne();
                Thread t = new Thread(losowaniex);
                t.start();
                inicjalizacja(losowaniex);
            }
        });

        chybiłTrafilLotto.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                kuponLotto = new Lotto();
                wyswietlanieKuponowLottoWPolach();
            }
        });

        chybiłTrafilMini.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                kuponMini = new MiniLotto();
                wyswietlanieKuponowMiniLottoWPolach();
            }
        });

        chybiłTrafilEuro.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                kuponEuro = new EuroJackPot();
                wyswietlanieKuponowEuroWPolach();
            }
        });

        LottoAddButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                YourBets.append(kuponLotto.getLista_wynikow().toString()+"\n");
            }
        });
        MiniAddButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                YourBets.append(kuponMini.getLista_wynikow().toString()+"\n");
            }
        });
        EuroAddButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                YourBets.append(kuponEuro.getLista().toString()+" + "+ kuponEuro.getListb().toString()+"\n");
            }
        });
        DeleteBetButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    YourBets.replaceRange("", YourBets.getLineStartOffset(YourBets.getLineCount()-2), YourBets.getLineEndOffset(YourBets.getLineCount()-2));
                } catch (BadLocationException e1) {
                    e1.printStackTrace();
                }
            }
        });
    }

    private void robienieKuponow(){
        Byte[] nbytes = new Byte[6];
        List<Byte> a = new ArrayList<>();
        //kuponLotto.setLista_wynikow(a.add(ZL1.getText().getBytes());
    }
    private void wyswietlanieKuponowLottoWPolach(){
        ZL1.setText(kuponLotto.getLista_wynikow().get(0).toString());
        ZL2.setText(kuponLotto.getLista_wynikow().get(1).toString());
        ZL3.setText(kuponLotto.getLista_wynikow().get(2).toString());
        ZL4.setText(kuponLotto.getLista_wynikow().get(3).toString());
        ZL5.setText(kuponLotto.getLista_wynikow().get(4).toString());
        ZL6.setText(kuponLotto.getLista_wynikow().get(5).toString());

    }
    private void wyswietlanieKuponowEuroWPolach(){
        ZE1.setText(kuponEuro.getLista().get(0).toString());
        ZE2.setText(kuponEuro.getLista().get(1).toString());
        ZE3.setText(kuponEuro.getLista().get(2).toString());
        ZE4.setText(kuponEuro.getLista().get(3).toString());
        ZE5.setText(kuponEuro.getLista().get(4).toString());
        ZE6.setText(kuponEuro.getListb().get(0).toString());
        ZE7.setText(kuponEuro.getListb().get(1).toString());

    }
    private void wyswietlanieKuponowMiniLottoWPolach(){
        ZM1.setText(kuponMini.getLista_wynikow().get(0).toString());
        ZM2.setText(kuponMini.getLista_wynikow().get(1).toString());
        ZM3.setText(kuponMini.getLista_wynikow().get(2).toString());
        ZM4.setText(kuponMini.getLista_wynikow().get(3).toString());
        ZM5.setText(kuponMini.getLista_wynikow().get(4).toString());
    }

    private void inicjalizacja(LosowanieGlowne losowanie) {
        losowaniex = losowanie;
        GL1.setText(losowanie.getGlowneLotto().getLista_wynikow().get(0).toString());
        GL2.setText(losowanie.getGlowneLotto().getLista_wynikow().get(1).toString());
        GL3.setText(losowanie.getGlowneLotto().getLista_wynikow().get(2).toString());
        GL4.setText(losowanie.getGlowneLotto().getLista_wynikow().get(3).toString());
        GL5.setText(losowanie.getGlowneLotto().getLista_wynikow().get(4).toString());
        GL6.setText(losowanie.getGlowneLotto().getLista_wynikow().get(5).toString());
        GM1.setText(losowanie.getGlowneMiniLotto().getLista_wynikow().get(0).toString());
        GM2.setText(losowanie.getGlowneMiniLotto().getLista_wynikow().get(1).toString());
        GM3.setText(losowanie.getGlowneMiniLotto().getLista_wynikow().get(2).toString());
        GM4.setText(losowanie.getGlowneMiniLotto().getLista_wynikow().get(3).toString());
        GM5.setText(losowanie.getGlowneMiniLotto().getLista_wynikow().get(4).toString());
        GE1.setText(losowanie.getGlowneJackPot().getLista().get(0).toString());
        GE2.setText(losowanie.getGlowneJackPot().getLista().get(1).toString());
        GE3.setText(losowanie.getGlowneJackPot().getLista().get(2).toString());
        GE4.setText(losowanie.getGlowneJackPot().getLista().get(3).toString());
        GE5.setText(losowanie.getGlowneJackPot().getLista().get(4).toString());
        GE6.setText(losowanie.getGlowneJackPot().getListb().get(0).toString());
        GE7.setText(losowanie.getGlowneJackPot().getListb().get(1).toString());
        KumulacjaLotto.setText(String.valueOf(losowanie.getPula().getLottoKumulacja()) + " zł");
        KumulacjaMini.setText(String.valueOf(losowanie.getPula().getMiniKumulacja()) + " zł");
        KumulacjaEuro.setText(String.valueOf(losowanie.getPula().getEuroKumulacja()) + " zł");
        LottoLiczba6.setText(String.valueOf(losowanie.getCountL()[0]));
        LottoLiczba5.setText(String.valueOf(losowanie.getCountL()[1]));
        LottoLiczba4.setText(String.valueOf(losowanie.getCountL()[2]));
        LottoLiczba3.setText(String.valueOf(losowanie.getCountL()[3]));
        EuroStop1.setText(String.valueOf(losowanie.getCountE()[0]));
        EuroStop2.setText(String.valueOf(losowanie.getCountE()[1]));
        EuroStop3.setText(String.valueOf(losowanie.getCountE()[2]));
        EuroStop4.setText(String.valueOf(losowanie.getCountE()[3]));
        EuroStop5.setText(String.valueOf(losowanie.getCountE()[4]));
        EuroStop6.setText(String.valueOf(losowanie.getCountE()[5]));
        EuroStop7.setText(String.valueOf(losowanie.getCountE()[6]));
        EuroStop8.setText(String.valueOf(losowanie.getCountE()[7]));
        EuroStop9.setText(String.valueOf(losowanie.getCountE()[8]));
        EuroStop10.setText(String.valueOf(losowanie.getCountE()[9]));
        EuroStop11.setText(String.valueOf(losowanie.getCountE()[10]));
        EuroStop12.setText(String.valueOf(losowanie.getCountE()[11]));
        MiniLiczba5.setText(String.valueOf(losowanie.getCountM()[0]));
        MiniLiczba4.setText(String.valueOf(losowanie.getCountM()[1]));
        MiniLiczba3.setText(String.valueOf(losowanie.getCountM()[2]));
        Lotto6Wy.setText(String.valueOf(losowanie.getCountL()[0] != 0 ? (int) (losowanie.getPula().getLottoKumulacja() * 0.44) / losowanie.getCountL()[0] + " zł" : "0 zł"));
        Lotto5Wy.setText(String.valueOf(losowanie.getCountL()[1] != 0 ? (int) (losowanie.getPula().getLottoKumulacja() * 0.08) / losowanie.getCountL()[1] + " zł" : "0 zł"));
        Lotto4Wy.setText(String.valueOf(losowanie.getCountL()[2] != 0 ? (int) (losowanie.getPula().getLottoKumulacja() * 0.24) / losowanie.getCountL()[2] + " zł" : "0 zł"));
        Lotto3Wy.setText(String.valueOf(losowanie.getCountL()[3] != 0 ? (int) (losowanie.getPula().getLottoKumulacja() * 0.24) / losowanie.getCountL()[3] + " zł" : "0 zł"));
        Euro1Wy.setText(String.valueOf(losowanie.getCountE()[0] != 0 ? (int) (losowanie.getPula().getEuroKumulacja() * 0.36) / losowanie.getCountE()[0] + " zł" : "0 zł"));
        Euro2Wy.setText(String.valueOf(losowanie.getCountE()[1] != 0 ? (int) (losowanie.getPula().getEuroKumulacja() * 0.085) / losowanie.getCountE()[1] + " zł" : "0 zł"));
        Euro3Wy.setText(String.valueOf(losowanie.getCountE()[2] != 0 ? (int) (losowanie.getPula().getEuroKumulacja() * 0.03) / losowanie.getCountE()[2] + " zł" : "0 zł"));
        Euro4Wy.setText(String.valueOf(losowanie.getCountE()[3] != 0 ? (int) (losowanie.getPula().getEuroKumulacja() * 0.01) / losowanie.getCountE()[3] + " zł" : "0 zł"));
        Euro5Wy.setText(String.valueOf(losowanie.getCountE()[4] != 0 ? (int) (losowanie.getPula().getEuroKumulacja() * 0.009) / losowanie.getCountE()[4] + " zł" : "0 zł"));
        Euro6Wy.setText(String.valueOf(losowanie.getCountE()[5] != 0 ? (int) (losowanie.getPula().getEuroKumulacja() * 0.007) / losowanie.getCountE()[5] + " zł" : "0 zł"));
        Euro7Wy.setText(String.valueOf(losowanie.getCountE()[6] != 0 ? (int) (losowanie.getPula().getEuroKumulacja() * 0.006) / losowanie.getCountE()[6] + " zł" : "0 zł"));
        Euro8Wy.setText(String.valueOf(losowanie.getCountE()[7] != 0 ? (int) (losowanie.getPula().getEuroKumulacja() * 0.031) / losowanie.getCountE()[7] + " zł" : "0 zł"));
        Euro9Wy.setText(String.valueOf(losowanie.getCountE()[8] != 0 ? (int) (losowanie.getPula().getEuroKumulacja() * 0.03) / losowanie.getCountE()[8] + " zł" : "0 zł"));
        Euro10Wy.setText(String.valueOf(losowanie.getCountE()[9] != 0 ? (int) (losowanie.getPula().getEuroKumulacja() * 0.043) / losowanie.getCountE()[9] + " zł" : "0 zł"));
        Euro11Wy.setText(String.valueOf(losowanie.getCountE()[10] != 0 ? (int) (losowanie.getPula().getEuroKumulacja() * 0.078) / losowanie.getCountE()[10] + " zł" : "0 zł"));
        Euro12Wy.setText(String.valueOf(losowanie.getCountE()[11] != 0 ? (int) (losowanie.getPula().getEuroKumulacja() * 0.191) / losowanie.getCountE()[11] + " zł" : "0 zł"));
        Mini5Wy.setText(String.valueOf(losowanie.getCountM()[0] != 0 ? (int) (losowanie.getPula().getMiniKumulacja() * 0.50) / losowanie.getCountM()[0] + " zł" : "0 zł"));
        Mini4Wy.setText(String.valueOf(losowanie.getCountM()[1] != 0 ? (int) (losowanie.getPula().getMiniKumulacja() * 0.20) / losowanie.getCountM()[1] + " zł" : "0 zł"));
        Mini3Wy.setText(String.valueOf(losowanie.getCountM()[2] != 0 ? (int) (losowanie.getPula().getMiniKumulacja() * 0.30) / losowanie.getCountM()[2] + " zł" : "0 zł"));


    }
    @Override
    public void inform(){losowaniex.run();}


    public static void main(String[] args){
            //Lotto kuponLotto = new Lotto();
            //MiniLotto kuponMini = new MiniLotto();
            //EuroJackPot kuponEuro = new EuroJackPot();
            LosowanieGlowne glowne = new LosowanieGlowne();
            glowne.setPula(Kumulacje.getInstance());


            Thread t = new Thread(glowne);
            t.start();


            JFrame frame = new JFrame("LoteriaGUI");
            frame.setContentPane(new LoteriaGUI(glowne).panel1);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.pack();
            frame.setVisible(true);
        }
    }



