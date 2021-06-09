package fr.epitez;

import javax.swing.*;
import java.awt.*;

public class Portail extends JPanel {

    private int x;
    private int y;
    private int largeur;
    private int hauteur;

    public Portail(int x, int y, int largeur, int hauteur) {
        this.largeur = largeur;
        this.hauteur = hauteur;
        this.x = x;
        this.y = y;
    }

    protected void paintComponent(Graphics g) {
        super.paintComponent( g );
        g.setColor( Color.GREEN );
        g.fillRect( x, y, largeur, hauteur );
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
