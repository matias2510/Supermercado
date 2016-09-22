
package supermercado_tottus;
import java.sql.*;
import javax.swing.JOptionPane;

public class Clase_tottus
{
    Connection conexion = null;
    Statement sentencia = null;
    
    public void crearbasededatos ()
    {
        try
        {
            Class.forName("org.sqlite.JDBC");
            conexion = DriverManager.getConnection("jdbc:sqlite:supermercado.sqlite");
        }
        catch (ClassNotFoundException | SQLException e)
        {
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
            System.exit(0);
        }
        JOptionPane.showMessageDialog(null, "Base de datos creada!!!");
        
    }
    
    public void creartablaproducto()
    {
        try
        {
            Class.forName("org.sqlite.JDBC");
            conexion = DriverManager.getConnection("jdbc:sqlite:supermercado.sqlite");
            sentencia = (Statement) conexion.createStatement();
            
            String SQL = "CREATE TABLE PRODUCTO" + 
                    "(ID        INT     PRIMARY KEY NOT NULL,"+ 
                    " NOMBRE    TEXT    NOT NULL," +
                    " PRECIO      INT)";
            
            sentencia.executeUpdate(SQL);
            sentencia.close();
            conexion.close();
            
        }
        catch(ClassNotFoundException | SQLException e)
        {
            JOptionPane.showMessageDialog(null, "ERROR: "+ e.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
            System.exit(0);
               
        }
        
        JOptionPane.showMessageDialog(null, "Tabla Creada Con Exito!!");
        
    }
    
    
    public void creartablacliente()
    {
        {
        try
        {
            Class.forName("org.sqlite.JDBC");
            conexion = DriverManager.getConnection("jdbc:sqlite:supermercado.sqlite");
            sentencia = (Statement) conexion.createStatement();
            
            String SQL = "CREATE TABLE CLIENTE" + 
                    "(RUT        INT     PRIMARY KEY NOT NULL,"+ 
                    " NOMBRE    TEXT    NOT NULL," +
                    " EDAD      INT)";
            
            sentencia.executeUpdate(SQL);
            sentencia.close();
            conexion.close();
            
        }
        catch(ClassNotFoundException | SQLException e)
        {
            JOptionPane.showMessageDialog(null, "ERROR: "+ e.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
            System.exit(0);
               
        }
        
        JOptionPane.showMessageDialog(null, "Tabla Creada Con Exito!!");
        
    }
           
        
}
    public void insertarproducto(String[] datos ) //int id, string nombre, int precio//
    {
        try
        {
            Class.forName("org.sqlite.JDBC");
            conexion = DriverManager.getConnection("jdbc:sqlite:supermercado.sqlite");
            conexion.setAutoCommit(false);
            
            sentencia = (Statement) conexion.createStatement();
            
            String SQL = "INSERT INTO PRODUCTO (ID, NOMBRE, PRECIO) " +
                    "VALUES ('"+datos[0]+"','"+datos[1]+"','"+datos[2]+"')";  //('"+id+"','"+nombre+"','"+precio+"')
            
            sentencia.executeUpdate(SQL);
            sentencia.close();
            conexion.commit();
            conexion.close();
            
        }
        catch(ClassNotFoundException | SQLException e)
        {
            JOptionPane.showMessageDialog(null, "Error:" + e.getMessage(),"Error", JOptionPane.ERROR_MESSAGE);
            System.exit(0);
            System.err.println("Error : " + e.getMessage());
            System.exit(0);
        }
        
        JOptionPane.showMessageDialog(null, "Datos Ingresados Con Exito!!!");
        
    }
    
  
    public void insertarcliente(String[]datos)    ///(int rut,String nombre, int edad)
    {
        try
        {
            Class.forName("org.sqlite.JDBC");
            conexion = DriverManager.getConnection("jdbc:sqlite:supermercado.sqlite");
            conexion.setAutoCommit(false);
            
            sentencia = (Statement) conexion.createStatement();
            
            String SQL = "INSERT INTO CLIENTE (RUT, NOMBRE, EDAD) " +
                    "VALUES ('"+datos[0]+"','"+datos[1]+"','"+datos[2]+"')"; ///('"+rut+"','"+nombre+"','"+edad+"')";
            
            sentencia.executeUpdate(SQL);
            sentencia.close();
            conexion.commit();
            conexion.close();
            
        }
        catch(ClassNotFoundException | SQLException e)
        {
            JOptionPane.showMessageDialog(null, "Error:" + e.getMessage(),"Error", JOptionPane.ERROR_MESSAGE);
            System.exit(0);
            System.err.println("Error : " + e.getMessage());
            System.exit(0);
        }
        
        JOptionPane.showMessageDialog(null, "Datos Ingresados Con Exito!!!");
        
    }
        public void actualizarproducto(String[]datos ) throws SQLException, ClassNotFoundException ///(int id, String nombre,int precio)
        {
            try{
                 Class.forName("org.sqlite.JDBC");
            conexion = DriverManager.getConnection("jdbc:sqlite:supermercado.sqlite");
            conexion.setAutoCommit(false);
            sentencia = conexion.createStatement();
            
            String SQL ="UPDATE PRODUCTO SET NOMBRE='"+datos[1]+"',PRECIO='"+datos[2]+"' WHERE ID='"+datos[0]+"'"; ///'"+nombre+"',PRECIO='"+precio+"' WHERE ID='"+id+"'";
            
            sentencia.executeUpdate(SQL);
            conexion.commit();
            
            sentencia.close();
            conexion.close();
                
            }
           
            catch (ClassNotFoundException | SQLException e)
            {
                JOptionPane.showMessageDialog(null, "error: "+e.getMessage());
                
            }
            JOptionPane.showMessageDialog(null, "Datos Actulizado Con Exito");
        }
        
        
         public void actualizarcliente(String[] datos) throws SQLException, ClassNotFoundException  //(int rut, String nombre,int edad)
        {
            try
            {
                 Class.forName("org.sqlite.JDBC");
                 conexion = DriverManager.getConnection("jdbc:sqlite:supermercado.sqlite");
                 conexion.setAutoCommit(false);
                 sentencia = conexion.createStatement();
            
                String SQL ="UPDATE CLIENTE SET NOMBRE='"+datos[1]+"',EDAD='"+datos[2]+"' WHERE RUT='"+datos[0]+"'"; ///'"+nombre+"',EDAD='"+edad+"' WHERE RUT='"+rut+"'";
            
                sentencia.executeUpdate(SQL);
                conexion.commit();
            
                sentencia.close();
                conexion.close();
                
               }
           
                catch (ClassNotFoundException | SQLException e)
               {
                JOptionPane.showMessageDialog(null, "error: "+e.getMessage());
                
               }
               JOptionPane.showMessageDialog(null, "Datos Actulizado Con Exito");
        
        
        
        
    
}
         public void eliminarproducto(int id, String producto,int precio){
             
             try
        {
            Class.forName("org.sqlite.JDBC");
            conexion = DriverManager.getConnection("jdbc:sqlite:supermercado.sqlite");
            conexion.setAutoCommit(false);
            sentencia = conexion.createStatement();
            
            String SQL= "DELETE FROM PRODUCTO WHERE ID='"+id+"'";
            
            sentencia.executeUpdate(SQL);
            conexion.commit();
            
            sentencia.close();
            conexion.close();
            
        }
        catch(ClassNotFoundException | SQLException e)
        {
            JOptionPane.showMessageDialog(null, "Error: "+ e.getMessage());
            
        }
        JOptionPane.showMessageDialog(null, "dato eliminado con exito!!");
         }
         
         public void eliminarcliente(int rut, String nombre,int edad){
             
             try
        {
            Class.forName("org.sqlite.JDBC");
            conexion = DriverManager.getConnection("jdbc:sqlite:supermercado.sqlite");
            conexion.setAutoCommit(false);
            sentencia = conexion.createStatement();
            
            String SQL= "DELETE FROM CLIENTE WHERE RUT='"+rut+"'";
            
            sentencia.executeUpdate(SQL);
            conexion.commit();
            
            sentencia.close();
            conexion.close();
            
        }
        catch(ClassNotFoundException | SQLException e)
        {
            JOptionPane.showMessageDialog(null, "Error: "+ e.getMessage());
            
        }
        JOptionPane.showMessageDialog(null, "dato eliminado con exito!!");
}

}    
        
    
        
    
    

