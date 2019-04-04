/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mogus.transferlistaORM.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author domin
 */
@Entity
@Table
public class Klub extends Entitet implements Serializable{
    
    private String naziv;
    @ManyToOne
    private Liga liga;
    private String mjesto;
    
    @OneToMany(mappedBy = "klub")
    private List<Igrac> igraci = new ArrayList<>();
    
    @OneToMany(mappedBy = "klubDosao")
    private List<TransferLista> transferlitaDosao = new ArrayList<>();
    
    @OneToMany(mappedBy = "klubOtisao")
    private List<TransferLista> transferlitaOtisao = new ArrayList<>();

    public List<Igrac> getIgraci() {
        return igraci;
    }

    public void setIgraci(List<Igrac> igraci) {
        this.igraci = igraci;
    }

    public List<TransferLista> getTransferlitaDosao() {
        return transferlitaDosao;
    }

    public void setTransferlitaDosao(List<TransferLista> transferlitaDosao) {
        this.transferlitaDosao = transferlitaDosao;
    }

    public List<TransferLista> getTransferlitaOtisao() {
        return transferlitaOtisao;
    }

    public void setTransferlitaOtisao(List<TransferLista> transferlitaOtisao) {
        this.transferlitaOtisao = transferlitaOtisao;
    }
    
    

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public Liga getLiga() {
        return liga;
    }

    public void setLiga(Liga liga) {
        this.liga = liga;
    }

    public String getMjesto() {
        return mjesto;
    }

    public void setMjesto(String mjesto) {
        this.mjesto = mjesto;
    }

    @Override
    public String toString() {
        return getNaziv() + " ";
    }
    
    
    
    
}
