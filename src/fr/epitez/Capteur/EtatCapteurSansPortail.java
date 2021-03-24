package fr.epitez.Capteur;

import java.awt.*;

class EtatCapteurSansPortail implements EtatCapteur {
    private EtatCapteurSansPortail() {
    }

    private static EtatCapteurSansPortail INSTANCE = null;

    static EtatCapteur recupereInstanceUnique() {
        if (INSTANCE == null) {
            INSTANCE = new EtatCapteurSansPortail();
        }
        return INSTANCE;
    }

    @Override
    public EtatCapteur paintComponent(Capteur leCapteur, Graphics g) {
        g.setColor( Color.YELLOW );
        leCapteur.dessineCapteur( g );

        if (leCapteur.detectePortail()) {
            return EtatCapteurSurPortail.recupereInstanceUnique();
        }
        return this;
    }
}
