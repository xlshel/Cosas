package Persistencia;

import LogicaDeNegocios.Organizador;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class PersistenciaOrganizador {

    private Connection con;
    private Statement stm;

    public PersistenciaOrganizador() {
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            //Class.forName("org.apache.derby.jdbc.ClientDriver").newInstance();
            con = DriverManager.getConnection("jdbc:mysql://sql10.freemysqlhosting.net:3306/sql10659331", "sql10659331", "feY2Wal7y3");
            //con = DriverManager.getConnection("jdbc:derby://localhost:1527/juegoSuma", "root","root");
            stm = con.createStatement();
        } catch (Exception e) {
            System.out.println("" + e.getMessage());
            e.printStackTrace();
        }
    }

    public boolean ingresoDatos(Organizador gestiondetorneo) {
        boolean registrado = false;

        try {

            int i = stm.executeUpdate("INSERT INTO organizador VALUES ('" + gestiondetorneo.getCedula() + "','" + gestiondetorneo.getNombre() + "','" + gestiondetorneo.getApellido() + "')" + "','" + gestiondetorneo.getNombreUsuario() + "','" + gestiondetorneo.getPassword());
            System.out.println("Valor de I ---> " + i);
            if (i > 0) {
                registrado = true;
            }
        } catch (Exception e) {

        }

        return registrado;
    }

    public boolean eliminarRegistro(String cedula) {
        boolean eliminado = false;
        try {

            int i = stm.executeUpdate("DELETE FROM prueba WHERE identificacion = '" + cedula + "'");
            if (i > 0) {
                eliminado = true;
            }
        } catch (Exception e) {
            System.out.println("" + e.getMessage());
        }
        return eliminado;
    }

    public boolean actualizarRegistro(Organizador organizador) {
        boolean actualizado = false;
        try {

            int i = stm.executeUpdate("UPDATE prueba SET nombres = '" + organizador.getCedula() + "', apellidos = " + organizador.getNombre() + " WHERE identificacion = '" + organizador.getNombreUsuario() + "'" + organizador.getPassword());
            if (i > 0) {
                actualizado = true;
            }
        } catch (Exception e) {

        }
        return actualizado;
    }

    public Organizador buscar(String cedula) {
        Organizador organizador = new Organizador();

        try {

            ResultSet rs = stm.executeQuery("SELECT * FROM prueba WHERE identificacion = '" + cedula + "'");
            if (rs.next()) {

                organizador.setCedula(rs.getString("cedula"));
                organizador.setNombre(rs.getString("nombres"));
                organizador.setApellido(rs.getString("apellidos"));
                organizador.setNombreUsuario(rs.getString("nombre usuario"));
                organizador.setPassword(rs.getString("password"));

            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return organizador;
    }

    public ArrayList<Organizador> listar() {
        ArrayList<Organizador> organizadors = new ArrayList<Organizador>();
        try {

            ResultSet rs = stm.executeQuery("SELECT * FROM prueba");
            while (rs.next()) {
                Organizador organizador = new Organizador();
                organizador.setCedula(rs.getString("cedula"));
                organizador.setNombre(rs.getString("nombre"));
                organizador.setApellido(rs.getString("apellido"));
                organizador.setNombreUsuario(rs.getString("nombre usuario"));
                organizadors.add(organizador);
            }
        } catch (Exception e) {
            System.out.println("" + e.getMessage());
            e.printStackTrace();
        }

        return organizadors;
    }

}
