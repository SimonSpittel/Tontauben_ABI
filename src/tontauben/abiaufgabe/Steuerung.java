/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tontauben.abiaufgabe;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import javax.swing.Timer;

/**
 *
 * @author Simon.Spittel
 */
public class Steuerung {

    /**
     * @return the zustand
     */
    public int getZustand() {
        return zustand;
    }

    /**
     * @return the AnzahlMaximalerTauben
     */
    private Timer neueTaube;
    private Timer bewege;
    private Random r = new Random();
    private int hoeheGUI;
    private int breiteGUI;
    private int AnzahlMaximalerTauben = 10;
    private int zustand;
    private Oberflaeche o;
    private Tontaube tontaube[] = new Tontaube[getAnzahlMaximalerTauben()];
    private int counter;
    private Audio a = new Audio();

    public Steuerung() {
        tontaube[0] = new Tontaube1();
        tontaube[1] = new Tontaube2();
        tontaube[2] = new Tontaube3();
        neueTaube = new Timer(1000, new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                verarbeiteTickTaube();
            }
        });

        bewege = new Timer(10, new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                verarbeiteTickBewege();
            }
        });
        bewege.start();
        neueTaube.start();
        a.MusikReset();
        a.clipMusikStart();

    }

    public void setO(Oberflaeche o) {
        this.o = o;
    }

    private void verarbeiteTickTaube() {
        if (Tontaube.getDieAnzahlTontauben() < tontaube.length) {
            switch (r.nextInt(3)) {
                case 0:
                    tontaube[Tontaube.getDieAnzahlTontauben()] = new Tontaube1();
                    break;
                case 1:
                    tontaube[Tontaube.getDieAnzahlTontauben()] = new Tontaube2();
                    break;
                case 2:
                    tontaube[Tontaube.getDieAnzahlTontauben()] = new Tontaube3();
                    break;
                default:
                    tontaube[Tontaube.getDieAnzahlTontauben()] = new Tontaube1();
                    break;
            }
        }

        o.repaint();                                                //     <--  Hier muss oberfläche repaint welche steuerung zeichne aufruft!!
    }

    private void verarbeiteTickBewege() {
        for (int i = 0; i < Tontaube.getDieAnzahlTontauben(); i++) {
            tontaube[i].berechnePosition(hoeheGUI, breiteGUI);
        }

        o.repaint();

    }

    public void zeichneAlles(Graphics g, int breite, int hoehe) {
        for (int i = 0; i < Tontaube.getDieAnzahlTontauben(); i++) {
            if (tontaube[i].isSichtbar()) {
                tontaube[i].zeichne(g, breite, hoehe);
            }
        }
    }

    public void feuer(java.awt.event.MouseEvent evt, int breite, int hoehe) {
        a.SchussReset();
        a.clipSchussStart();
        for (int i = 0; i < Tontaube.getDieAnzahlTontauben(); i++) {
            if (tontaube[i].pruefeGetroffen(evt, breite, hoehe) && tontaube[i].sichtbar == true) {
                tontaube[i].setSichtbar(false);
                counter++;

                if (tontaube[i].pruefeGetroffen(evt, breite, hoehe)) {
                    a.TrefferReset();
                    a.clipTrefferStart();
                    break;
                }

            }
        }

        if ((getAnzahlMaximalerTauben()) - o.getVerbrauchteSchüsse() < 0) {
            verloren();
            zustand = 1;
        }

        if (counter == Tontaube.getDieAnzahlTontauben() && o.getVerbrauchteSchüsse() <= 12) {
            zustand = 2;
            gewonnen();
        }

        o.repaint();

    }

    /**
     * @param hoeheGUI the hoeheGUI to set
     */
    public void setHoeheGUI(int hoeheGUI) {
        this.hoeheGUI = hoeheGUI;
    }

    /**
     * @param breiteGUI the breiteGUI to set
     */
    public void setBreiteGUI(int breiteGUI) {
        this.breiteGUI = breiteGUI;
    }

    public int getCounter() {
        return counter;
    }

    public int getAnzahlMaximalerTauben() {
        return AnzahlMaximalerTauben;
    }

    public void verloren() {
        bewege.stop();
        neueTaube.stop();
    }

    public void gewonnen() {
        bewege.stop();
        neueTaube.stop();
    }

    public void reset() {
        Tontaube.setDieAnzahlTontauben(0);
        a.MusikReset();
        a.clipMusikStart();
        bewege.start();
        neueTaube.start();
        zustand = 0;
    }

}
