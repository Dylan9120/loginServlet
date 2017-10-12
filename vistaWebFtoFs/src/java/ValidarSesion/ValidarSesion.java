package ValidarSesion;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import BD.BD;
import java.sql.SQLException;
/**
 *
 * @author Sergio Cañas
 * @version 1.0
 */
public class ValidarSesion {
    private Statement sta;
    private ResultSet res;
    private Connection con;
    private BD bd;
    
    public ValidarSesion(){
        this.sta = null;
        this.res = null;
        this.con = null;
        this.bd = new BD();
    }
    
    public boolean Validar(String usu, String pass) throws SQLException{
        boolean valido = false;
        con = bd.Conectar();
        
        sta = con.createStatement();
        
        res = sta.executeQuery("select usuario, contraseña from usuarios");
        
        while(res.next()){
            if(usu.equals(res.getString("usuario")) && pass.equals(res.getString("contraseña"))){
                valido = true;
            }
        }
        
        bd.Cerrar();
        return valido;
    }
}