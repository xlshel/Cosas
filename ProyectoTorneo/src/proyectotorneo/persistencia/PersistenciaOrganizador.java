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
import proyectotorneo.logicaNegocio.Organizador;


/**
 *
 * @author namuel.solorzano
 */
public class PersistenciaOrganizador {
    private Connection con;
    private Statement stm;
    
    public PersistenciaOrganizador(){
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
    
    public boolean ingresoDatos(Organizador organizador){
        boolean registrado = false;
        
        try{
            
            int i = stm.executeUpdate("INSERT INTO organizadorAD VALUES ('"+ organizador.getCedula() + "','"+ organizador.getNombres() +"','"+ organizador.getApellidos() +"','"+organizador.getNombreUsuario()+"','"+organizador.getPassword()+"')");
            System.out.println("Valor de I ---> "+i);
            if(i > 0){
                registrado = true;
            }
        }
        catch(Exception e){
            
        }
        
        return registrado;
    }
    
    /*public boolean eliminarRegistro(String identificacion){
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
     
     */    
     public Organizador buscar(String cedula) {
             Organizador organizador = new Organizador();  
             
             try{ 
                    
                    ResultSet rs = stm.executeQuery("SELECT * FROM organizadorAD WHERE cedula = '"+ cedula + "'");
                    
                    if(rs.next()){
                        organizador.setCedula(rs.getString("cedula"));
                        organizador.setNombres(rs.getString("nombres"));
                        organizador.setApellidos(rs.getString("apellidos"));
                        organizador.setNombreUsuario(rs.getString("nombreusuario"));
                        organizador.setPassword(rs.getString("password"));

                    }                
                    
             }
             catch(Exception e){
                 e.printStackTrace();
             }
          
          return organizador;
     }
     
     public ArrayList<Organizador> listar() {
            ArrayList <Organizador> organizadores = new ArrayList<Organizador>();
            try{ 
                    
                    ResultSet rs = stm.executeQuery("SELECT * FROM organizadorAD");
                    while(rs.next()){
                        Organizador organizador = new Organizador();
                        organizador.setCedula(rs.getString("cedula"));
                        organizador.setNombres(rs.getString("nombres"));
                        organizador.setApellidos(rs.getString("apellidos"));
                        organizador.setNombreUsuario(rs.getString("nombreusuario"));
                        organizador.setPassword(rs.getString("password"));
                        organizadores.add(organizador);
                    }
             }
             catch(Exception e){
                 System.out.println(""+e.getMessage());
                 e.printStackTrace();
             }
        
          return organizadores;
     }
    
    
}
