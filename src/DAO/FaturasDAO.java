/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DTO.PassagemDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import javax.swing.JFormattedTextField;
import javax.swing.JOptionPane;

/**
 *
 * @author rafae
 */
public class FaturasDAO {
    
    Connection conn;
    
   public Vector data(String dataInicio, String dataFim) throws Exception{
       conn = new ConexaoDAO().conectaBD();
       Vector tb = new Vector();
       String sql = "select * from passagem where dataSaida_p >= dataInico and dataSaida_p <= dataFim";
       PreparedStatement ps = conn.prepareStatement(sql);
       ResultSet rs = ps.executeQuery();
       while(rs.next()){
           Vector n1 = new Vector();
           n1.add(rs.getDate("dataSaida_p"));
           n1.add(rs.getInt("valor_p"));
           tb.add(n1);
           
       
   }
             
            return tb; 
         
           
    
        
    
     
   }

    public Vector data(JFormattedTextField formInicio, JFormattedTextField formFim) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
}
