/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mogus.transferlistaORM.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Transient;

/**
 *
 * @author domin
 */
@Entity
public class Operater extends Entitet{
    
    private String email;
    
    @Column(columnDefinition = "char(60)")
    //@Transient
    private String lozinka;
    
    private String ime;
    
    private String prezime;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLozinka() {
        return lozinka;
    }

    public void setLozinka(String lozinka) {
        this.lozinka = lozinka;
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

    @Override
    public String toString() {
        return "Operater{" + "email=" + email + ", lozinka=" + lozinka + ", ime=" + ime + ", prezime=" + prezime + '}';
    }
    
    
    
}
