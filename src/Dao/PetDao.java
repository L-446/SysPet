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
import model.Pet;
/**
 *
 * @author Jkm
 */
public class PetDao {
public void inserir(Pet l) throws Exception{
        try{
            String inserePet = "INSERT INTO `tbl_pet`(`raca`, `idade`, `peso`, `vacinas`) VALUES (?, md5(?))";
            PreparedStatement ps = Persistencia.conexao().prepareStatement(inserePet);
            ps.setString(1, l.getRaca());
            ps.setString(2, l.getIdade());
            ps.setDouble(3, l.getPeso());
            //*ps.setString(4, l.getVacinas());
            
            ps.executeUpdate();
        }catch(SQLException e){
            throw new Exception("Não foi possível executar a inserção.");
        }   
    }
    
    
    
    
     
    public void deletar(Pet l) throws Exception{
        try{
            String deletePet = "DELETE FROM `tbl_pet` WHERE id=" + l.getId();
            PreparedStatement ps = Persistencia.conexao().prepareStatement(deletePet);
            ps.executeUpdate();
        }catch(SQLException e){
            throw new Exception("Não foi possível executar a exclusão.");
        }
    }
    
     public Pet listar(String raca , int t) throws Exception{
        try{
            String sql = "SELECT * FROM `tbl_pet` WHERE raca ='"+ raca +"'";
            PreparedStatement ps = Persistencia.conexao().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                Pet l = new Pet();
                l.setId(rs.getInt("id"));
                l.setRaca(rs.getString("raca"));
                l.setPeso(rs.getDouble("peso"));
                
                return l;
            }
            return null;
        }                       
        catch(SQLException e){
                throw new Exception("Não foi possível executar a busca.");
        }    
    }
      public void alterar(Pet a) throws Exception{
        try{
            String alteraPet = "UPDATE login SET raca=?, peso=md5(?) WHERE id='"+ a.getId() +"'";
            PreparedStatement ps = Persistencia.conexao().prepareStatement(alteraPet);
            ps.setString(1, a.getRaca());
            ps.setDouble(2, a.getPeso());
            ps.executeUpdate();
        }catch(SQLException e){
            throw new Exception("Não foi possível executar a alteração.");
        }   
    }
      
      public ArrayList<Login> listar(String filtro) throws Exception{
        try{
            ArrayList<Login> login = new ArrayList<Login>();
            String sql = "SELECT * FROM `login` ";
            if(!filtro.equals("")){
                sql+=" WHERE LOWER(usuario) LIKE '%"+ filtro.toLowerCase() +"%'";
            }
            sql+=" ORDER BY id";
            PreparedStatement ps = Persistencia.conexao().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                Login l = new Login();
                l.setId(rs.getInt("id"));
                l.setUsuario(rs.getString("usuario"));
                //l.setSenha(rs.getString("senha"));
                login.add(l);
            }
            return login;
        }                       
        catch(SQLException e){
                throw new Exception("Não foi possível executar a busca.");
        }    
        
     }
   
        
     }
      
      
      
     
