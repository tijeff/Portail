package fr.epitez.Capteur;

import java.awt.*;

class EtatCapteurMoteurSurPortail implements EtatCapteur {
    private EtatCapteurMoteurSurPortail() {
    }

    private static EtatCapteurMoteurSurPortail INSTANCE = null;

    static EtatCapteur recupereInstanceUnique() {
        if (INSTANCE == null) {
            INSTANCE = new EtatCapteurMoteurSurPortail();
        }
        return INSTANCE;
    }

    @Override
    public EtatCapteur paintComponent(Capteur leCapteur, Graphics g) {
        g.setColor( Color.BLUE );
        leCapteur.dessineCapteur( g );

        if (!leCapteur.detectePortail()) {
            return EtatCapteurMoteurHorsPortail.recupereInstanceUnique();
        }
        return this;
    }
}
