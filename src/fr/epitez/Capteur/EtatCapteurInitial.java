package fr.epitez.Capteur;

import java.awt.*;

class EtatCapteurInitial implements EtatCapteur {
    private EtatCapteurInitial() {
    }

    private static EtatCapteurInitial INSTANCE = new EtatCapteurInitial();

    static EtatCapteur recupereInstanceUnique() {
        return INSTANCE;
    }

    @Override
    public EtatCapteur paintComponent(Capteur leCapteur, Graphics g) {
        if (leCapteur.detectePortail()) {
            return EtatCapteurSurPortail.recupereInstanceUnique();
        } else {
            return EtatCapteurSansPortail.recupereInstanceUnique();
        }
    }
}
