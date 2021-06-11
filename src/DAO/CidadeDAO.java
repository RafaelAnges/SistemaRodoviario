/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DTO.CidadeDTO;
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
public class CidadeDAO {
    
    Connection conn;
    PreparedStatement pstm;
    ResultSet rs;
    ArrayList<CidadeDTO> lista = new ArrayList<>();
    
    public void cadastrarCidade(CidadeDTO objcidadedto){
        String sql = "insert into cidade (id_c, uf_c, cidade_c) value(?,?,?)";
    
        conn = new ConexaoDAO().conectaBD();
        
        try {
            
            pstm = conn.prepareStatement(sql);
            pstm.setInt(1, objcidadedto.getId_c());
            pstm.setString(2, objcidadedto.getUf_c());
            pstm.setString(3, objcidadedto.getCidade_c()); 
            
            pstm.execute();
            pstm.close();
            
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "CidadeDAO"+ erro);
        }
    
        
    }
    
    private Statement st;
    public ArrayList<CidadeDTO> AtualizarCidade(){
        String sql = "select id_c, uf_c, cidade_c from cidade";
        
        conn = new ConexaoDAO().conectaBD();
        
        try {
            
            pstm = conn.prepareStatement(sql);
            rs = pstm.executeQuery();
            
            while(rs.next()){
                CidadeDTO objcidadeDTO = new CidadeDTO();
                objcidadeDTO.setId_c(rs.getInt("id_c"));
                objcidadeDTO.setUf_c(rs.getString("uf_c"));
                objcidadeDTO.setCidade_c(rs.getString("cidade_c"));
                
                lista.add(objcidadeDTO);
            }
            
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "CidadeDAO Atualizar:"+ erro);
        }
        return lista;
        
    }
    
    public void excluirCidade(CidadeDTO objcidadedto){
        String sql = "delete from cidade where id_c = ?";
        
        conn = new ConexaoDAO().conectaBD();
        
        try {
            
            pstm = conn.prepareStatement(sql);
            pstm.setInt(1, objcidadedto.getId_c());
            
            
            pstm.execute();
            pstm.close();
            
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "CidadeDAO Excluir"+ erro);
        }
    }
    
    
    public void alterarCidade(CidadeDTO cidadedto) {
        String sql = "UPDATE cidade SET uf_c = ?, cidade_c = ? where id_c = ?";

        conn = new ConexaoDAO().conectaBD();

        try {

            pstm = conn.prepareStatement(sql);
            
            pstm.setString(1, cidadedto.getUf_c());
            pstm.setString(2, cidadedto.getCidade_c());
            pstm.setInt(3, cidadedto.getId_c());
            

            pstm.execute();
            pstm.close();

        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "cidadeDAO Alterar" + erro);
        }
        
    }
    
    
  /* public ResultSet listaCidade(){
        conn = new ConexaoDAO().conectaBD();
        String sql = "select cidade_c from cidade";
        
        try {
            
            pstm = conn.prepareStatement(sql);
            return pstm.executeQuery();
            
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null,"listaCidade"+ erro);
            return null;
        }
        
    }
    */
    
    
    
}
