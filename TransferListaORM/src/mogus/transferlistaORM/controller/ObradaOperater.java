/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mogus.transferlistaORM.controller;

import java.util.List;
import mogus.transferlistaORM.model.Operater;
import mogus.transferlistaORM.pomocno.BCrypt;
import mogus.transferlistaORM.pomocno.HibernateUtil;
import mogus.transferlistaORM.pomocno.ObradaSucelje;
import mogus.transferlistaORM.pomocno.TransferListaORMException;

/**
 *
 * @author domin
 */
public class ObradaOperater extends Obrada<Operater> implements ObradaSucelje<Operater>{
    
    public Operater autoriziraj(String email, String lozinka){
        
        Operater o = (Operater)HibernateUtil.getSession().createQuery(" from Operater a "
                + " where a.email=:email ") 
                .setString("email", email)
                .uniqueResult();
        if(o==null){
            return null;
        }
        if(BCrypt.checkpw(lozinka, o.getLozinka())){
            //o.setLozinka(null);
            return o;
        }
        
        return null;
    }
    
    @Override
    public List<Operater> getLista() {
        return HibernateUtil.getSession().createQuery("from Operater").list();
    }

    @Override
    public void kontrola(Operater op) throws TransferListaORMException {
        
    }

    @Override
    public Operater spremi(Operater op) throws TransferListaORMException{
        return dao.save(op);
    }

    @Override
    public void obrisi(Operater op) throws TransferListaORMException {
        
    }
    
}
