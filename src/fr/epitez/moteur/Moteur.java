package fr.epitez.moteur;

import fr.epitez.Portail;

import javax.swing.*;
import java.awt.*;

public class Moteur extends JPanel  {

    static final int vitesse = 10;

    private int x;
    private int y;
    private int dimension;
    private int mouvement;

    private Portail lePortail;

    public Moteur(int x, int y, int dimension, Portail lePortail) {
        this.x = x;
        this.y = y;
        this.dimension = dimension;
        this.lePortail = lePortail;
    }

    public void paintComponent(Graphics g) {
        super.paintComponent( g );
        g.setColor( Color.BLACK );
        g.fillRect( x-dimension, y-dimension, dimension, dimension );
    }

    public void tourneADroite() {
        this.mouvement = Moteur.vitesse;
        //lePortail.deplace(this.mouvement);
    }
    public void tourneAGauche() {
        this.mouvement = -Moteur.vitesse;
        // lePortail.deplaceGauche();
    }
    public void arreteMoteur() {
        this.mouvement = 0;
    }

    public void actionTic() {
        lePortail.deplace(this.mouvement);
    }

    public boolean estAllume() {
        return this.mouvement != 0;
    }
}
