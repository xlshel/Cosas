/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package proyectocurso;

import proyectocurso.presentacion.GuiPrincipal;

/**
 *
 * @author 92555606
 */
public class ProyectoCurso {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
         java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GuiPrincipal().setVisible(true);
            }
        });
    }
    
}
