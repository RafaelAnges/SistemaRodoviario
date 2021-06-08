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
public class PassagemDAO {

    Connection conn;
    PreparedStatement pstm;
    ResultSet rs;
    
    ArrayList<PassagemDTO> lista = new ArrayList<>();
    ArrayList<PassagemDTO> lista1 = new ArrayList<>();

    public void cadastrarPassagem(PassagemDTO objpassagemdto) {
        String sql = "insert into passagem (id_p, cidadeOrigem_p, cidadeDestino_p, dataSaida_p, horaSaida_p, veiculo_p, poltrona_p, valor_p) value (?,?,?,?,?,?,?,?)";

        conn = new ConexaoDAO().conectaBD();

        try {

            pstm = conn.prepareStatement(sql);
            pstm.setInt(1, objpassagemdto.getId_p());
            pstm.setString(2, objpassagemdto.getCidadeOrigem_p());
            pstm.setString(3, objpassagemdto.getCidadeDestino_p());
            pstm.setString(4, objpassagemdto.getDataSaida_p());
            pstm.setString(5, objpassagemdto.getHoraSaida_p());
            pstm.setString(6, objpassagemdto.getVeiculo_p()); 
            pstm.setInt(7, objpassagemdto.getPoltrona_p());
            pstm.setString(8, objpassagemdto.getValor_p());

            pstm.execute();
            pstm.close();

        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "PassagemDAO1" + erro);
        }
    }

    private Statement st;

    public ArrayList<PassagemDTO> AtualizarPassagem() {
        String sql = "select id_p, cidadeOrigem_p, cidadeDestino_p, dataSaida_p, horaSaida_p, veiculo_p, poltrona_p, valor_p from passagem";

        conn = new ConexaoDAO().conectaBD();

        try {

            pstm = conn.prepareStatement(sql);
            rs = pstm.executeQuery();

            while (rs.next()) {
                PassagemDTO objpassagemDTO = new PassagemDTO();
                objpassagemDTO.setId_p(rs.getInt("id_p"));
                objpassagemDTO.setCidadeOrigem_p(rs.getString("cidadeOrigem_p"));
                objpassagemDTO.setCidadeDestino_p(rs.getString("cidadeDestino_p"));
                objpassagemDTO.setDataSaida_p(rs.getString("dataSaida_p"));
                objpassagemDTO.setHoraSaida_p(rs.getString("horaSaida_p"));
                objpassagemDTO.setVeiculo_p(rs.getString("veiculo_p"));
                objpassagemDTO.setPoltrona_p(rs.getInt("poltrona_p"));
                objpassagemDTO.setValor_p(rs.getString("valor_p"));

                lista.add(objpassagemDTO);

            }

        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "PassagemDAO2 Atualizar:" + erro);
        }
        return lista;

    }

    public void excluirPassagem(PassagemDTO objpassagemdto) {
        String sql = "delete from passagem where id_p = ?";

        conn = new ConexaoDAO().conectaBD();

        try {

            pstm = conn.prepareStatement(sql);
            pstm.setInt(1, objpassagemdto.getId_p());

            pstm.execute();
            pstm.close();

        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "PassagemDAO3 Excluir" + erro);
        }
    }
    
    public ResultSet comboCidade2(){
        
    conn = new ConexaoDAO().conectaBD();
        String sql = "select C.cidade_c, V.modelo_v, V.poltrona_v from cidade C join veiculo V on C.id_c = V.numero_v";

        try {

            pstm = conn.prepareStatement(sql);
            return pstm.executeQuery();

        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "listaCidade" + erro);
            return null;
        }
    }
    
       
 
    
      
      public ResultSet comparar(){
          conn = new ConexaoDAO().conectaBD();
          String sql = "select cidadeDestino_p, poltrona_p from passagem";
          
          try {
              
              pstm = conn.prepareStatement(sql);
                  return pstm.executeQuery();

        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "compararaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa" + erro);
            return null;
        }
          
      }
    
    
    
    
    
      
      
      
      
      
      
      
      
      
      
      
      
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    public ResultSet calcular() {
        String sql = "SELECT sum(valor_p) from passagem";

        conn = new ConexaoDAO().conectaBD();

        try {

            pstm = conn.prepareStatement(sql);
            return pstm.executeQuery();

        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "PassagemDAO3 Excluir" + erro);
            return null;
        }

    }

    public ArrayList<PassagemDTO> DataPassagem() {
        String sql = "select dataSaida_p, valor_p from passagem";

        conn = new ConexaoDAO().conectaBD();

        try {

            pstm = conn.prepareStatement(sql);
            rs = pstm.executeQuery();

            PassagemDTO objpassagemDTO = new PassagemDTO();
while(rs.next()){
            objpassagemDTO.setDataSaida_p(rs.getString("dataSaida_p"));
            objpassagemDTO.setValor_p(rs.getString("valor_p"));
}
            lista1.add(objpassagemDTO);

        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "PassagemDAO3 " + erro);
            
        }

        return lista1;

    }
    
    
    

}
