/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tontauben.abiaufgabe;

import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

/**
 *
 * @author Simon.Spittel
 */
public class Bilder {

    private Image taube;
    private Image Landschaft;
    private Image Munition;
    private Image Verloren;

    private Image Gewonnen;

    public Bilder() {
        loadLandschaft();
        loadTaube();
        loadMunition();
        loadVerloren();

        loadGewonnen();
    }

    private void loadLandschaft() {
        try {
            Landschaft = ImageIO.read(new File("Pictures" + File.separator + "Landschaft.png"));
        } catch (IOException ex) {
            Logger.getLogger(Bilder.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void loadVerloren() {
        try {
            Verloren = ImageIO.read(new File("Pictures" + File.separator + "Verloren.png"));
        } catch (IOException ex) {
            Logger.getLogger(Bilder.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void loadGewonnen() {
        try {
            Gewonnen = ImageIO.read(new File("Pictures" + File.separator + "Gewonnen.png"));
        } catch (IOException ex) {
            Logger.getLogger(Bilder.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void loadMunition() {
        try {
            Munition = ImageIO.read(new File("Pictures" + File.separator + "Munition.png"));
        } catch (IOException ex) {
            Logger.getLogger(Bilder.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void loadTaube() {

        try {
            taube = ImageIO.read(new File("Pictures" + File.separator + "Tontaube.png"));
        } catch (IOException ex) {
            Logger.getLogger(Tontaube.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Image getTaube() {
        return taube;
    }

    public Image getVerloren() {
        return Verloren;
    }

    public Image getMunition() {
        return Munition;
    }

    public Image getLandschaft() {
        return Landschaft;
    }

    public Image getGewonnen() {
        return Gewonnen;
    }
}
