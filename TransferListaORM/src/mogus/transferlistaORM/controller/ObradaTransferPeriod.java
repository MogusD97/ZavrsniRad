/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mogus.transferlistaORM.controller;

import java.util.List;
import mogus.transferlistaORM.model.TransferPeriod;
import mogus.transferlistaORM.pomocno.HibernateUtil;
import mogus.transferlistaORM.pomocno.ObradaSucelje;
import mogus.transferlistaORM.pomocno.TransferListaORMException;

/**
 *
 * @author domin
 */
public class ObradaTransferPeriod extends Obrada<TransferPeriod> implements ObradaSucelje<TransferPeriod>{
    private ObradaTransferPeriod(){
        super();
    }
        
    @Override
    public List<TransferPeriod> getLista() {
        return HibernateUtil.getSession().createQuery("from TransferPeriod").list();
    }

    @Override
    public void kontrola(TransferPeriod tp) throws TransferListaORMException {
        if(tp.getNaziv()==null){
            throw new TransferListaORMException("Naziv nije definiran");
    }
        if(tp.getNaziv().trim().isEmpty()){
            throw new TransferListaORMException("Naziv nije unesen");
    }
        if(tp.getPocetakPerioda()==null){
            throw new TransferListaORMException("PocetakPerioda nije definiran");
        }
        if(tp.getKrajPerioda()==null){
            throw new TransferListaORMException("KrajPerioda nije definiran");
        }
    }

    @Override
    public TransferPeriod spremi(TransferPeriod tp) throws TransferListaORMException {
        kontrola(tp);
        return dao.save(tp);
    }

    @Override
    public void obrisi(TransferPeriod tp) throws TransferListaORMException {
        kontrola(tp);
        if(!tp.getTransferlista().isEmpty()){
            throw new TransferListaORMException("TransferPeriod nije obrisan jer sadrzi transferlistu");
    }
    }
}
