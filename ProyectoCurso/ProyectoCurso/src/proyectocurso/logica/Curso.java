/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectocurso.logica;

import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;
import proyectocurso.persistencia.Persistencia;

/**
 *
 * @author 92555606
 */
public class Curso implements Serializable {
    private String codigo;
    private String nombre;
    private int semestre;
    private ArrayList<Estudiante> estudiantes = new ArrayList<Estudiante>();

    public Curso() {
    }

    public Curso(String codigo, String nombre, int semestre) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.semestre = semestre;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getSemestre() {
        return semestre;
    }

    public void setSemestre(int semestre) {
        this.semestre = semestre;
    }
    
    public void matricularEstudiante(Estudiante estudiante){
        this.estudiantes.add(estudiante);
    }

    public ArrayList<Estudiante> getEstudiantes() {
        return estudiantes;
    }
    
    
    public void registrarCurso(){
        Persistencia.conectarArchivo(new File("cursos.dat"), "grabar");
        Persistencia.grabarObjeto(this);
    }
    
    public static ArrayList obtenerCursos(){
        Persistencia.conectarArchivo(new File("cursos.dat"), "leer");
        return Persistencia.leerObjeto();
    }
    
}
