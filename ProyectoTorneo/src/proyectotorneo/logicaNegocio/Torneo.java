/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectotorneo.logicaNegocio;

import java.util.ArrayList;
import proyectotorneo.persistencia.PersistenciaTorneo;

/**
 *
 * @author AMAURYS CASTRO
 */
public class Torneo {
    private String nombreTorneo;
    private String fechaInicio;
    private String fechaFin;
    private String municipio;
    

    public Torneo() {
    }

    public Torneo(String nombreTorneo, String fechaInicio, String fechaFin, String municipio) {
        this.nombreTorneo = nombreTorneo;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.municipio = municipio;
    }
    
    /*
     public void agregarEquipo(Equipo equipo) {
        equipos.add(equipo);
    }

    public void generarProgramacion() {
        for (int i = 0; i < equipos.size() - 1; i++) {
            for (int j = i + 1; j < equipos.size(); j++) {
                Partido partido = new Partido(equipos.get(i), equipos.get(j));
                programacion.add(partido);
            }
        }
    }
    public void registrarResultado(Partido partido, int golesEquipoLocal, int golesEquipoVisitante) {
        partido.registrarGoles(golesEquipoLocal, golesEquipoVisitante);

        Equipo equipoLocal = partido.getEquipoLocal();
        Equipo equipoVisitante = partido.getEquipoVisitante();

        equipoLocal.aumentarPartidosJugados();
        equipoVisitante.aumentarPartidosJugados();

        if (golesEquipoLocal > golesEquipoVisitante) {
            equipoLocal.aumentarPartidosGanados();
            equipoVisitante.aumentarPartidosPerdidos();
        } else if (golesEquipoLocal < golesEquipoVisitante) {
            equipoLocal.aumentarPartidosPerdidos();
            equipoVisitante.aumentarPartidosGanados();
        } else {
            equipoLocal.aumentarPartidosEmpatados();
            equipoVisitante.aumentarPartidosEmpatados();
        }
*/

    public String getNombreTorneo() {
        return nombreTorneo;
    }

    public void setNombreTorneo(String nombreTorneo) {
        this.nombreTorneo = nombreTorneo;
    }

    public String getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(String fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public String getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(String fechaFin) {
        this.fechaFin = fechaFin;
    }

    public String getMunicipio() {
        return municipio;
    }

    public void setMunicipio(String municipio) {
        this.municipio = municipio;
    }

    @Override
    public String toString() {
        return "Torneo{" + "nombreTorneo=" + nombreTorneo + ", fechaInicio=" + fechaInicio + ", fechaFin=" + fechaFin + ", municipio=" + municipio + '}';
    }
    
     public static boolean registrarTorneo(Torneo torneo){
        PersistenciaTorneo conexion = new PersistenciaTorneo();
        return conexion.ingresoDatos(torneo);
    }
    
    public static ArrayList<Torneo> obtenerTorneo(){
        PersistenciaTorneo conexion = new PersistenciaTorneo();
        return conexion.listar();
    }
    
    }
    


