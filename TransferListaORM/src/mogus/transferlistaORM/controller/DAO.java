
package mogus.transferlistaORM.controller;

import mogus.transferlistaORM.model.Entitet;
import mogus.transferlistaORM.pomocno.HibernateUtil;
import java.util.Date;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 * @param <T> bilo koji entitet mapiran putem ORM-a
 */
public class DAO<T> {

    private final Session session;

    public DAO() {
        session = HibernateUtil.getSession();
    }

    //Create ili Update
    public T save(T entitet) {
        session.beginTransaction();
        session.saveOrUpdate(entitet);
        session.getTransaction().commit();
        return entitet;
    }
    
    
    //Read
    @Deprecated
    public List<T> createQuery(String hql) {
        Query q = session.createQuery(hql);
        Date d = new Date();
        return q.list();
    }

    //Delete
    public void delete(T entitet) {
      session.beginTransaction();
      session.delete(entitet);
      session.getTransaction().commit();
    }

    //spremi cijelu listu u jednoj transakciji
    public List<T> save(List<T> lista) {
        session.beginTransaction();
        lista.stream().forEach((entitet) -> {
            session.saveOrUpdate(entitet);
        });
        session.getTransaction().commit();
        return lista;
    }

}
