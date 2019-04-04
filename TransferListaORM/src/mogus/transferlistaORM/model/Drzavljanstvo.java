
package mogus.transferlistaORM.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Table
@Entity
public class Drzavljanstvo extends Entitet implements Serializable{
    
    private String naziv;
    private String nastupa;
    
    @OneToMany(mappedBy = "drzavljanstvo")
    private List<Igrac> igraci = new ArrayList<>();

    public List<Igrac> getIgraci() {
        return igraci;
    }

    public void setIgraci(List<Igrac> igraci) {
        this.igraci = igraci;
    }
    
    

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public String getNastupa() {
        return nastupa;
    }

    public void setNastupa(String nastupa) {
        this.nastupa = nastupa;
    }

    @Override
    public String toString() {
        return "Drzavljanstvo{" + "naziv=" + naziv + ", nastupa=" + nastupa + ", igraci=" + igraci + '}';
    }
    
    
    
}
