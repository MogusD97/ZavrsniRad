/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mogus.transferlistaORM.controller;

import java.util.List;
import mogus.transferlistaORM.model.Drzavljanstvo;
import mogus.transferlistaORM.pomocno.HibernateUtil;
import mogus.transferlistaORM.pomocno.ObradaSucelje;
import mogus.transferlistaORM.pomocno.TransferListaORMException;

/**
 *
 * @author domin
 */
public class ObradaDrzavljanstvo extends Obrada<Drzavljanstvo> implements ObradaSucelje<Drzavljanstvo>{
    
    public ObradaDrzavljanstvo(){
        super();
    }
        
    @Override
    public List<Drzavljanstvo> getLista() {
        return HibernateUtil.getSession().createQuery("from Drzavljanstvo").list();
    }

    @Override
    public void kontrola(Drzavljanstvo dr) throws TransferListaORMException {
        if(dr.getNaziv()==null){
            throw new TransferListaORMException("Naziv nije definiran");
    }
        if(dr.getNaziv().trim().isEmpty()){
            throw new TransferListaORMException("Naziv nije unesen");
    }
        if(dr.getNastupa()==null){
            throw new TransferListaORMException("Drzava nije definirana");
        }
        if(dr.getNastupa().trim().isEmpty()){
            throw new TransferListaORMException("Drzava nije unesena");
    }
      
    }

    @Override
    public Drzavljanstvo spremi(Drzavljanstvo dr) throws TransferListaORMException {
        kontrola(dr);
        return dao.save(dr);
    }

    @Override
    public void obrisi(Drzavljanstvo dr) throws TransferListaORMException {
        kontrola(dr);
        if(!dr.getIgraci().isEmpty()){
            throw new TransferListaORMException("Igrac nije obrisan jer ima drzavljanstvo");
    }
    }
}
