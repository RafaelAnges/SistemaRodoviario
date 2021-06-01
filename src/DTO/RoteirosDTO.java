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
public class RoteirosDTO {
    
    private String cidadeDestino_r, veiculo_r;
    private int poltrona_r, codCidade;

    /**
     * @return the cidadeDestino_r
     */
    public String getCidadeDestino_r() {
        return cidadeDestino_r;
    }

    /**
     * @param cidadeDestino_r the cidadeDestino_r to set
     */
    public void setCidadeDestino_r(String cidadeDestino_r) {
        this.cidadeDestino_r = cidadeDestino_r;
    }

    /**
     * @return the veiculo_r
     */
    public String getVeiculo_r() {
        return veiculo_r;
    }

    /**
     * @param veiculo_r the veiculo_r to set
     */
    public void setVeiculo_r(String veiculo_r) {
        this.veiculo_r = veiculo_r;
    }

    /**
     * @return the poltrona_r
     */
    public int getPoltrona_r() {
        return poltrona_r;
    }

    /**
     * @param poltrona_r the poltrona_r to set
     */
    public void setPoltrona_r(int poltrona_r) {
        this.poltrona_r = poltrona_r;
    }

    /**
     * @return the codCidade
     */
    public int getCodCidade() {
        return codCidade;
    }

    /**
     * @param codCidade the codCidade to set
     */
    public void setCodCidade(int codCidade) {
        this.codCidade = codCidade;
    }
    
}
