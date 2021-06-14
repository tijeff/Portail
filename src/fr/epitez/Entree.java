package fr.epitez;

import fr.epitez.Capteur.Capteur;
import fr.epitez.moteur.Moteur;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class Entree extends JPanel implements ActionListener {

    private final int largeur;
    private final int hauteur;

    private final JLabel lHeure;
    private final Portail lePortail;
    private final Moteur leMoteur;
    private final Capteur capteurDroit;
    private final Capteur capteurGauche;
    private final Ampoule ampoule;
    private final Rail leRail;

    public Entree( final int x, final int y, final int largeur, final int hauteur) {
        this.largeur = largeur;
        this.hauteur = hauteur;

        setBounds( x,y, largeur, hauteur );
        Entree lePanneau = this;
        ActionListener actionListener = new ActionListener() {

            public void actionPerformed(ActionEvent actionEvent) {
                leMoteur.actionTic();
                afficheLHeure();
                lePanneau.repaint();
            }

            private void afficheLHeure() {
                final String pattern = "HH:mm:ss";
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat( pattern, new Locale( "fr", "FR" ) );
                String date = simpleDateFormat.format( new Date() );
                lHeure.setText( date );
            }
        };

        Timer leTimeur = new Timer( 100, actionListener );
        this.lHeure = new JLabel();
        add( this.lHeure );

        final int positionYRail = this.hauteur *3/4;
        this.leRail = new Rail( 0, positionYRail, this.largeur );

        final int largeurPortail = this.largeur /3;
        final int hauteurPortail = this.hauteur /2;
        final int positionXPortail = this.largeur /2 - largeurPortail;
        this.lePortail = new Portail( positionXPortail, positionYRail,  largeurPortail, hauteurPortail);

        final int dimensionMoteur = 15;
        final int positionXMoteur = this.largeur /2;
        this.leMoteur = new Moteur( positionXMoteur, positionYRail, dimensionMoteur, lePortail );

        final int dimensionCapteur = 5;
        final int positionXCapteurGauche = positionXMoteur-largeurPortail+(dimensionCapteur-dimensionMoteur)/2;
        final int positionXCapteurDroit = positionXMoteur+largeurPortail+(dimensionCapteur-dimensionMoteur)/2;
        this.capteurDroit = new Capteur( positionXCapteurGauche, positionYRail, dimensionCapteur, this.lePortail );
        this.capteurGauche = new Capteur( positionXCapteurDroit, positionYRail, dimensionCapteur, this.lePortail );

        final int positionXAmpoule = 10;
        final int positionYAmpoule = 10;
        this.ampoule = new Ampoule( positionXAmpoule, positionYAmpoule);

        final int dimensionTelecommande = 10;
        final int positionXTelecommande = (this.largeur -dimensionTelecommande)/2;
        final int positionYTelecommande = 1;
        new Telecommande(positionXTelecommande, positionYTelecommande, dimensionTelecommande,
                this);

        setFocusable( true );
        leTimeur.start();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent( g );
        g.setColor( Color.GRAY );
        g.fillRect( 0, 0, getWidth(), getHeight() );
        this.lHeure.paintComponents( g );
        this.leRail.paintComponent( g );
        this.lePortail.paintComponent( g );
        this.leMoteur.paintComponent( g );
        this.capteurGauche.paintComponent( g );
        this.capteurDroit.paintComponent( g );
        this.ampoule.paintComponent( g );
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension( largeur, hauteur );
    }

    public void actionDroite() {
        lePortail.deplace( +1 );
    }

    public void actionGauche() {
        lePortail.deplace( -1 );
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
