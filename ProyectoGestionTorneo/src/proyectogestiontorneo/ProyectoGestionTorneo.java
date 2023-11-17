package proyectogestiontorneo;

import GUIPresentacion.MNPrincipal;

public class ProyectoGestionTorneo {

    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MNPrincipal().setVisible(true);
                new MNPrincipal().setLocationRelativeTo(null);
                new MNPrincipal().setResizable(false);
            }
        });
    }

}
