/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mogus.transferlistaORM.controller;

import java.util.List;
import mogus.transferlistaORM.model.Klub;
import mogus.transferlistaORM.pomocno.HibernateUtil;
import mogus.transferlistaORM.pomocno.ObradaSucelje;
import mogus.transferlistaORM.pomocno.TransferListaORMException;

/**
 *
 * @author domin
 */
public class ObradaKlub extends Obrada<Klub> implements ObradaSucelje<Klub>{

    public ObradaKlub(){
        super();
    }
    
    @Override
    public List<Klub> getLista() {
        return HibernateUtil.getSession().createQuery("from Klub").list();
    }

    @Override
    public void kontrola(Klub kl) throws TransferListaORMException {
        if(kl.getNaziv()==null){
            throw new TransferListaORMException("Klub nije definiran");
        }
        if(kl.getNaziv().trim().isEmpty()){
            throw new TransferListaORMException("Klub nije unesen");
    }
        if(kl.getMjesto()==null){
            throw new TransferListaORMException("Mjesto nije definirano");
        }
        if(kl.getMjesto().trim().isEmpty()){
            throw new TransferListaORMException("Mjesto nije uneseno");
    }
    }

    @Override
    public Klub spremi(Klub kl) throws TransferListaORMException {
        kontrola(kl);
        return dao.save(kl);
    }

    @Override
    public void obrisi(Klub kl) throws TransferListaORMException {
        kontrola(kl);
        if(!kl.getIgraci().isEmpty()){
            throw new TransferListaORMException("Klub nije obrisan jer ima igraca");
    } 
        dao.delete(kl);
    }
    
}
