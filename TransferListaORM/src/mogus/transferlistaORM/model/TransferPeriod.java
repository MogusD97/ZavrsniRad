/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mogus.transferlistaORM.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author domin
 */
@Entity
@Table
public class TransferPeriod extends Entitet implements Serializable{
    
    private String naziv;
    @Temporal(TemporalType.DATE)
    private Date pocetakPerioda;
    @Temporal(TemporalType.DATE)
    private Date krajPerioda;
    
    @OneToMany(mappedBy = "transferperiod")
    private List<TransferLista> transferlista = new ArrayList<>();

    public List<TransferLista> getTransferlista() {
        return transferlista;
    }

    public void setTransferlista(List<TransferLista> transferlista) {
        this.transferlista = transferlista;
    }
    
    

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public Date getPocetakPerioda() {
        return pocetakPerioda;
    }

    public void setPocetakPerioda(Date pocetakPerioda) {
        this.pocetakPerioda = pocetakPerioda;
    }

    public Date getKrajPerioda() {
        return krajPerioda;
    }

    public void setKrajPerioda(Date krajPerioda) {
        this.krajPerioda = krajPerioda;
    }

    @Override
    public String toString() {
        return "TransferPeriod{" + "naziv=" + naziv + ", pocetakPerioda=" + pocetakPerioda + ", krajPerioda=" + krajPerioda + ", transferlista=" + transferlista + '}';
    }
    
    
    
}
