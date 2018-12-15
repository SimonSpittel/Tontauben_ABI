/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tontauben.abiaufgabe;

import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

/**
 *
 * @author Simon.Spittel
 */
public class Audio {

    private File soundSchuss;
    private File soundTreffer;
    private File soundMusik;
    private File soundViktory;

    private AudioInputStream sound_Schuss;
    private AudioInputStream sound_Treffer;
    private AudioInputStream sound_Musik;
    private AudioInputStream sound_Viktory;

    private Clip clipSchuss;
    private Clip clipTreffer;
    private Clip clipMusik;
    private Clip clipViktory;

    private DataLine.Info infoschuss;
    private DataLine.Info infoTreffer;
    private DataLine.Info infoMusik;
    private DataLine.Info infoViktory;

    public Audio() {
        loadSchuss();
        loadTreffer();
        loadMusik();
    }

    public void clipTrefferStart() {
        clipTreffer.start();
    }

    public void TrefferReset() {
        clipTreffer.stop();
        clipTreffer.setMicrosecondPosition(0);
    }

    public void clipSchussStart() {
        clipSchuss.start();
    }

    public void SchussReset() {
        clipSchuss.stop();
        clipSchuss.setMicrosecondPosition(0);
    }

    public void clipMusikStart() {
        clipMusik.start();
        clipMusik.loop(100);
    }

    public void MusikReset() {
        clipMusik.stop();
        clipMusik.setMicrosecondPosition(0);
    }

    private void loadSchuss() {
        soundSchuss = new File("Sounds" + File.separator + "9mm.wav");

        try {
            sound_Schuss = AudioSystem.getAudioInputStream(soundSchuss);
        } catch (UnsupportedAudioFileException | IOException ex) {
            Logger.getLogger(Audio.class.getName()).log(Level.SEVERE, null, ex);
        }

        infoschuss = new DataLine.Info(Clip.class, sound_Schuss.getFormat());
        try {
            clipSchuss = (Clip) AudioSystem.getLine(infoschuss);
        } catch (LineUnavailableException ex) {
            Logger.getLogger(Audio.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            clipSchuss.open(sound_Schuss);
        } catch (LineUnavailableException | IOException ex) {
            Logger.getLogger(Audio.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void loadTreffer() {
        soundTreffer = new File("Sounds" + File.separator + "Money.wav");

        try {
            sound_Treffer = AudioSystem.getAudioInputStream(soundTreffer);
        } catch (UnsupportedAudioFileException | IOException ex) {
            Logger.getLogger(Audio.class.getName()).log(Level.SEVERE, null, ex);
        }

        infoTreffer = new DataLine.Info(Clip.class, sound_Treffer.getFormat());
        try {
            clipTreffer = (Clip) AudioSystem.getLine(infoTreffer);
        } catch (LineUnavailableException ex) {
            Logger.getLogger(Audio.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            clipTreffer.open(sound_Treffer);
        } catch (LineUnavailableException | IOException ex) {
            Logger.getLogger(Audio.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void loadMusik() {
        soundMusik = new File("Sounds" + File.separator + "Soundtrack.wav");

        try {
            sound_Musik = AudioSystem.getAudioInputStream(soundMusik);
        } catch (UnsupportedAudioFileException | IOException ex) {
            Logger.getLogger(Audio.class.getName()).log(Level.SEVERE, null, ex);
        }

        infoMusik = new DataLine.Info(Clip.class, sound_Musik.getFormat());
        try {
            clipMusik = (Clip) AudioSystem.getLine(infoMusik);
        } catch (LineUnavailableException ex) {
            Logger.getLogger(Audio.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            clipMusik.open(sound_Musik);
        } catch (LineUnavailableException | IOException ex) {
            Logger.getLogger(Audio.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
