package fr.epitez;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Telecommande implements ActionListener {

    private JButton leBoutton;

    public Telecommande(final int x, final int y, final int dimension, JPanel jpannelOuDoitEtreLeBoutton) {
        this.leBoutton = new JButton("Cliquer ici");
        this.leBoutton.setBounds( x, y, x+dimension, y+dimension );
        this.leBoutton.addActionListener( this );
        jpannelOuDoitEtreLeBoutton.add( this.leBoutton );
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("Clique");
    }
}
