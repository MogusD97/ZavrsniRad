/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mogusd.Controller;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import mogusd.Model.Liga;
import mogusd.Utility.Baza;
import mogusd.Utility.TransferListaException;


/**
 *
 * @author domin
 */
public class ObradaLiga {
    private PreparedStatement izraz;
    private ResultSet rs;

    public List<Liga> read() {
        List<Liga> lige = new ArrayList<>();
        try {
            izraz = Baza.getInstance().getConnection().prepareStatement("select * from liga");
            rs = izraz.executeQuery();
            Liga l;
            while (rs.next()) {
                l = new Liga();
                l.setSifra(rs.getInt("sifra"));
                l.setNaziv(rs.getString("naziv"));
                l.setDrzava(rs.getString("drzava"));
                lige.add(l);
                
                try {
                    l.setSifra(rs.getInt("sifra"));
                    l.setNaziv(rs.getString("naziv"));
                    l.setDrzava(rs.getString("drzava"));
                } catch (java.sql.SQLException e) {
                    l.setNaziv(null);
                    l.setDrzava(null);
                }
            }
            rs.close();
            izraz.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lige;
    
}
    public Liga create(Liga l) throws TransferListaException{

        kontrola(l);
        
        
        
        try {
            izraz = Baza.getInstance().getConnection().prepareStatement(
                    "insert into liga (naziv,drzava) "
                    + " values (?,?)", Statement.RETURN_GENERATED_KEYS);
            izraz.setString(1, l.getNaziv());
            izraz.setString(2, l.getDrzava());
            try {
                izraz.setString(1, l.getNaziv());
                izraz.setString(2, l.getDrzava());
            } catch (Exception e) {
                e.printStackTrace();
            }

            izraz.executeUpdate();
            rs = izraz.getGeneratedKeys();
            rs.next();
            l.setSifra(rs.getInt(1));

            rs.close();
            izraz.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return l;
    }

    public boolean delete(Liga l) {

        try {

            izraz = Baza.getInstance().getConnection().prepareStatement("delete from liga where sifra=?");
            izraz.setInt(1, l.getSifra());

            return izraz.executeUpdate() > 0;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

    }

    public boolean update(Liga l) throws TransferListaException{
        
         kontrola(l);
        
        try {
            izraz = Baza.getInstance().getConnection().prepareStatement(
                    "update liga set naziv ?, drzava ? "
                    + " where sifra ?");
            izraz.setString(1, l.getNaziv());
            izraz.setString(2, l.getDrzava());
            izraz.setInt(3, l.getSifra());
            try {
                izraz.setString(1, l.getNaziv());
                izraz.setString(2, l.getDrzava());
            } catch (Exception e) {
                e.printStackTrace();
            }

            return izraz.executeUpdate() > 0;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    private void kontrola(Liga l) throws TransferListaException{
       if(l.getNaziv()==null){
            throw new TransferListaException("Naziv je null, obavezan unos");
        }
        
        if(l.getNaziv().trim().length()==0){
            throw new TransferListaException("Naziv je prazan, obavezan unos");
        }
        
        if(l.getNaziv().length()>50){
            throw new TransferListaException("Dužina naziva veća od dopuštene");
        }
        
        if(l.getDrzava()==null){
            throw new TransferListaException("Država je null, obavezan unos");
        }
        
        if(l.getDrzava().trim().length()==0){
            throw  new TransferListaException("Država je prazana, obavezan unos");
        }
        
        if(l.getDrzava().length()>50){
            throw  new TransferListaException("Dužina države veća od dopuštene");
        }
        
    }
}