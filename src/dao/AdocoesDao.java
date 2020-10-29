package dao;

import controller.Persistencia;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.Adocoes;

public class AdocoesDao {
    public void inserir(Adocoes l) throws Exception{
        try{
            String insereAdocoes = "INSERT INTO `tbl_adocao`( `pk_id_cliente`,`nome_do_cliente`, `pk_id_pet`, `raca`) VALUES (?,?,?,?)";
             PreparedStatement ps = Persistencia.conexao().prepareStatement(insereAdocoes);
            ps.setInt(1, l.getPk_id_cliente());
            ps.setString(2, l.getNome_do_cliente());
            ps.setInt(3, l.getPk_id_pet());
            ps.setString(4, l.getRaca());
            
            
            ps.executeUpdate();
        }catch(SQLException e){
            throw new Exception("Não foi possível executar a inserção.");
        }   
    }
  
     
    public void deletar(Adocoes l) throws Exception{
        try{
            String deleteAdocoes = "DELETE FROM `tbl_adocao` WHERE id=" + l.getId();
            PreparedStatement ps = Persistencia.conexao().prepareStatement(deleteAdocoes);
            ps.executeUpdate();
        }catch(SQLException e){
            throw new Exception("Não foi possível executar a exclusão.");
        }
    }
    
     public Adocoes listar(int id , int t) throws Exception{
        try{
            String sql = "SELECT * FROM `tbl_adocao` WHERE id ='"+ id +"'";
            PreparedStatement ps = Persistencia.conexao().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                Adocoes l = new Adocoes();
                l.setId(rs.getInt("id"));
                l.setNome_do_cliente("nome_do_cliente");
                l.setPk_id_cliente(rs.getInt("pk_id_cliente"));
                l.setPk_id_pet(rs.getInt("pk_id_pet"));
                l.setRaca("raca");               
                
                return l;
            }
            return null;
        }                       
        catch(SQLException e){
                throw new Exception("Não foi possível executar a busca.");
        }    
    }
      public void alterar(Adocoes a) throws Exception{
        try{
            String alteraAdocoes = "UPDATE login SET nome_do_cliente=?, pk_id_cliente=?, pk_id_pet=?, raca=? WHERE id='"+ a.getId() +"'";
            PreparedStatement ps = Persistencia.conexao().prepareStatement(alteraAdocoes);
            ps.setInt(1, a.getPk_id_cliente());
            ps.setString(2, a.getNome_do_cliente());
            ps.setInt(3, a.getPk_id_pet());
            ps.setString(4, a.getRaca());
            ps.executeUpdate();
        }catch(SQLException e){
            throw new Exception("Não foi possível executar a alteração.");
        }   
    }
      
      public ArrayList<Adocoes> listar(String filtro) throws Exception{
        try{
            ArrayList<Adocoes> adocao = new ArrayList<Adocoes>();
            String sql = "SELECT * FROM `tbl_adocao` ";
            if(!filtro.equals("")){
                sql+=" WHERE LOWER(usuario) LIKE '%"+ filtro.toLowerCase() +"%'";
            }
            sql+=" ORDER BY id";
            PreparedStatement ps = Persistencia.conexao().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                Adocoes l = new Adocoes();
                l.setId(rs.getInt("id"));
                l.setNome_do_cliente("nome_do_cliente");
                l.setPk_id_cliente(rs.getInt("pk_id_cliente"));
                l.setPk_id_pet(rs.getInt("pk_id_pet"));
                l.setRaca("raca"); 
            }
            return adocao;
        }                       
        catch(SQLException e){
                throw new Exception("Não foi possível executar a busca.");
        }    
        
     }
    
}
