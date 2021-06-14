package fr.epitez;

import javax.swing.*;
import java.awt.*;

public class Ampoule extends JPanel  {
    private int x;
    private int y;
    private int tick;

    public Ampoule(int x, int y) {
        this.x = x;
        this.y = y;
        this.tick = 0;
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent( g );
        tick = ++tick % 20;
        g.setColor( Color.DARK_GRAY );
        g.fillRect( x-5, y+3, 5, 5 );
        g.setColor( Color.LIGHT_GRAY );
        if(tick>9) {
            g.fillOval( x, y, 10, 10 );
        } else {
            g.drawOval( x, y, 10, 10 );
        }
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(5+10, 5+10);
    }
}
