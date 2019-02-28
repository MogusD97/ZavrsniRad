/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mogusd.Utility;

/**
 *
 * @author domin
 */
public class TransferListaException extends Exception {
    private String poruka;
    
    public TransferListaException(String poruka){
        this.poruka=poruka;
    }

    public String getPoruka() {
        return poruka;
    }

    public void setPoruka(String poruka) {
        this.poruka = poruka;
    }
    
}
