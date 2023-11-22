/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectotorneo.logicaNegocio;

/**
 *
 * @author AMAURYS CASTRO
 */
public class Jugador {
    private String numeroId;
    private String nombre;
    private String apellido;
    private int edad;
    private String numeroCamisa;
    

    public Jugador() {
    }

    public Jugador(String numeroId, String nombre, String apellido, int edad, String numeroCamisa) {
        this.numeroId = numeroId;
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.numeroCamisa = numeroCamisa;
    }

    public String getNumeroId() {
        return numeroId;
    }

    public void setNumeroId(String numeroId) {
        this.numeroId = numeroId;
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

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getNumeroCamisa() {
        return numeroCamisa;
    }

    public void setNumeroCamisa(String numeroCamisa) {
        this.numeroCamisa = numeroCamisa;
    }

}
