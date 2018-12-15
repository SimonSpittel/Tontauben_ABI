/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tontauben.abiaufgabe;

/**
 *
 * @author Simon.Spittel
 */
public class Tontaube3 extends Tontaube {

    private int BezYPos;
    private int progress = 0;

    public Tontaube3() {
        xPos = 0;
        BezYPos = r.nextInt(550) + 50;
        Faktor = r.nextInt(15) + 30;
        erhöheAnzahlTontauben();
    }

    @Override
    public void berechnePosition(int hoehe, int breite) {
        progress++;
        xPos++;
        yPos = (int) (Math.sin(progress / 40f) * 40 + BezYPos);

        if (xPos >= breite) {
            xPos = 0;
        }
    }

}
