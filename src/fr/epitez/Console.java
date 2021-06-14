package fr.epitez;

import javax.swing.*;

public class Console extends JTextArea {

    public Console(final int x, final int y, final int largeur, final int hauteur) {
        this.setBounds( x, y, largeur, hauteur );
        this.append( "--< Console Démarrée >--\n" );
    }
}
