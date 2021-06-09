package fr.epitez;

import javax.swing.*;

public class Telecommande {

    private JButton leBoutton;

    public Telecommande(final int x, final int y, final int dimension, JPanel jpannelOuDoitEtreLeBoutton) {
        this.leBoutton = new JButton("Cliquer ici");
        this.leBoutton.setBounds( x, y, x+dimension, y+dimension );
        jpannelOuDoitEtreLeBoutton.add( this.leBoutton );
    }



}
