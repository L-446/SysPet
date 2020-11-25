/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import controller.Persistencia;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.Login;

/**
 *
 * @author Jkm
 */
public class LoginDao {

    Exception erro;

    public void inserir(Login l) throws Exception {
        try {
            String insereUsuario = "INSERT INTO `login`(`usuario`, `senha`) VALUES (?, md5(?))";
            PreparedStatement ps = Persistencia.conexao().prepareStatement(insereUsuario);
            ps.setString(1, l.getUsuario());
            ps.setString(2, l.getSenha());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new Exception("Não foi possível executar a inserção.");
        }
    }

    public boolean logar(Login l) throws Exception {
        try {
            String sql = "SELECT `usuario` FROM `login` WHERE usuario='" + l.getUsuario() + "' AND senha=md5('" + l.getSenha() + "')";
            PreparedStatement ps = Persistencia.conexao().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            return rs.first();
        } catch (Exception e) {
            throw new Exception("Não foi possível verificar usuário.");
        }
    }

    public Login buscarUsuario(int id) {
        try {

            String sql = "SELECT * FROM login WHERE login.id = " + id;
            PreparedStatement ps = Persistencia.conexao().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                Login l = new Login();

                l.setId(rs.getInt("id"));
                l.setUsuario(rs.getString("usuario"));

                return l;
            }
            return null;
        } catch (SQLException e) {
            erro = e;
            return null;

        }
    }

    public Exception erros() {
        return erro;
    }

    public ArrayList<Login> listar(String filter) throws Exception {
        try {
            ArrayList<Login> login = new ArrayList<Login>();
            String sql = "SELECT * FROM `login` ";
            if (!filter.equals("")) {
                sql += " WHERE LOWER(usuario) LIKE '%" + filter.toLowerCase() + "%'";
            }
            sql += " ORDER BY id";
            PreparedStatement ps = Persistencia.conexao().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Login l = new Login();
                l.setId(rs.getInt("id"));
                l.setUsuario(rs.getString("usuario"));
                //l.setSenha(rs.getString("senha"));

                login.add(l);
            }
            return login;
        } catch (SQLException e) {
            throw new Exception("Não foi possível executar a busca.");
        }

    }

    public void deletar(Login l) throws Exception {
        try {
            String deleteAluno = "DELETE FROM `login` WHERE id=" + l.getId();
            PreparedStatement ps = Persistencia.conexao().prepareStatement(deleteAluno);
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new Exception("Não foi possível executar a exclusão.");
        }
    }

    public Login listar(String usuario, int t) throws Exception {
        try {
            String sql = "SELECT * FROM `login` WHERE usuario='" + usuario + "'";
            PreparedStatement ps = Persistencia.conexao().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {

                Login l = new Login();

                l.setId(rs.getInt("id"));
                l.setUsuario(rs.getString("usuario"));
                //l.setSenha(rs.getString("senha"));

                return l;
            }
            return null;
        } catch (SQLException e) {
            throw new Exception("Não foi possível executar a busca." + e);
        }
    }

    public void alterar(Login a) throws Exception {
        try {
            String alteraUsuario = "UPDATE login SET usuario=?, senha=md5(?) WHERE id='" + a.getId() + "'";
            PreparedStatement ps = Persistencia.conexao().prepareStatement(alteraUsuario);
            ps.setString(1, a.getUsuario());
            ps.setString(2, a.getSenha());
            ps.executeUpdate();

        } catch (SQLException e) {
            throw new Exception("Não foi possível executar a alteração.");
        }
    }
}
