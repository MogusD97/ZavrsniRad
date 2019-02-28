/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mogusd.Model;

/**
 *
 * @author domin
 */
public class Liga {
    private int sifra;
    private String naziv;
    private String drzava;

    public int getSifra() {
        return sifra;
    }

    public void setSifra(int sifra) {
        this.sifra = sifra;
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
        return "Liga{" + "sifra=" + sifra + ", naziv=" + naziv + ", drzava=" + drzava + '}';
    }
    
    

    
}
