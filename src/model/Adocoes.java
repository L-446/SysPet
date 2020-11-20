package model;

public class Adocoes {
  private int id_adocao;
  private int pk_id_cliente;
  private String nome_do_cliente;
  private int pk_id_pet;
  private String raca;
  
  
   public Adocoes(int pk_id_pet, String nome_do_cliente, int pk_id_cliente, String raca){
       
       this.pk_id_cliente = pk_id_cliente;
       this.nome_do_cliente = nome_do_cliente;
       this.pk_id_pet = pk_id_pet;
       this.raca = raca;
        
   }

    public Adocoes() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * @return the id
     */
    
    /**
     * @return the pk_id_cliente
     */
    public int getPk_id_cliente() {
        return pk_id_cliente;
    }

    /**
     * @param pk_id_cliente the pk_id_cliente to set
     */
    public void setPk_id_cliente(int pk_id_cliente) {
        this.pk_id_cliente = pk_id_cliente;
    }

    /**
     * @return the nome_do_cliente
     */
    public String getNome_do_cliente() {
        return nome_do_cliente;
    }

    /**
     * @param nome_do_cliente the nome_do_cliente to set
     */
    public void setNome_do_cliente(String nome_do_cliente) {
        this.nome_do_cliente = nome_do_cliente;
    }

    /**
     * @return the pk_id_pet
     */
    public int getPk_id_pet() {
        return pk_id_pet;
    }

    /**
     * @param pk_id_pet the pk_id_pet to set
     */
    public void setPk_id_pet(int pk_id_pet) {
        this.pk_id_pet = pk_id_pet;
    }

    /**
     * @return the raca
     */
    public String getRaca() {
        return raca;
    }

    /**
     * @param raca the raca to set
     */
    public void setRaca(String raca) {
        this.raca = raca;
    }

    /**
     * @return the id_adocao
     */
    public int getId_adocao() {
        return id_adocao;
    }

    /**
     * @param id_adocao the id_adocao to set
     */
    public void setId_adocao(int id_adocao) {
        this.id_adocao = id_adocao;
    }

 
   
}
