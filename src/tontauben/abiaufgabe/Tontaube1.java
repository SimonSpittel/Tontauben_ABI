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
public class Tontaube1 extends Tontaube {

    public Tontaube1() {
        xPos = 0;
        yPos = r.nextInt(550) + 50;

        Faktor = r.nextInt(15) + 20;
        erhöheAnzahlTontauben();
    }

    @Override
    public void berechnePosition(int hoehe, int breite) {
        xPos++;
        if (xPos >= breite) {
            xPos = 0;
        }
    }

}
