package fr.epitez.Capteur;

import java.awt.*;

class EtatCapteurMoteurHorsPortail implements EtatCapteur {
    private EtatCapteurMoteurHorsPortail() {
    }

    private static EtatCapteurMoteurHorsPortail INSTANCE = null;

    static EtatCapteur recupereInstanceUnique() {
        if (INSTANCE == null) {
            INSTANCE = new EtatCapteurMoteurHorsPortail();
        }
        return INSTANCE;
    }

    @Override
    public EtatCapteur paintComponent(Capteur leCapteur, Graphics g) {
        g.setColor( Color.YELLOW );
        leCapteur.dessineCapteur( g );

        if (leCapteur.detectePortail()) {
            return EtatCapteurMoteurSurPortail.recupereInstanceUnique();
        }
        return this;
    }
}
