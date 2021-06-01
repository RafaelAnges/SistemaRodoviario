/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;


/**
 *
 * @author rafae
 */
public class CidadeDTO {
    private int id_c;
    private String uf_c,cidade_c;

    /**
     * @return the id_c
     */
    public int getId_c() {
        return id_c;
    }

    /**
     * @param id_c the id_c to set
     */
    public void setId_c(int id_c) {
        this.id_c = id_c;
    }

    /**
     * @return the uf_c
     */
    public String getUf_c() {
        return uf_c;
    }

    /**
     * @param uf_c the uf_c to set
     */
    public void setUf_c(String uf_c) {
        this.uf_c = uf_c;
    }

    /**
     * @return the cidade_c
     */
    public String getCidade_c() {
        return cidade_c;
    }

    /**
     * @param cidade_c the cidade_c to set
     */
    public void setCidade_c(String cidade_c) {
        this.cidade_c = cidade_c;
    }
    
}
