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
import proyectotorneo.logicaNegocio.Torneo;


/**
 *
 * @author namuel.solorzano
 */
public class PersistenciaTorneo {
    private Connection con;
    private Statement stm;
    
    public PersistenciaTorneo(){
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
    
    public boolean ingresoDatos(Torneo torneo){
        boolean registrado = false;
        
        try{
            
            int i = stm.executeUpdate("INSERT INTO torneoAD VALUES ('"+ torneo.getNombreTorneo() + "','"+ torneo.getFechaInicio() +"','"+ torneo.getFechaFin() +"','"+ torneo.getMunicipio() +"')");
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
     public ArrayList<Torneo> listar() {
            ArrayList<Torneo> torneos = new ArrayList<Torneo>();
            try{ 
                    
                    ResultSet rs = stm.executeQuery("SELECT * FROM torneoAD");
                    while(rs.next()){
                        Torneo torneo = new Torneo();
                        torneo.setNombreTorneo(rs.getString("nombretorneo"));
                        torneo.setFechaInicio(rs.getString("fechainicio"));
                        torneo.setFechaFin(rs.getString("fechafin"));
                        torneo.setMunicipio(rs.getString("municipio"));
                        torneos.add(torneo);
                    }
             }
             catch(Exception e){
                 System.out.println(""+e.getMessage());
                 e.printStackTrace();
             }
        
          return torneos;
     }
    
    
}
