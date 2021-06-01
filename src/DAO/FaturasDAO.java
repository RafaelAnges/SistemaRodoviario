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
import javax.swing.JOptionPane;

/**
 *
 * @author rafae
 */
public class FaturasDAO {
    
    Connection conn;
    PreparedStatement pstm;
    ResultSet rs;
    ArrayList<PassagemDTO> lista = new ArrayList<>();
    String sql ;
    PreparedStatement rt;
    
    public void data(PassagemDTO Objiniciodto){
         String sql = "SELECT dataSaida_p, valor_p FROM passagem where dataSaida_p > inicio and dataSaida_p < fim";
    
        conn = new ConexaoDAO().conectaBD();
        
        try {
            
            pstm = conn.prepareStatement(sql);
            rt = pstm;
             rt.execute();
            rt.close();
            
            
            
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "CidadeDAO"+ erro);
        }
    }
    private Statement st;
     public ArrayList<PassagemDTO> AtualizarFaturas(){
         
       
       
        
        try {
            
            
            rs= rt.executeQuery();
            
            while(rs.next()){
                PassagemDTO objdataDTO = new PassagemDTO();
                objdataDTO.setDataSaida_p(rs.getString("dataSaida_p"));
                objdataDTO.setValor_p(rs.getString("valor_p"));
                
                
                lista.add(objdataDTO);
            }
            
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "CidadeDAO Atualizar:"+ erro);
        }
        return lista;
        
    }
             
             
         
           
    
        
    
     
     
    
    
    
}
