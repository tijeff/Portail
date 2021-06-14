package fr.epitez.Capteur;

import fr.epitez.Portail;

import javax.swing.*;
import java.awt.*;

public class Capteur extends JPanel {

    private final int x;
    private final int xMax;
    private final int y;
    private final int dimension;
    private final Portail lePortail;
    private Color couleur;
    private EtatCapteur etat;

    public Capteur(final int x, final int y, int dimension, Portail lePortail) {
        this.x = x;
        this.xMax = x+dimension;
        this.y = y;
        this.dimension = dimension;
        this.couleur = Color.GRAY;
        this.lePortail = lePortail;
        this.etat = EtatCapteurInitial.recupereInstanceUnique();
    }

    public boolean detectePortail() {
        return ((lePortail.getXMin() <= this.x) && (this.x <= lePortail.getXMax())
                ||
                (lePortail.getXMin() <= this.xMax) && (this.xMax <= lePortail.getXMax()));
    }

    protected void dessineCapteur(Graphics g) {
        final int [] triangleXs = {x, x+dimension/2, x+dimension};
        final int [] triangleYs = {y, y-dimension, y};
        g.drawPolygon( triangleXs, triangleYs, 3 );
    }

    public void paintComponent(Graphics g) {
        super.paintComponent( g );
        etat = etat.paintComponent( this, g );
    }
}


