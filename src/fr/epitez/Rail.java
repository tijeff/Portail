package fr.epitez;

import javax.swing.*;
import java.awt.*;

public class Rail extends JPanel  {
    private final int x;
    private final int y;
    private final int longueur;

    public Rail(final int x, final int y, final int longueur) {
        this.x = x;
        this.y = y;
        this.longueur = longueur;
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent( g );
        g.setColor( Color.BLACK );
        g.drawLine( x, y, x+longueur, y);
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(longueur, 1);
    }
}
