package fr.epitez.Capteur;

import fr.epitez.Portail;

import javax.swing.*;
import java.awt.*;

public class Capteur extends JPanel {

    private final int x;
    private final int y;
    private final Portail lePortail;
    private Color couleur;
    private EtatCapteur etat;

    public Capteur(int x, int y, Portail lePortail) {
        this.x = x;
        this.y = y;
        this.couleur = Color.GRAY;
        this.lePortail = lePortail;
        this.etat = EtatCapteurInitial.recupereInstanceUnique();
    }

    public boolean detectePortail() {
        return (lePortail.getXMin() < this.x) && (this.x < lePortail.getXMax());
    }

    protected void dessineCapteur(Graphics g) {
        g.drawOval( x - 10, y - 10, 10, 10 );
    }

    public void paintComponent(Graphics g) {
        super.paintComponent( g );
        etat = etat.paintComponent( this, g );
    }
}


