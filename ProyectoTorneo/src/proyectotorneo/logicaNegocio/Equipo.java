/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectotorneo.logicaNegocio;

import java.awt.List;
import java.util.ArrayList;
import proyectotorneo.persistencia.PersistenciaEquipo;

/**
 *
 * @author AMAURYS CASTRO
 */
public class Equipo {
    private String nombreEquipo;
    private String nombreDelegado;
    private String telefono;
    private String correoContacto;

    public Equipo() {
    }

    public Equipo(String nombreequipo, String nombreDelegado, String telefono, String correoContacto) {
        this.nombreEquipo = nombreequipo;
        this.nombreDelegado = nombreDelegado;
        this.telefono = telefono;
        this.correoContacto = correoContacto;
    }

    public String getNombreEquipo() {
        return nombreEquipo;
    }

    public void setNombreEquipo(String nombreEquipo) {
        this.nombreEquipo = nombreEquipo;
    }

    public String getNombreDelegado() {
        return nombreDelegado;
    }

    public void setNombreDelegado(String nombreDelegado) {
        this.nombreDelegado = nombreDelegado;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCorreoContacto() {
        return correoContacto;
    }

    public void setCorreoContacto(String correoContacto) {
        this.correoContacto = correoContacto;
    }

    @Override
    public String toString() {
        return "Equipo{" + "nombreEquipo=" + nombreEquipo + ", nombreDelegado=" + nombreDelegado + ", telefono=" + telefono + ", correoContacto=" + correoContacto + '}';
    }
     
    public static boolean registrarEquipo(Equipo equipo){
        PersistenciaEquipo conexion = new PersistenciaEquipo();
        return conexion.ingresoDatos(equipo);
    }
    public static ArrayList<Equipo> obtenerEquipo(){
        PersistenciaEquipo conexion = new PersistenciaEquipo();
        return conexion.listar();
    }
}
