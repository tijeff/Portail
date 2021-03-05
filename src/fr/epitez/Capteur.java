package fr.epitez;

import javax.swing.*;
import java.awt.*;

public class Capteur extends JPanel {

    private final int x;
    private final int y;
    private final Portail lePortail;
    private final Moteur leMoteur;
    private Color couleur;

    public Capteur(int x, int y, Portail lePortail, Moteur leMoteur) {
        this.x = x;
        this.y = y;
        this.couleur = Color.GRAY;
        this.lePortail = lePortail;
        this.leMoteur = leMoteur;
    }

    public boolean detectePortail() {
        return (lePortail.getXMin() < this.x) && (this.x < lePortail.getXMax());
    }

    protected void paintComponent(Graphics g) {
        super.paintComponent( g );
        if(detectePortail()){
            g.setColor( Color.BLUE );
        } else {
            g.setColor( Color.YELLOW );
        }
        g.drawOval ( x-10, y-10, 10, 10 );
    }

}
