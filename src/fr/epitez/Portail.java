package fr.epitez;

import javax.swing.*;
import java.awt.*;

public class Portail extends JPanel {

    private final int largeur;
    private final int largeurFenetre;
    private final int hauteur;
    private final int hauteurFenetre;
    private int x;
    private int y;

    public Portail(int largeurFenetre, int hauteurFenetre) {
        this.largeur = largeurFenetre/3;
        this.largeurFenetre = largeurFenetre;
        this.hauteur = hauteurFenetre/2;
        this.hauteurFenetre = hauteurFenetre;
        this.x = this.largeurFenetre/2-this.largeur/2;
        this.y = this.hauteurFenetre-this.hauteur-2;
    }

    protected void paintComponent(Graphics g) {
        super.paintComponent( g );
        g.setColor( Color.GREEN );
        g.fillRect( x, y, largeur, hauteur );
    }

    public Dimension getPreferredSize() {
        return new Dimension( largeurFenetre, hauteurFenetre );
    }

    public void deplace(int mouvement) {
        x += mouvement;
    }

    public int getLargeur() {
        return this.largeur;
    }

    public int getXMin() {
        return this.x;
    }

    public int getXMax() {
        return this.x+this.largeur;
    }
}
