package fr.epitez;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;


public class Maison extends JFrame {

    Panneau lEntree = new Panneau(  );

    public Maison() {
        InputMap inputMap = lEntree.getInputMap( JPanel.WHEN_IN_FOCUSED_WINDOW );
        ActionMap actionMap = lEntree.getActionMap();

        EnregistreActionBas(inputMap, actionMap);
        EnregistreActionGauche(inputMap, actionMap);
        EnregistreActionDroit(inputMap, actionMap);

        add( lEntree );
        pack();

        setDefaultCloseOperation( EXIT_ON_CLOSE );
        setLocationRelativeTo( null );
        setVisible( true );
    }

    public static void main(String[] args) {
        EventQueue.invokeLater( Maison::new );
    }

    private void EnregistreActionBas(InputMap inputMap, ActionMap actionMap) {
        Action action = new AbstractAction() {
            public void actionPerformed(ActionEvent e) {
                lEntree.actionStop();
                repaint();
            }
        };
        inputMap.put( KeyStroke.getKeyStroke( "DOWN" ), "downAction" );
        actionMap.put( "downAction", action );
    }

    private void EnregistreActionGauche(InputMap inputMap, ActionMap actionMap) {
        Action action = new AbstractAction() {
            public void actionPerformed(ActionEvent e) {
                lEntree.actionGauche();
                repaint();
            }
        };
        inputMap.put( KeyStroke.getKeyStroke( "LEFT" ), "leftAction" );
        actionMap.put( "leftAction", action );
    }

    private void EnregistreActionDroit(InputMap inputMap, ActionMap actionMap) {
        Action action = new AbstractAction() {
            public void actionPerformed(ActionEvent e) {
                lEntree.actionDroite();
                repaint();
            }
        };
        inputMap.put( KeyStroke.getKeyStroke( "RIGHT" ), "rightAction" );
        actionMap.put( "rightAction", action );
    }
}