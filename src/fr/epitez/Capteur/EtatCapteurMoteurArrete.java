package fr.epitez.Capteur;

import java.awt.*;

class EtatCapteurMoteurArrete implements EtatCapteur {
    private EtatCapteurMoteurArrete() {
    }

    private static EtatCapteurMoteurArrete INSTANCE = new EtatCapteurMoteurArrete();

    static EtatCapteur recupereInstanceUnique() {
        return INSTANCE;
    }

    @Override
    public EtatCapteur paintComponent(Capteur leCapteur, Graphics g) {
        if (leCapteur.detectePortail()) {
            return EtatCapteurMoteurSurPortail.recupereInstanceUnique();
        } else {
            return EtatCapteurMoteurHorsPortail.recupereInstanceUnique();
        }
    }
}
