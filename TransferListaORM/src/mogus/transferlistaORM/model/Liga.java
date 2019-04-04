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
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author domin
 */
@Entity
@Table
public class Liga extends Entitet implements Serializable{
    
    private String naziv;
    private String drzava;
    
    @OneToMany(mappedBy = "liga")
    private List<Klub> klubovi = new ArrayList<>();

    public List<Klub> getKlubovi() {
        return klubovi;
    }

    public void setKlubovi(List<Klub> klubovi) {
        this.klubovi = klubovi;
    }
    
    

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public String getDrzava() {
        return drzava;
    }

    public void setDrzava(String drzava) {
        this.drzava = drzava;
    }

    @Override
    public String toString() {
        return getNaziv() + " ";
    }
    
    
    
}

