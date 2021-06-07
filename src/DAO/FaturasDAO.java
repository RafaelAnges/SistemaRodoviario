/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.sql.Date;
import DTO.FaturasDTO;
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
    PreparedStatement pstm;
    ResultSet rs;
    ArrayList<FaturasDTO> lista = new ArrayList<>();

    
    
    public void Faturas(FaturasDTO faturas){
        String sql = "insert into datas (dataInicio, dataFim) value (?,?)";
       
         conn = new ConexaoDAO().conectaBD();
        
        try {
            
            pstm = conn.prepareStatement(sql);
            pstm.setString(1, faturas.getDataInicio());
            pstm.setString(2, faturas.getDataFim());
            
            pstm.execute();
            pstm.close();
            
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "DATAINICIOEFIM "+ erro);
        }
        
    }
    private Statement st;
    
    public ArrayList<FaturasDTO> AtualizarFaturas() {
        String sql = "select P.dataSaida_p, P.valor_p from passagem P join datas D  where P.dataSaida_p  BETWEEN D.dataInicio and D.dataFim ORDER by P.dataSaida_p";

        conn = new ConexaoDAO().conectaBD();
        
        try {

            pstm = conn.prepareStatement(sql);
            rs = pstm.executeQuery();

            while (rs.next()) {
                FaturasDTO faturasDTO = new FaturasDTO();
                faturasDTO.setDataSaida_p(rs.getString("P.dataSaida_p"));
                faturasDTO.setValor_p(rs.getInt("P.valor_p"));
                

                lista.add(faturasDTO);

            }

        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "FaturasDAO Atualizar:" + erro);
        }
        return lista;
        
        
        
    }
    
    public void excluirFaturas(FaturasDTO faturasDTO){
        String sql = "delete from datas where dataInicio = ? and dataFim = ?";
        
        conn = new ConexaoDAO().conectaBD();
        
        try {

            pstm = conn.prepareStatement(sql);
            pstm.setString(1, faturasDTO.getDataInicio());
            pstm.setString(2, faturasDTO.getDataFim());

            pstm.execute();
            pstm.close();

        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Faturas Excluir" + erro);
        }
        
    }
    
     
}
