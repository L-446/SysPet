package dao;
import controller.Persistencia;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.Pet;


public class PetDao {
public void inserir(Pet l) throws Exception{
        try{
            String inserePet = "INSERT INTO `tbl_pet`(`raca`, `sexo`, `idade`, `peso`, `vacinas`) VALUES (?,?,?,?,?)";
            PreparedStatement ps = Persistencia.conexao().prepareStatement(inserePet);
            ps.setString(1, l.getRaca());
            ps.setString(2, l.getSexo());
            ps.setInt(3, l.getIdade());
            ps.setDouble(4, l.getPeso());
            ps.setString(5, l.getVacinas());
            
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
                l.setSexo(rs.getString("sexo"));
                l.setIdade(rs.getInt("idade"));
                l.setPeso(rs.getDouble("peso"));
                l.setVacinas(rs.getString("vacinas"));
                
                return l;
            }
            return null;
        }                       
        catch(SQLException e){
                throw new Exception("Não foi possível executar a busca.");
        }    
    }
      
      public ArrayList<Pet> listar(String filter){
        try{
            ArrayList<Pet> pet = new ArrayList<Pet>();
            String sql = "SELECT * FROM `tbl_pet` ";
            if(!filter.equals("")){
                sql+=" WHERE LOWER(raca) LIKE '%"+ filter.toLowerCase() +"%'";
            }
            sql+=" ORDER BY id";
            PreparedStatement ps = Persistencia.conexao().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
           
            while(rs.next()){
                Pet l = new Pet();
                l.setId(rs.getInt("id"));
                l.setRaca(rs.getString("raca"));
                l.setSexo(rs.getString("sexo"));
                l.setIdade(rs.getInt("idade"));
                l.setPeso(rs.getDouble("peso"));
                l.setVacinas(rs.getString("vacinas"));
                
                pet.add(l);
            }
            return pet;
        }                       
        catch(SQLException e){
                return null;
        }    
     }
      
            public void alterar(Pet a) throws Exception{
        try{
            String alteraPet = "UPDATE tbl_pet SET raca=?, sexo=?, peso=?, idade=? , vacinas=? WHERE id='"+ a.getId()+"'";
            PreparedStatement ps = Persistencia.conexao().prepareStatement(alteraPet);
            ps.setString(1, a.getRaca());
            ps.setString(2, a.getSexo());
            ps.setInt(3, a.getIdade());
            ps.setDouble(4, a.getPeso());
            ps.setString(5, a.getVacinas());
            ps.executeUpdate();
            
        }catch(SQLException e){
            throw new Exception("Não foi possível executar a alteração.");
        }   
    }
     
     }
      
      
      
     
