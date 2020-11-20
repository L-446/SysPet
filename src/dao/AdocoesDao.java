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
            String insereAdocoes = "INSERT INTO `tbl_adocao`(`nome_do_cliente`, `pk_id_cliente`, `raca`,`pk_id_pet`) VALUES (?,?,?,?)";
             PreparedStatement ps = Persistencia.conexao().prepareStatement(insereAdocoes);
             
            ps.setString(1, l.getNome_do_cliente());
            ps.setInt(2, l.getPk_id_cliente());
            ps.setString(3, l.getRaca());
            ps.setInt(4, l.getPk_id_pet());

            
            ps.executeUpdate();
        }catch(SQLException e){
            throw new Exception("Não foi possível executar a inserção.");
        }   
    }
  
     
    public void deletar(Adocoes l) throws Exception{
        try{
            String deleteAdocoes = "DELETE FROM `tbl_adocao` WHERE id_adocao=" + l.getId_adocao();
            PreparedStatement ps = Persistencia.conexao().prepareStatement(deleteAdocoes);
            ps.executeUpdate();
        }catch(SQLException e){
            throw new Exception("Não foi possível executar a exclusão.");
        }
    }
    
     public Adocoes listar(String nome_do_cliente , int t) throws Exception{
        try{
            String sql = "SELECT * FROM `tbl_adocao` WHERE nome_do_cliente ='"+ nome_do_cliente +"'";
            PreparedStatement ps = Persistencia.conexao().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                Adocoes l = new Adocoes();
                
                l.setId_adocao(rs.getInt("id_adocao"));
                l.setNome_do_cliente("nome_do_cliente");
                l.setPk_id_cliente(rs.getInt("pk_id_cliente"));
                l.setRaca("raca"); 
                l.setPk_id_pet(rs.getInt("pk_id_pet"));           
                
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
            String alteraAdocoes = "UPDATE login SET  nome_do_cliente=?, pk_id_cliente=?, raca=?, pk_id_pet=? WHERE id_adocao='"+ a.getId_adocao()+"'";
            PreparedStatement ps = Persistencia.conexao().prepareStatement(alteraAdocoes);
            
            ps.setString(1, a.getNome_do_cliente());
            ps.setInt(2, a.getPk_id_cliente());
            ps.setString(3, a.getRaca());
            ps.setInt(4, a.getPk_id_pet());
            
            ps.executeUpdate();
        }catch(SQLException e){
            throw new Exception("Não foi possível executar a alteração.");
        }   
    }
      
      public ArrayList<Adocoes> listar(String filter) throws Exception{
        try{
            ArrayList<Adocoes> adocao = new ArrayList<Adocoes>();
            String sql = "SELECT * FROM `tbl_adocao` ";
            if(!filter.equals("")){
                sql+=" WHERE LOWER(id_adocao) LIKE '%"+ filter.toLowerCase() +"%'";
            }
            sql+=" ORDER BY id_adocao";
            PreparedStatement ps = Persistencia.conexao().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){
                Adocoes l = new Adocoes();
                
                l.setId_adocao(rs.getInt("id_adocao")); 
                l.setNome_do_cliente(rs.getString("nome_do_cliente"));
                l.setPk_id_cliente(rs.getInt("pk_id_cliente"));
                l.setRaca(rs.getString("raca")); 
                l.setPk_id_pet(rs.getInt("pk_id_pet"));
                
                adocao.add(l);
            }
            return adocao;
        }                       
        catch(SQLException e){
                throw new Exception("Não foi possível executar a busca.");
        }    
        
     }
    
}
