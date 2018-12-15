/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tontauben.abiaufgabe;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.geom.Ellipse2D;
import java.io.File;
import java.io.IOException;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

/**
 *
 * @author Simon.Spittel
 */
public abstract class Tontaube {

    /**
     * @param aDieAnzahlTontauben the dieAnzahlTontauben to set
     */
    public static void setDieAnzahlTontauben(int aDieAnzahlTontauben) {
        dieAnzahlTontauben = aDieAnzahlTontauben;
    }
    private Image taube;
    private static int dieAnzahlTontauben;
    private Bilder b = new Bilder();
    protected int Faktor;
    protected int xPos;
    protected int yPos;
    protected int xMitte;
    protected int yMitte;
    public boolean sichtbar = true;
    private int radius;
    protected Random r = new Random();

    public static int getDieAnzahlTontauben() {
        return dieAnzahlTontauben;
    }

    public boolean isSichtbar() {
        return sichtbar;
    }

    public void setSichtbar(boolean sichtbar) {
        this.sichtbar = sichtbar;
    }

    public abstract void berechnePosition(int hoehe, int breite);

    public void zeichne(Graphics g, int breite, int hoehe) {

        xMitte = xPos + (breite / Faktor) / 2;
        yMitte = yPos + (breite / Faktor) / 2;
        radius = (breite / Faktor) / 2;

        //g.drawOval(xMitte-radius, yMitte-radius, radius*2, radius*2);
        g.drawImage(b.getTaube(), xPos, yPos, radius * 2, radius * 2, null);

    }

    public boolean pruefeGetroffen(java.awt.event.MouseEvent evt, int breite, int hoehe) {

        int xLenght = Math.abs(xMitte - evt.getX());
        int yLenght = Math.abs(yMitte - evt.getY());
        int abstand = (int) Math.sqrt(xLenght * xLenght + yLenght * yLenght);

        return abstand < radius;
    }

    public void erhöheAnzahlTontauben() {
        setDieAnzahlTontauben(getDieAnzahlTontauben() + 1);
    }

}
