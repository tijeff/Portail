package fr.epitez;

import javax.swing.*;
import java.awt.*;

public class Moteur extends JPanel  {

    static final int vitesse = 10;

    final int largeurFenetre;
    final int hauteurFenetre;

    private int x;
    private int y;
    private int mouvement;

    private Portail lePortail;

    public Moteur(int largeurFenetre, int hauteurFenetre, Portail lePortail) {
        this.largeurFenetre = largeurFenetre;
        this.hauteurFenetre = hauteurFenetre;
        this.x = this.largeurFenetre/2;
        this.y = hauteurFenetre-12;
        this.lePortail = lePortail;
    }

    protected void paintComponent(Graphics g) {
        super.paintComponent( g );
        g.setColor( Color.RED );
        g.fillRect( x, y, 10, 10 );
    }

    public Dimension getPreferredSize() {
        return new Dimension( largeurFenetre, hauteurFenetre );
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

    public void appuieBouton1() {
        System.out.println("Bouton 1");
    }

    public void appuieBouton3() {
        System.out.println("Bouton 3");
    }

    public void actionTic() {
        lePortail.deplace(this.mouvement);
    }
}
