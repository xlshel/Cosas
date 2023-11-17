package LogicaDeNegocios;

import Persistencia.PersistenciaOrganizador;

public class Organizador {

    private String cedula;
    private String nombre;
    private String apellido;
    private String nombreUsuario;
    private String password;

    public Organizador() {
        this.cedula = "";
    }

    public Organizador(String cedula, String nombre, String apellido, String nombreUsuario, String password) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.apellido = apellido;
        this.nombreUsuario = nombreUsuario;
        this.password = password;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
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
        return "GestionDeTorneo{" + "cedula=" + cedula + ", nombre=" + nombre + ", apellido=" + apellido + ", nombreUsuario=" + nombreUsuario + ", password=" + password + '}';
    }

    public static boolean registrarOrganizador(Organizador organizador) {
        PersistenciaOrganizador conexion = new PersistenciaOrganizador();

        return conexion.ingresoDatos(organizador);
    }

    public static Organizador buscarOrganizador(String cedula) {
        PersistenciaOrganizador conexion = new PersistenciaOrganizador();
        return conexion.buscar(cedula);
    }
}
