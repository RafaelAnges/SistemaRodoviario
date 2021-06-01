/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DTO.UsuarioDTO;
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
public class UsuarioDAO {

    Connection conn;
    PreparedStatement pstm;
    ResultSet rs;
    ArrayList<UsuarioDTO> lista = new ArrayList<>();

    public ResultSet autenticacaoUsuario(UsuarioDTO objusuariodto) {
        conn = new ConexaoDAO().conectaBD();

        try {

            String sql = "select * from usuario where login_u = ? and senha_u = ? ";
            
            pstm = conn.prepareStatement(sql);
            pstm.setString(1,objusuariodto.getLogin_u());
            pstm.setString(2, objusuariodto.getSenha_u());
            
            rs = pstm.executeQuery();
            return rs;
            

        } catch (SQLException erro) {
            JOptionPane.showConfirmDialog(null, "UsuarioDAooo" + erro);
        }

        return null;
        
    }

    public void cadastrarUsuario(UsuarioDTO objusuariodto) {
        String sql = "insert into usuario (login_u, nome_u, cargo_u, senha_u, email_u) value (?,?,?,?,?)";

        conn = new ConexaoDAO().conectaBD();

        try {

            pstm = conn.prepareStatement(sql);
            pstm.setString(1, objusuariodto.getLogin_u());
            pstm.setString(2, objusuariodto.getNome_u());
            pstm.setString(3, objusuariodto.getCargo_u());
            pstm.setString(4, objusuariodto.getSenha_u());
            pstm.setString(5, objusuariodto.getEmail_u());

            pstm.execute();
            pstm.close();

        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "UsuarioDAO" + erro);
        }
    }

    private Statement st;

    public ArrayList<UsuarioDTO> AtualizarUsuario() {
        String sql = "select login_u, nome_u, cargo_u, email_u from usuario";

        conn = new ConexaoDAO().conectaBD();

        try {

            pstm = conn.prepareStatement(sql);
            rs = pstm.executeQuery();

            while (rs.next()) {
                UsuarioDTO objusuarioDTO = new UsuarioDTO();
                objusuarioDTO.setLogin_u(rs.getString("login_u"));
                objusuarioDTO.setNome_u(rs.getString("nome_u"));
                objusuarioDTO.setCargo_u(rs.getString("cargo_u"));
                objusuarioDTO.setEmail_u(rs.getString("email_u"));

                lista.add(objusuarioDTO);
            }

        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "UsuarioDAO Atualizar:" + erro);
        }
        return lista;

    }

    public void excluirUsuario(UsuarioDTO objusuariodto) {
        String sql = "delete from usuario where login_u = ?";

        conn = new ConexaoDAO().conectaBD();

        try {

            pstm = conn.prepareStatement(sql);
            pstm.setString(1, objusuariodto.getLogin_u());

            pstm.execute();
            pstm.close();

        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "UsuarioDAO Excluir" + erro);
        }

    }

}
