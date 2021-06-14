package fr.epitez;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;


public class Maison {

    private final JFrame laFenetre;
    private final JFrame laConsole;
    private final Entree lEntree;

    public Maison() {
        this.laConsole = new JFrame("La console");
        this.laConsole.add(new Console( 0, 0, 500, 200 ));
        this.laConsole.pack();
        this.laConsole.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
        //this.laConsole.setLocationRelativeTo( null );
        this.laConsole.setVisible( true );

        this.laFenetre = new JFrame("L'Entrée");
        this.lEntree = new Entree(0, 0, 500, 200);
        InputMap inputMap = this.lEntree.getInputMap( JPanel.WHEN_IN_FOCUSED_WINDOW );
        ActionMap actionMap = this.lEntree.getActionMap();


        EnregistreActionGauche(inputMap, actionMap);
        EnregistreActionDroit(inputMap, actionMap);

        this.laFenetre.add( this.lEntree );
        this.laFenetre.pack();
        this.laFenetre.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
        this.laFenetre.setLocationRelativeTo( null );
        this.laFenetre.setVisible( true );
    }

    public static void main(String[] args) {
        EventQueue.invokeLater( Maison::new );
    }

    private void EnregistreActionGauche(InputMap inputMap, ActionMap actionMap) {
        Action action = new AbstractAction() {
            public void actionPerformed(ActionEvent e) {
                lEntree.actionGauche();
                laFenetre.repaint();
            }
        };
        inputMap.put( KeyStroke.getKeyStroke( "LEFT" ), "leftAction" );
        actionMap.put( "leftAction", action );
    }

    private void EnregistreActionDroit(InputMap inputMap, ActionMap actionMap) {
        Action action = new AbstractAction() {
            public void actionPerformed(ActionEvent e) {
                lEntree.actionDroite();
                laFenetre.repaint();
            }
        };
        inputMap.put( KeyStroke.getKeyStroke( "RIGHT" ), "rightAction" );
        actionMap.put( "rightAction", action );
    }
}