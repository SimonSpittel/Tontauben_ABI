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
public class Oberflaeche extends javax.swing.JPanel {

    /**
     * @return the verbrauchteSchüsse
     */
    public int getVerbrauchteSchüsse() {
        return verbrauchteSchüsse;
    }
    private Steuerung s;
    private int verbrauchteSchüsse;
    private int MousePosX;
    private int MousePosY;
    private int breite;
    private int hoehe;
    private Bilder b = new Bilder();
    private FadenKreuz f = new FadenKreuz();
    protected Random r = new Random();

    public Oberflaeche() {
        initComponents();
        setFocusable(true);
        requestFocus();
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(b.getLandschaft(), 0, 0, this.getWidth(), this.getHeight(), null);
        requestFocus();

        s.setBreiteGUI(this.getWidth());
        s.setHoeheGUI(this.getHeight());

        s.zeichneAlles(g, this.getWidth(), this.getHeight());

        f.zeichne(g, MousePosX, MousePosY);

        for (int i = 0; i < (s.getAnzahlMaximalerTauben() + 2) - getVerbrauchteSchüsse(); i++) {
            g.drawImage(b.getMunition(), (this.getWidth() - 1000) + (83 * i), this.getHeight() - 100, 83, 100, null);
        }

        if (s.getZustand() == 1) {
            zeichneVerloren(g);
        }

        if (s.getZustand() == 2) {
            zeichneGewonnen(g);
        }

    }

    private void zeichneVerloren(Graphics g) {
        g.drawImage(b.getVerloren(), this.getWidth() / 4, this.getHeight() / 5, this.getWidth() / 2, this.getHeight() / 5, null);
    }
    
     private void zeichneGewonnen(Graphics g) {
        g.drawImage(b.getGewonnen(), this.getWidth() / 4, this.getHeight() / 5, this.getWidth() / 2, this.getHeight() / 5, null);
    }

    public void reset() {
        
        s.reset();
        verbrauchteSchüsse = 0;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setMinimumSize(new java.awt.Dimension(1000, 500));
        setName(""); // NOI18N
        addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                formMouseMoved(evt);
            }
        });
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                formMouseClicked(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                formMouseReleased(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1000, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 500, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void formMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseClicked

    }//GEN-LAST:event_formMouseClicked

    private void formMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseMoved
        MousePosX = evt.getX();
        MousePosY = evt.getY();
        repaint();

    }//GEN-LAST:event_formMouseMoved

    private void formMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseReleased
        if(s.getZustand() == 0){
            s.feuer(evt, this.getWidth(), this.getHeight());
            verbrauchteSchüsse++;
        }
    }//GEN-LAST:event_formMouseReleased


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
    /**
     * @param s the s to set
     */
    public void setS(Steuerung s) {
        this.s = s;
    }
}
