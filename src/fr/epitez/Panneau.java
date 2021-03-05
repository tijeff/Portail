package fr.epitez;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class Panneau extends JPanel implements ActionListener {

    static final int largeurFenetre = 500;
    static final int hauteurFenetre = 100;

    private final JLabel lHeure;
    private final Portail lePortail;
    private final Moteur leMoteur;
    private final Capteur capteurDroit;
    private final Capteur capteurGauche;

    public Panneau() {
        Panneau lePanneau = this;
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

        this.lePortail = new Portail( largeurFenetre, hauteurFenetre );
        this.leMoteur = new Moteur( largeurFenetre, hauteurFenetre, lePortail );
        this.capteurDroit = new Capteur( 10, hauteurFenetre, this.lePortail, this.leMoteur );
        this.capteurGauche = new Capteur( largeurFenetre-10, hauteurFenetre, this.lePortail, this.leMoteur );

        addMouseListener( new Panneau.ReflexeSouris() );
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
