package fr.epitez.Capteur;

import java.awt.*;

class EtatCapteurSurPortail implements EtatCapteur {
    private EtatCapteurSurPortail() {
    }

    private static EtatCapteurSurPortail INSTANCE = null;

    static EtatCapteur recupereInstanceUnique() {
        if (INSTANCE == null) {
            INSTANCE = new EtatCapteurSurPortail();
        }
        return INSTANCE;
    }

    @Override
    public EtatCapteur paintComponent(Capteur leCapteur, Graphics g) {
        g.setColor( Color.BLUE );
        leCapteur.dessineCapteur( g );

        if (!leCapteur.detectePortail()) {
            return EtatCapteurSansPortail.recupereInstanceUnique();
        }
        return this;
    }
}
