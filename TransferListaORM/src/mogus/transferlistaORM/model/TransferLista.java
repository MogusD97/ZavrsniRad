/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mogus.transferlistaORM.model;

import java.io.Serializable;
import java.util.Date;
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
public class TransferLista extends Entitet implements Serializable{
    
    private String naziv;
    private String sezona;
    @ManyToOne
    private TransferPeriod transferperiod;
    @Temporal(TemporalType.DATE)
    private Date datumPrelaska;
    private String cijena;
    @ManyToOne
    private Igrac igrac;
    @ManyToOne
    private Klub klubOtisao;
    @ManyToOne
    private Klub klubDosao;

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public String getSezona() {
        return sezona;
    }

    public void setSezona(String sezona) {
        this.sezona = sezona;
    }

    public TransferPeriod getTransferperiod() {
        return transferperiod;
    }

    public void setTransferperiod(TransferPeriod transferperiod) {
        this.transferperiod = transferperiod;
    }

    public Date getDatumPrelaska() {
        return datumPrelaska;
    }

    public void setDatumPrelaska(Date datumPrelaska) {
        this.datumPrelaska = datumPrelaska;
    }

    public String getCijena() {
        return cijena;
    }

    public void setCijena(String cijena) {
        this.cijena = cijena;
    }

    public Igrac getIgrac() {
        return igrac;
    }

    public void setIgrac(Igrac igrac) {
        this.igrac = igrac;
    }

    public Klub getKlubOtisao() {
        return klubOtisao;
    }

    public void setKlubOtisao(Klub klubOtisao) {
        this.klubOtisao = klubOtisao;
    }

    public Klub getKlubDosao() {
        return klubDosao;
    }

    public void setKlubDosao(Klub klubDosao) {
        this.klubDosao = klubDosao;
    }

    @Override
    public String toString() {
        return "TransferLista{" + "naziv=" + naziv + ", sezona=" + sezona + ", transferperiod=" + transferperiod + ", datumPrelaska=" + datumPrelaska + ", cijena=" + cijena + ", igrac=" + igrac + ", klubOtisao=" + klubOtisao + ", klubDosao=" + klubDosao + '}';
    }
    
    
    
}
