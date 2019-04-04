/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mogus.transferlistaORM.controller;

import java.util.List;
import mogus.transferlistaORM.model.Liga;
import mogus.transferlistaORM.pomocno.HibernateUtil;
import mogus.transferlistaORM.pomocno.ObradaSucelje;
import mogus.transferlistaORM.pomocno.TransferListaORMException;

/**
 *
 * @author domin
 */
public class ObradaLiga extends Obrada<Liga> implements ObradaSucelje<Liga>{
    
    public ObradaLiga(){
        super();
    }

    @Override
    public List<Liga> getLista() {
        return HibernateUtil.getSession().createQuery("from Liga").list();
    }

    @Override
    public void kontrola(Liga li) throws TransferListaORMException {
        if(li.getDrzava()==null){
            throw new TransferListaORMException("Drzava nije definirana");
        }
        if(li.getDrzava().trim().isEmpty()){
            throw new TransferListaORMException("Drzava nije unesena");
    }
        if(li.getNaziv()==null){
            throw new TransferListaORMException("Naziv nije definiran");
    }
        if(li.getNaziv().trim().isEmpty()){
            throw new TransferListaORMException("Naziv nije unesen");
    }
    }

    @Override
    public Liga spremi(Liga li) throws TransferListaORMException {
        kontrola(li);
        return dao.save(li);
    }

    @Override
    public void obrisi(Liga li) throws TransferListaORMException {
        kontrola(li);
        if(!li.getKlubovi().isEmpty()){
            throw new TransferListaORMException("Liga nije obrisana jer ima klub");
    } 
        dao.delete(li);
}
    
    
    
}
