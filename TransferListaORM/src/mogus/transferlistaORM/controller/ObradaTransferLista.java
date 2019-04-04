/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mogus.transferlistaORM.controller;

import java.util.List;
import mogus.transferlistaORM.model.TransferLista;
import mogus.transferlistaORM.pomocno.HibernateUtil;
import mogus.transferlistaORM.pomocno.ObradaSucelje;
import mogus.transferlistaORM.pomocno.TransferListaORMException;

/**
 *
 * @author domin
 */
public class ObradaTransferLista extends Obrada<TransferLista> implements ObradaSucelje<TransferLista>{
    public ObradaTransferLista(){
        super();
    }

    @Override
    public List<TransferLista> getLista() {
         return HibernateUtil.getSession().createQuery("from TransferLista").list();
    }

    @Override
    public void kontrola(TransferLista tl) throws TransferListaORMException {
        if(tl.getNaziv()==null){
            throw new TransferListaORMException("Naziv nije definiran");
        }
        if(tl.getNaziv().trim().isEmpty()){
            throw new TransferListaORMException("Naziv nije unesen");
    }
        if(tl.getSezona()==null){
            throw new TransferListaORMException("Sezona nije definirana");
        }
        if(tl.getSezona().trim().isEmpty()){
            throw new TransferListaORMException("Sezona nije unesena");
    }
        if(tl.getCijena()==null){
            throw new TransferListaORMException("Cijena nije definirana");
        }
        if(tl.getCijena().trim().isEmpty()){
            throw new TransferListaORMException("Cijena nije unesena");
    }
        
    }

    @Override
    public TransferLista spremi(TransferLista tl) throws TransferListaORMException {
        kontrola(tl);
        return dao.save(tl);
    }

    @Override
    public void obrisi(TransferLista tl) throws TransferListaORMException {
     
    }
    
}
