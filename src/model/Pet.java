/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Jkm
 */
public class Pet {
    private int id;
    private String raca;
    private int idade;
    private double peso;
    private  String vacinas;
    
    
    public Pet(String raca, int idade, double peso, String vacinas){
        this.raca = raca;
        this.idade = idade;
        this.peso = peso;
        this.vacinas = vacinas;
        
    }

    public Pet() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
    public int getId(){
        return id;
    }
    
    public void setId(int id){
        this.id = id;
    }
    
    public String getRaca(){
        return raca;
    }
    
   public void setRaca(String raca){
       this.raca = raca;
       
   }
      
   public int getIdade(){
       return idade;
   }
   
   public void setIdade(int idade){
       this.idade = idade;
   }
    
   public double getPeso(){
       return peso;
   }
   
   public void setPeso(double peso){
       this.peso = peso;
   }
   
  public String getVacinas(){
      return vacinas;
  } 
  public void setVacinas(String vacinas){
      this.vacinas = vacinas;
  }
}
