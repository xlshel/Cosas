/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectotorneo.logicaNegocio;

import java.util.ArrayList;
import proyectotorneo.persistencia.PersistenciaOrganizador;

/**
 *
 * @author AMAURYS CASTRO
 */
public class Organizador {
    private String cedula;
    private String nombres;
    private String apellidos;
    private String nombreUsuario;
    private String password;

    public Organizador() {
        this.cedula = "";
    }

    public Organizador(String cedula, String nombres, String apellidos, String nombreUsuario, String password) {
        this.cedula = cedula;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.nombreUsuario = nombreUsuario;
        this.password = password;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Organizador{" + "cedula=" + cedula + ", nombre=" + nombres + ", apellidos=" + apellidos + ", nombreUsuario=" + nombreUsuario + ", password=" + password + '}';
    }
    
    public static boolean registrarOrganizador(Organizador organizador){
        PersistenciaOrganizador conexion = new PersistenciaOrganizador();
        return conexion.ingresoDatos(organizador);
    }
    
    public static Organizador buscarOrganizador(String cedula){
        PersistenciaOrganizador conexion = new PersistenciaOrganizador();
        return conexion.buscar(cedula);
    }
    
    public static ArrayList<Organizador> obtenerOrganizador(){
        PersistenciaOrganizador conexion = new PersistenciaOrganizador();
        return conexion.listar();
    }
    
}
