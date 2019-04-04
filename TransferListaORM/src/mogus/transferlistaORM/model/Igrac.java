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
import javax.persistence.ManyToOne;
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
public class Igrac extends Entitet implements Serializable{
    
    private String ime;
    private String prezime;
    @ManyToOne
    private Klub klub;
    @ManyToOne
    private Drzavljanstvo drzavljanstvo;
    @Temporal(TemporalType.DATE)
    private Date datumRodenja;
    private String pozicija;
    
    @OneToMany(mappedBy = "igrac")
    private List<TransferLista> transferlistaIgrac = new ArrayList<>();

    public List<TransferLista> getTransferlistaIgrac() {
        return transferlistaIgrac;
    }

    public void setTransferlitaIgrac(List<TransferLista> transferLista) {
        this.transferlistaIgrac = transferlistaIgrac;
    }
    
    

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getPrezime() {
        return prezime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }

    public Klub getKlub() {
        return klub;
    }

    public void setKlub(Klub klub) {
        this.klub = klub;
    }

    public Drzavljanstvo getDrzavljanstvo() {
        return drzavljanstvo;
    }

    public void setDrzavljanstvo(Drzavljanstvo drzavljanstvo) {
        this.drzavljanstvo = drzavljanstvo;
    }

    public Date getDatumRodenja() {
        return datumRodenja;
    }

    public void setDatumRodenja(Date datumRodenja) {
        this.datumRodenja = datumRodenja;
    }

    public String getPozicija() {
        return pozicija;
    }

    public void setPozicija(String pozicija) {
        this.pozicija = pozicija;
    }

    @Override
    public String toString() {
        return "Igrac{" + "ime=" + ime + ", prezime=" + prezime + ", klub=" + klub + ", drzavljanstvo=" + drzavljanstvo + ", datumRodenja=" + datumRodenja + ", pozicija=" + pozicija + ", transferlistaIgrac=" + transferlistaIgrac + '}';
    }
    
    
    
}
