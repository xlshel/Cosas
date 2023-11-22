/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package proyectotorneo;

import java.util.List;

import proyectotorneo.logicaNegocio.Partido;
import static proyectotorneo.logicaNegocio.Partido.generarProgramacion;
import proyectotorneo.presentacion.GuiPrincipal;

/**
 *
 * @author AMAURYS CASTRO
 */
public class ProyectoTorneo {

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
        /*
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GuiInicioSeccion().setVisible(true);
            }
        });
         */

        List<String> equipos = List.of();
        List<String> fechas = List.of("2023-01-01", "2023-02-01");
        List<String> horas = List.of("10:00 AM", "03:00 PM");

        List<Partido> programacion = generarProgramacion(equipos, fechas, horas);

        System.out.println("Programación de partidos:");
        for (Partido partido : programacion) {
            System.out.println(partido.getEquipoLocal() + " vs " + partido.getEquipoVisitante()
                    + " - Fecha: " + partido.getFecha() + ", Hora: " + partido.getHora());
        }

        /*
        ArrayList<Organizador> organizadores = Organizador.obtenerOrganizador();
        for (Organizador organizador : organizadores) {
            System.out.println(organizador.toString());
        } 

        Equipo equipo2 = new Equipo("Once caldas","Peter","3202478","once.com");
        //equipo2.agregarJugador(new Jugador("Jugador3","","",2,"2"));
        //equipo2.agregarJugador(new Jugador("Jugador4","","",23,"3"));
        
        Equipo equipo1 = new Equipo("Junior","Manolo","31099890","Junior.com");
        Equipo.registrarEquipo(equipo1);
        Equipo.registrarEquipo(equipo2);
        
        ArrayList<Equipo> equipos = Equipo.obtenerEquipo();
        for (Equipo equipo : equipos) {
            System.out.println(equipo.toString());
        }
       // ArrayList<Partido> programacion = torneo.getProgramacion();

        //for (Partido partido : programacion) {
          //  System.out.println(partido.getEquipoLocal().getNombre() + " vs " + partido.getEquipoVisitante().getNombre());
        //}
        Partido partido = new Partido(equipo2.getNombreEquipo(),equipo1.getNombreEquipo(),"20-10","8:00",1,3);
        Partido.registrarPartido(partido);
        
        ArrayList<Partido> partidos = Partido.obtenerPartidos();
        for (Partido partido1 : partidos) {
            System.out.println(partido1.toString());
        }
        //Equipo ganador = partido.determinarGanador();
        //if (ganador != null) {
          //  System.out.println("El equipo ganador es: " + ganador.getNombre());
        //} else {
          //  System.out.println("El partido terminó en empate.");
        //} 
        
        Torneo torneo2 = new Torneo("Torneo de Futbol","20","10","corozal");
        Torneo.registrarTorneo(torneo2);
        
        ArrayList<Torneo> torneos = Torneo.obtenerTorneo();
        for (Torneo torneo1 : torneos) {
            System.out.println(torneo1.toString());
        }*/
    }
}
