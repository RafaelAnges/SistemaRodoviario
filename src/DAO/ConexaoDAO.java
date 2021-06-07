/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author rafae
 */
public class ConexaoDAO {

    static void closeConnection(Connection conn, ResultSet rs) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
    public Connection conectaBD(){
        Connection conn = null;
        
        try{
            String url = "jdbc:mysql://localhost:3306/basedados?user=rafael&password=1494";
            conn = DriverManager.getConnection(url);
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "conexao dao"+erro.getMessage());
            
    }
        return conn;
    }
    
   

    
}
