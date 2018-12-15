/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tontauben.abiaufgabe;

import java.awt.Graphics;
import java.awt.Rectangle;

/**
 *
 * @author Simon.Spittel
 */
public class Tontaube2 extends Tontaube {

    private int yStart;
    private int richtung = 1;

    public Tontaube2() {
        xPos = 0;
        yPos = r.nextInt(550) + 50;
        Faktor = r.nextInt(15) + 30;
        yStart = yPos;
        erhöheAnzahlTontauben();

    }

    public void berechnePosition(int hoehe, int breite) {
        xPos++;

        if (yPos <= 0) {
            richtung = 1;
        }
        if (yPos >= yStart) {
            richtung = 2;
        }
        switch (richtung) {
            case 1:
                yPos++;
                break;
            case 2:
                yPos--;
                break;
        }
        if (xPos >= breite) {
            xPos = 0;
        }
    }

}
