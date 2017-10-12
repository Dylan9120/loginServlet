package BD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Sergio Cañas
 * @version 1.0
 */
public class BD {
    private Connection con;
    
    public BD(){
        this.con = null;
    }
    
    public Connection Conectar(){
        try{
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            this.con = DriverManager.getConnection("jdbc:mysql://localhost/usuarios", "root", "n0m3l0");
        }catch(Exception e){
            System.out.println(e.toString());
        }
        return this.con;
    }
    
    public void Cerrar() throws SQLException{
        con.close();
    }
}
