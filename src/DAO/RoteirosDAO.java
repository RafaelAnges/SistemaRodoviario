/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DTO.PassagemDTO;
import DTO.RoteirosDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author rafae
 */
public class RoteirosDAO {

    Connection conn;
    PreparedStatement pstm;
    ResultSet rs;
    ArrayList<PassagemDTO> lista = new ArrayList<>();

    public void cadastrarRoteiros(RoteirosDTO objroteirosdto) {

        String sql = "insert into roteiros (cidadeDestino_r, veiculo_r, poltrona_r, codCidade) value (?,?,?,?)";

        conn = new ConexaoDAO().conectaBD();

        try {

            pstm = conn.prepareStatement(sql);
            pstm.setString(1, objroteirosdto.getCidadeDestino_r());
            pstm.setString(2, objroteirosdto.getVeiculo_r());
            pstm.setInt(3, objroteirosdto.getPoltrona_r());
            pstm.setInt(4, objroteirosdto.getCodCidade());

            pstm.execute();
            pstm.close();

        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "ROTEIROSDAO" + erro);
        }

    }

   

    public ArrayList<PassagemDTO> AtualizarRoteiros() {
        String sql = "SELECT P.cidadeDestino_P, P.veiculo_p, count(P.cidadeDestino_p),(R.poltrona_r - count(P.cidadeDestino_p)) from passagem P join roteiros R on P.cidadeDestino_p = R.cidadeDestino_r  GROUP by P.cidadeDestino_p, R.poltrona_r  ";

        conn = new ConexaoDAO().conectaBD();

        try {

            pstm = conn.prepareStatement(sql);
            rs = pstm.executeQuery();

            while (rs.next()) {
                PassagemDTO objpassagemDTO = new PassagemDTO();
                objpassagemDTO.setCidadeDestino_p(rs.getString("P.cidadeDestino_P"));
                objpassagemDTO.setVeiculo_p(rs.getString("P.veiculo_p"));
                objpassagemDTO.setVendidos(rs.getString("count(P.cidadeDestino_p)"));
                objpassagemDTO.setRestam(rs.getString("(R.poltrona_r - count(P.cidadeDestino_p))"));

                lista.add(objpassagemDTO);

            }

        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "roteiroAtualizar:" + erro);
        }
        return lista;

    }

    
    
    public void excluirRoteiros(RoteirosDTO roteirosdto) {
        String sql = "delete from roteiros where cidadeDestino_r = ?";

        conn = new ConexaoDAO().conectaBD();

        try {

            pstm = conn.prepareStatement(sql);
            pstm.setString(1, roteirosdto.getCidadeDestino_r());

            pstm.execute();
            pstm.close();

        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "roteirosDAO3 Excluir" + erro);
        }
    }
    
    
    
    
    
    public ResultSet listaCidade2() {

        conn = new ConexaoDAO().conectaBD();
        String sql = "select C.cidade_c, C.id_c, V.modelo_v, V.poltrona_v from cidade C join veiculo V on C.id_c = V.numero_v";

        try {

            pstm = conn.prepareStatement(sql);
            return pstm.executeQuery();

        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "listaCidade" + erro);
            return null;
        }
    }

}
