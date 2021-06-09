/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

import static com.sun.org.apache.xalan.internal.xsltc.compiler.util.Type.Int;
import java.sql.PreparedStatement;


/**
 *
 * @author rafae
 */
public class PassagemDTO {
    private int id_p;
    private String valor_p;
    private String cidadeOrigem_p;
    private String cidadeDestino_p;
    private String dataSaida_p;
    private String horaSaida_p;
    private String veiculo_p;
    private int poltrona_p;
    
    private String vendidos;
    private String restam;

    /**
     * @return the id_p
     */
    public int getId_p() {
        return id_p;
    }

    /**
     * @param id_p the id_p to set
     */
    public void setId_p(int id_p) {
        this.id_p = id_p;
    }

    /**
     * @return the valor_p
     */
    

    /**
     * @return the cidadeOrigem_p
     */
    public String getCidadeOrigem_p() {
        return cidadeOrigem_p;
    }

    /**
     * @param cidadeOrigem_p the cidadeOrigem_p to set
     */
    public void setCidadeOrigem_p(String cidadeOrigem_p) {
        this.cidadeOrigem_p = cidadeOrigem_p;
    }

    /**
     * @return the cidadeDestino_p
     */
    public String getCidadeDestino_p() {
        return cidadeDestino_p;
    }

    /**
     * @param cidadeDestino_p the cidadeDestino_p to set
     */
    public void setCidadeDestino_p(String cidadeDestino_p) {
        this.cidadeDestino_p = cidadeDestino_p;
    }

    /**
     * @return the dataSaida_p
     */
    public String getDataSaida_p() {
        return dataSaida_p;
    }

    /**
     * @param dataSaida_p the dataSaida_p to set
     */
    public void setDataSaida_p(String dataSaida_p) {
        this.dataSaida_p = dataSaida_p;
    }

    /**
     * @return the horaSaida_p
     */
    public String getHoraSaida_p() {
        return horaSaida_p;
    }

    /**
     * @param horaSaida_p the horaSaida_p to set
     */
    public void setHoraSaida_p(String horaSaida_p) {
        this.horaSaida_p = horaSaida_p;
    }

    /**
     * @return the veiculo_p
     */
    public String getVeiculo_p() {
        return veiculo_p;
    }

    /**
     * @param veiculo_p the veiculo_p to set
     */
    public void setVeiculo_p(String veiculo_p) {
        this.veiculo_p = veiculo_p;
    }

    /**
     * @return the poltrona_p
     */


    /**
     * @return the valor_p
     */
    public String getValor_p() {
        return valor_p;
    }

    /**
     * @param valor_p the valor_p to set
     */
    public void setValor_p(String valor_p) {
        this.valor_p = valor_p;
    }

    /**
     * @return the vendidos
     */
    public String getVendidos() {
        return vendidos;
    }

    /**
     * @param vendidos the vendidos to set
     */
    public void setVendidos(String vendidos) {
        this.vendidos = vendidos;
    }

    /**
     * @return the restam
     */
    public String getRestam() {
        return restam;
    }

    /**
     * @param restam the restam to set
     */
    public void setRestam(String restam) {
        this.restam = restam;
    }

    /**
     * @return the poltrona_p
     */
    public int getPoltrona_p() {
        return poltrona_p;
    }

    /**
     * @param poltrona_p the poltrona_p to set
     */
    public void setPoltrona_p(int poltrona_p) {
        this.poltrona_p = poltrona_p;
    }

    /**
     * @return the data
     */
  

    
}
