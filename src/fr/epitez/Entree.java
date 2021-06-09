package fr.epitez;

import fr.epitez.Capteur.Capteur;
import fr.epitez.moteur.Moteur;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class Entree extends JPanel implements ActionListener {

    static final int largeurFenetre = 500;
    static final int hauteurFenetre = 100;

    private final JLabel lHeure;
    private final Portail lePortail;
    private final Moteur leMoteur;
    private final Capteur capteurDroit;
    private final Capteur capteurGauche;
    private final Ampoule ampoule;
    private final Telecommande teleCommande;

    public Entree() {
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
        this.lHeure.setBounds( 0, 0, 200, 50 );
        add( lHeure );

        final int largeurPortail = largeurFenetre/3;
        final int hauteurPortail = hauteurFenetre/2;
        final int positionXPortail = largeurFenetre/2 - largeurPortail;
        final int positionYPortail = hauteurFenetre-hauteurPortail;

        this.lePortail = new Portail( positionXPortail, positionYPortail,  largeurPortail, hauteurPortail);

        final int dimensionMoteur = 15;
        final int positionXMoteur = largeurFenetre/2;
        final int positionYMoteur = hauteurFenetre;
        this.leMoteur = new Moteur( positionXMoteur, positionYMoteur, dimensionMoteur, lePortail );

        final int dimensionCapteur = 15;
        final int positionXCapteurGauche = positionXMoteur-largeurPortail-dimensionCapteur/2;
        final int positionXCapteurDroit = positionXMoteur+largeurPortail-dimensionMoteur+dimensionCapteur/2;
        final int positionYCapteur = hauteurFenetre;
        this.capteurDroit = new Capteur( positionXCapteurGauche, positionYCapteur, dimensionCapteur, this.lePortail );
        this.capteurGauche = new Capteur( positionXCapteurDroit, positionYCapteur, dimensionCapteur, this.lePortail );

        final int positionXAmpoule = 10;
        final int positionYAmpoule = 10;
        this.ampoule = new Ampoule( positionXAmpoule, positionYAmpoule);

        final int dimensionTelecommande = 10;
        final int positionXTelecommande = largeurFenetre-dimensionTelecommande;
        final int positionYTelecommande = 1;
        this.teleCommande = new Telecommande(positionXTelecommande, positionYTelecommande, dimensionTelecommande,
                this);

        addMouseListener( new Entree.ReflexeSouris() );
        setFocusable( true );
        leTimeur.start();
    }

    protected void paintComponent(Graphics g) {
        super.paintComponent( g );
        g.setColor( Color.GRAY );
        g.fillRect( 0, 0, getWidth(), getHeight() );
        lePortail.paintComponent( g );
        leMoteur.paintComponent( g );
        capteurGauche.paintComponent( g );
        capteurDroit.paintComponent( g );
        ampoule.paintComponent( g );
    }

    public Dimension getPreferredSize() {
        return new Dimension( largeurFenetre, hauteurFenetre );
    }

    public void actionDroite() {
        leMoteur.tourneADroite();
    }

    public void actionGauche() {
        leMoteur.tourneAGauche();
    }

    public void actionStop() {
        leMoteur.arreteMoteur();
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

    private class ReflexeSouris extends MouseAdapter {
        public void mousePressed(MouseEvent e) {
            switch (e.getModifiersEx()) {
                case MouseEvent.BUTTON1_DOWN_MASK -> leMoteur.appuieBouton1();
                case MouseEvent.BUTTON3_DOWN_MASK -> leMoteur.appuieBouton3();
            }
        }
    }
}
