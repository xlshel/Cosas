/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectotorneo.persistencia;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import proyectotorneo.logicaNegocio.Equipo;


/**
 *
 * @author namuel.solorzano
 */
public class PersistenciaEquipo {
    private Connection con;
    private Statement stm;
    
    public PersistenciaEquipo(){
        try{
            Class.forName("com.mysql.jdbc.Driver").newInstance();  
            //Class.forName("org.apache.derby.jdbc.ClientDriver").newInstance();
            con = DriverManager.getConnection("jdbc:mysql://sql10.freemysqlhosting.net:3306/sql10662033", "sql10662033","T3JhuECWQS");
            //con = DriverManager.getConnection("jdbc:derby://localhost:1527/juegoSuma", "root","root");
            stm = con.createStatement();
        }
        catch(Exception e){
            System.out.println(""+e.getMessage());
            e.printStackTrace();
        }
    }
    
    public boolean ingresoDatos(Equipo equipo){
        boolean registrado = false;
        
        try{
            
            int i = stm.executeUpdate("INSERT INTO equiposAD VALUES ('"+ equipo.getNombreEquipo() + "','"+ equipo.getNombreDelegado() +"','"+ equipo.getCorreoContacto() +"','"+ equipo.getTelefono() +"')");
            System.out.println("Valor de I ---> "+i);
            if(i > 0){
                registrado = true;
            }
        }
        catch(Exception e){
            
        }
        
        return registrado;
    }
    /*
    public boolean eliminarRegistro(String identificacion){
        boolean eliminado = false;
        try{
            
            int i = stm.executeUpdate("DELETE FROM prueba WHERE identificacion = '" + identificacion +"'");
            if(i > 0){
                eliminado = true;
            }
        }
        catch(Exception e){
            System.out.println(""+e.getMessage());
        }
        return eliminado;
    }
    
     public boolean actualizarRegistro(Padre padre){
        boolean actualizado = false;
        try{
            
            int i = stm.executeUpdate("UPDATE prueba SET nombres = '"+ padre.getNombres() + "', apellidos = "+ padre.getApellidos() + " WHERE identificacion = '"+ padre.getIdentificacion()+"'");
            if(i > 0){
                actualizado = true;
            }
        }
        catch(Exception e){
            
        }
        return actualizado;
    }
     
         
     public Padre buscar(String identificacion) {
             Padre padre = new Padre();  
             
             try{ 
                    
                    ResultSet rs = stm.executeQuery("SELECT * FROM prueba WHERE identificacion = '"+ identificacion + "'");
                    rs.next();
                    padre.setIdentificacion(rs.getString("identificacion"));
                    padre.setNombres(rs.getString("nombres"));
                    padre.setApellidos(rs.getString("apellidos"));
                   
                                       
                    
             }
             catch(Exception e){
                 e.printStackTrace();
             }
          
          return padre;
     }
     */
     public ArrayList<Equipo> listar() {
            ArrayList <Equipo> equipos = new ArrayList<Equipo>();
            try{ 
                    
                    ResultSet rs = stm.executeQuery("SELECT * FROM equiposAD");
                    while(rs.next()){
                        Equipo equipo = new Equipo();
                        equipo.setNombreEquipo(rs.getString("nombre"));
                        equipo.setNombreDelegado(rs.getString("nombredelegado"));
                        equipo.setTelefono(rs.getString("telefonocontacto"));
                        equipo.setCorreoContacto(rs.getString("correocontacto"));
                        equipos.add(equipo);
                    }
             }
             catch(Exception e){
                 System.out.println(""+e.getMessage());
                 e.printStackTrace();
             }
        
          return equipos;
     }
    
    
}
