package mogus.transferlistaORM;

// domaća zadaća:

import mogus.transferlistaORM.controller.ObradaIgrac;
import mogus.transferlistaORM.controller.ObradaKlub;
import mogus.transferlistaORM.controller.ObradaLiga;
import mogus.transferlistaORM.controller.ObradaOperater;
import mogus.transferlistaORM.model.Igrac;
import mogus.transferlistaORM.model.Klub;
import mogus.transferlistaORM.model.Liga;
import mogus.transferlistaORM.model.Operater;
import mogus.transferlistaORM.pomocno.BCrypt;
import mogus.transferlistaORM.pomocno.HibernateUtil;
import mogus.transferlistaORM.view.SplashScreen;


public class Start {

    public static void main(String[] args) {
        
        //HibernateUtil.getSession();
        new SplashScreen().setVisible(true);
//        Klub k = new Klub();
//        
//        k.setNaziv("Liverpool");
//        k.setMjesto("Engleska");
//        
//        
//        ObradaKlub ok = new ObradaKlub();
//        try {
//            ok.spremi(k);
//        } catch (Exception ex) {
//            ex.printStackTrace();
//        }
//               
//           Operater p = new Operater();
//           
//           p.setIme("Dominik");
//           p.setPrezime("Mogus");
//           p.setEmail("mogusd97@gmail.com");
//           p.setLozinka(BCrypt.hashpw("t",BCrypt.gensalt()));
//           
//           ObradaOperater op = new ObradaOperater();
//           try {
//            op.spremi(p);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
           Igrac i = new Igrac();
           
           i.setIme("Luka");
           i.setPrezime("Modric");
           i.setPozicija("Veznjak");
           
           
           ObradaIgrac oi = new ObradaIgrac();
           try {
            oi.spremi(i);
        } catch (Exception e) {
            e.printStackTrace();
        }
}
}

