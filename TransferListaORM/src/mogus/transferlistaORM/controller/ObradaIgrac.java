/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mogus.transferlistaORM.controller;

import java.util.List;
import mogus.transferlistaORM.model.Igrac;
import mogus.transferlistaORM.pomocno.HibernateUtil;
import mogus.transferlistaORM.pomocno.ObradaSucelje;
import mogus.transferlistaORM.pomocno.TransferListaORMException;

/**
 *
 * @author domin
 */
public class ObradaIgrac extends Obrada<Igrac> implements ObradaSucelje<Igrac>{
    
    public ObradaIgrac(){
        super();
    }

    @Override
    public List<Igrac> getLista() {
        return HibernateUtil.getSession().createQuery("from Igrac").list();
    }

    @Override
    public void kontrola(Igrac ig) throws TransferListaORMException {
        if(ig.getIme()==null){
            throw new TransferListaORMException("Ime nije definirano");
    }
        if(ig.getIme().trim().isEmpty()){
            throw new TransferListaORMException("Ime nije uneseno");
    }
        if(ig.getPrezime()==null){
            throw new TransferListaORMException("Prezime nije definirano");
    }
        if(ig.getPrezime().trim().isEmpty()){
            throw new TransferListaORMException("Prezime nije uneseno");
    }
        if(ig.getPozicija()==null){
            throw new TransferListaORMException("Pozicija nije definirana");
    }
        if(ig.getPozicija().trim().isEmpty()){
            throw new TransferListaORMException("Pozicija nije unesena");
    }
        if(ig.getDatumRodenja()==null){
            throw new TransferListaORMException("Datum Rodenja nije definirano");
        }
    }

    @Override
    public Igrac spremi(Igrac ig) throws TransferListaORMException {
        kontrola(ig);
        return dao.save(ig);
    }

    @Override
    public void obrisi(Igrac ig) throws TransferListaORMException {
        kontrola(ig);
        if(!ig.getTransferlistaIgrac().isEmpty()){
            throw new TransferListaORMException("Igrac nije obrisan jer se nalazi na transferlisti");
    }
    }
}
