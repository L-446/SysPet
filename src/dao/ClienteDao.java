package dao;

import controller.Persistencia;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.Cliente;

public class ClienteDao {

    Exception erro;

    public void inserir(Cliente l) throws Exception {
        try {
            String insereCliente = "INSERT INTO `tbl_cliente`(`nome_do_cliente`,`idade`, `doc`, `endereco`, `numero`) VALUES (?,?,?,?,?)";
            PreparedStatement ps = Persistencia.conexao().prepareStatement(insereCliente);
            ps.setString(1, l.getNome());
            ps.setInt(2, l.getIdade());
            ps.setString(3, l.getCpf());
            ps.setString(4, l.getEndereco());
            ps.setInt(5, l.getNumero());

            ps.executeUpdate();
        } catch (SQLException e) {
            throw new Exception("Não foi possível executar a inserção." + e);
        }
    }

    public void deletar(Cliente l) throws Exception {
        try {
            String deleteCliente = "DELETE FROM `tbl_cliente` WHERE id_cliente=" + l.getId();
            PreparedStatement ps = Persistencia.conexao().prepareStatement(deleteCliente);
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new Exception("Não foi possível executar a exclusão.");
        }
    }

    public Cliente listar(String nome_do_cliente, int t) throws Exception {
        try {
            String sql = "SELECT * FROM `tbl_cliente` WHERE nome_do_cliente ='" + nome_do_cliente + "'";
            PreparedStatement ps = Persistencia.conexao().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                Cliente l = new Cliente();

                l.setId(rs.getInt("id_cliente"));
                l.setNome(rs.getString("nome_do_cliente"));
                l.setIdade(rs.getInt("idade"));
                l.setCpf(rs.getString("doc"));
                l.setEndereco(rs.getString("endereco"));
                l.setNumero(rs.getInt("numero"));

                return l;
            }
            return null;
        } catch (SQLException e) {
            throw new Exception("Não foi possível executar a busca." + e);
        }
    }

    public ArrayList<Cliente> listar(String filter) throws Exception {
        try {
            ArrayList<Cliente> cliente = new ArrayList<Cliente>();
            String sql = "SELECT * FROM `tbl_cliente` ";
            if (!filter.equals("")) {
                sql += " WHERE LOWER(id_cliente) LIKE '%" + filter.toLowerCase() + "%'";
            }
            sql += " ORDER BY id_cliente";
            PreparedStatement ps = Persistencia.conexao().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Cliente l = new Cliente();

                l.setId(rs.getInt("id_cliente"));
                l.setNome(rs.getString("nome_do_cliente"));
                l.setIdade(rs.getInt("idade"));
                l.setCpf(rs.getString("doc"));
                l.setEndereco(rs.getString("endereco"));
                l.setNumero(rs.getInt("numero"));

                cliente.add(l);
            }
            return cliente;
        } catch (SQLException e) {
            throw new Exception("Não foi possível executar a busca." + e);
        }
    }

    public Cliente buscarCliente(int id) {
        try {

            String sql = "SELECT * FROM tbl_cliente WHERE tbl_cliente.id_cliente = " + id;
            PreparedStatement ps = Persistencia.conexao().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                Cliente l = new Cliente();

                l.setId(rs.getInt("id_cliente"));
                l.setNome(rs.getString("nome_do_cliente"));
                l.setIdade(rs.getInt("idade"));
                l.setCpf(rs.getString("doc"));
                l.setEndereco(rs.getString("endereco"));
                l.setNumero(rs.getInt("numero"));

                return l;
            }
            return null;
        } catch (SQLException e) {
            erro = e;
            return null;

        }
    }

    public boolean alterar(Cliente a) throws Exception {
        try {
            String alteraCliente = "UPDATE tbl_cliente SET nome_do_cliente =?, idade=?, doc=?, endereco=?, numero=? WHERE id_cliente='" + a.getId() + "'";
            PreparedStatement ps = Persistencia.conexao().prepareStatement(alteraCliente);
            ps.setString(1, a.getNome());
            ps.setInt(2, a.getIdade());
            ps.setString(3, a.getCpf());
            ps.setString(4, a.getEndereco());
            ps.setInt(5, a.getNumero());

            ps.executeUpdate();
        } catch (SQLException e) {
            throw new Exception("Não foi possível executar a alteração.");
        }
        return false;
    }

    public Exception erros() {
        return erro;
    }
}
