/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectotorneo.logicaNegocio;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import proyectotorneo.persistencia.PersistenciaPartido;

/**
 *
 * @author AMAURYS CASTRO
 */
public class Partido {
    
    private String fecha;
    private String hora; 
    private String equipoLocal;
    private String equipoVisitante;
    private int golesEquipoLocal;
    private int golesEquipoVisitante;

    public Partido() {
    }

    public Partido(String equipoLocal, String equipoVisitante, String fecha, String hora, int golesEquipoLocal, int golesEquipoVisitante) {
        this.equipoLocal = equipoLocal;
        this.equipoVisitante = equipoVisitante;
        this.fecha = fecha;
        this.hora = hora;
        this.golesEquipoLocal = golesEquipoLocal;
        this.golesEquipoVisitante = golesEquipoVisitante;
    }

    public String getEquipoLocal() {
        return equipoLocal;
    }

    public void setEquipoLocal(String equipoLocal) {
        this.equipoLocal = equipoLocal;
    }

    public String getEquipoVisitante() {
        return equipoVisitante;
    }

    public void setEquipoVisitante(String equipoVisitante) {
        this.equipoVisitante = equipoVisitante;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public int getGolesEquipoLocal() {
        return golesEquipoLocal;
    }

    public void setGolesEquipoLocal(int golesEquipoLocal) {
        this.golesEquipoLocal = golesEquipoLocal;
    }

    public int getGolesEquipoVisitante() {
        return golesEquipoVisitante;
    }

    public void setGolesEquipoVisitante(int golesEquipoVisitante) {
        this.golesEquipoVisitante = golesEquipoVisitante;
    }

    @Override
    public String toString() {
        return "Partido{" + "fecha=" + fecha + ", hora=" + hora + ", equipoLocal=" + equipoLocal + ", equipoVisitante=" + equipoVisitante + ", golesEquipoLocal=" + golesEquipoLocal + ", golesEquipoVisitante=" + golesEquipoVisitante + '}';
    }
    
    
   
    public void registrarGoles(int golesEquipoLocal, int golesEquipoVisitante) {
        this.golesEquipoLocal = golesEquipoLocal;
        this.golesEquipoVisitante = golesEquipoVisitante;
    }

    public String determinarGanador() {
        if (golesEquipoLocal > golesEquipoVisitante) {
            return equipoLocal;
        } else if (golesEquipoLocal < golesEquipoVisitante) {
            return equipoVisitante;
        } else {
            return null; // Empate
        }
    }
    
    public static List<Partido> generarProgramacion(List<String> equipos, List<String> fechas, List<String> horas) {
        List<Partido> programacion = new ArrayList<>();
        if (equipos.size() % 2 != 0) {
            throw new IllegalArgumentException("La cantidad de equipos debe ser par");
        }

        List<String> equiposCopia = new ArrayList<>(equipos);

        if (equiposCopia.size() % 2 != 0) {
            equiposCopia.add("Descanso");
        }

        for (int i = 0; i < equiposCopia.size() - 1; i++) {
            for (int j = i + 1; j < equiposCopia.size(); j++) {
                String fecha = fechas.get(i % fechas.size()); // Ciclar a través de las fechas disponibles
                String hora = horas.get(j % horas.size()); // Ciclar a través de las horas disponibles

                Partido partido = new Partido(equiposCopia.get(i), equiposCopia.get(j), fecha, hora, 0, 0);
                programacion.add(partido);
            }
        }

        Collections.shuffle(programacion);

        
        
    
    
        return programacion;
        
        
        
    }
    
    public static boolean registrarPartido(Partido partido){
        PersistenciaPartido conexion = new PersistenciaPartido();
        return conexion.ingresoDatos(partido);
    }
    public static ArrayList<Partido> obtenerPartidos(){
        PersistenciaPartido conexion = new PersistenciaPartido();
        return conexion.listar();
    }
    
}
