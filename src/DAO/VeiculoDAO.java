/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DTO.VeiculoDTO;
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
public class VeiculoDAO {
    
    
    Connection conn;
    PreparedStatement pstm;
    ResultSet rs;
    ArrayList<VeiculoDTO> lista = new ArrayList<>();
    
    public void cadastrarVeiculo(VeiculoDTO objveiculodto){
        String sql = "insert into veiculo (numero_v, placa_v, motorista_v, modelo_v, data_v, poltrona_v) value (?,?,?,?,?,?)";
       
    
        conn = new ConexaoDAO().conectaBD();
        
        try {
            
            
            
            pstm = conn.prepareStatement(sql);
            pstm.setInt(1, objveiculodto.getNumero_v());
            pstm.setString(2, objveiculodto.getPlaca_v());
            pstm.setString(3, objveiculodto.getMotorista_v());
            pstm.setString(4, objveiculodto.getModelo_v());
            pstm.setString(5, objveiculodto.getData_v());
            pstm.setInt(6, objveiculodto.getPoltrona_v());
            
            pstm.execute();
            pstm.close();
            
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "VeiculoDAO"+ erro);
        }
    }
    
    private Statement st;
    public ArrayList<VeiculoDTO> AtualizarVeiculo(){
        String sql = "select numero_v, placa_v, motorista_v, modelo_v, data_v, poltrona_v from veiculo";
        
        conn = new ConexaoDAO().conectaBD();
        
        try {
            
            pstm = conn.prepareStatement(sql);
            rs = pstm.executeQuery();
            
            while(rs.next()){
                VeiculoDTO objveiculoDTO = new VeiculoDTO();
                objveiculoDTO.setNumero_v(rs.getInt("numero_v"));
                objveiculoDTO.setPlaca_v(rs.getString("placa_v"));
                objveiculoDTO.setMotorista_v(rs.getString("motorista_v"));
                objveiculoDTO.setModelo_v(rs.getString("modelo_v"));
                objveiculoDTO.setData_v(rs.getString("data_v"));
                objveiculoDTO.setPoltrona_v(rs.getInt("poltrona_v"));
                
                lista.add(objveiculoDTO);
            }
            
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "VeiculoDAO Atualizar:"+ erro);
        }
        return lista;
        
    }
    
    public void excluirVeiculo(VeiculoDTO objveiculodto){
        String sql = "delete from veiculo where numero_v = ?";
        
        conn = new ConexaoDAO().conectaBD();
        
        try {
            
            pstm = conn.prepareStatement(sql);
            pstm.setInt(1, objveiculodto.getNumero_v());
            
            
            pstm.execute();
            pstm.close();
            
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "VeiculoDAO Excluir"+ erro);
        }
        
    }
    
     public void alterarVeiculo(VeiculoDTO veiculodto) {
        String sql = "UPDATE veiculo SET   placa_v = ?, motorista_v = ?, modelo_v = ?, data_v= ?, poltrona_v = ? where numero_v = ?";

        conn = new ConexaoDAO().conectaBD();

        try {

            pstm = conn.prepareStatement(sql);
            
            pstm.setString(1, veiculodto.getPlaca_v());
            pstm.setString(2, veiculodto.getMotorista_v());
            pstm.setString(3, veiculodto.getModelo_v());
            pstm.setString(4, veiculodto.getData_v());
             pstm.setInt(5, veiculodto.getPoltrona_v());
             pstm.setInt(6, veiculodto.getNumero_v());

            pstm.execute();
            pstm.close();

        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "UsuarioDAO Alterar" + erro);
        }

}
    
    
    public ResultSet listaVeiculo(){
        conn = new ConexaoDAO().conectaBD();
        String sql = "select modelo_v, poltrona_v from veiculo";
        
        try {
            
            pstm = conn.prepareStatement(sql);
            return pstm.executeQuery();
            
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null,"listaCidade"+ erro);
            return null;
        }
        
    }

    
    
    



}
