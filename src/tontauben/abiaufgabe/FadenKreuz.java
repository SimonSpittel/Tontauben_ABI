/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tontauben.abiaufgabe;

import java.awt.Graphics;

/**
 *
 * @author Simon.Spittel
 */
public class FadenKreuz {
    private float Radius = 20;
    private int mitteX;
    private int mitteY;
    
    public void zeichne(Graphics g,int xPos, int yPos){
        g.drawRoundRect(xPos-20, yPos-20, 40, 40, 40, 40);
        g.drawLine(xPos, yPos-20, xPos, yPos+20);
        g.drawLine(xPos-20, yPos, xPos+20, yPos);
        mitteX = xPos-20;
        mitteY = yPos+20;
        
    }

    /**
     * @return the mitteX
     */
    public int getMitteX() {
        return mitteX;
    }

    /**
     * @return the mitteY
     */
    public int getMitteY() {
        return mitteY;
    }
    
}
