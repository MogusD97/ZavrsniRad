/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mogus.transferlistaORM.view;

import static com.sun.org.apache.xalan.internal.lib.ExsltDatetime.date;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import static javax.management.Query.value;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import mogus.transferlistaORM.controller.ObradaIgrac;
import mogus.transferlistaORM.model.Igrac;
import mogus.transferlistaORM.pomocno.TransferListaORMException;

/**
 *
 * @author domin
 */
public class Igraci extends javax.swing.JFrame {
    private ObradaIgrac obradaIgrac;
    private DecimalFormat format;
    
    
    public Igraci() {
        initComponents();
        obradaIgrac = new ObradaIgrac();
        
        
     
        NumberFormat nf = NumberFormat.getInstance(
                new Locale("hr")
        );
        format = (DecimalFormat) nf;
        format.applyPattern("#,###.00");
        
        ucitajIgrace();
    }
    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        lstIgraci = new javax.swing.JList<>();
        txtSearch = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        txtIme = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtPrezime = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtPozicija = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtDatumRodenja = new javax.swing.JTextField();
        btnDodaj = new javax.swing.JButton();
        btnPromjeni = new javax.swing.JButton();
        btnObrisi = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Igraci");
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setMinimumSize(new java.awt.Dimension(540, 390));
        setPreferredSize(new java.awt.Dimension(540, 390));
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lstIgraci.setFont(new java.awt.Font("Tahoma", 3, 11)); // NOI18N
        lstIgraci.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                lstIgraciValueChanged(evt);
            }
        });
        jScrollPane1.setViewportView(lstIgraci);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 53, 280, 277));

        txtSearch.setFont(new java.awt.Font("Tahoma", 3, 11)); // NOI18N
        txtSearch.setText("Search");
        getContentPane().add(txtSearch, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 22, 280, -1));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("Ime");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(308, 53, -1, -1));

        txtIme.setFont(new java.awt.Font("Tahoma", 3, 11)); // NOI18N
        getContentPane().add(txtIme, new org.netbeans.lib.awtextra.AbsoluteConstraints(308, 76, 180, -1));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("Prezime");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(308, 102, -1, -1));

        txtPrezime.setFont(new java.awt.Font("Tahoma", 3, 11)); // NOI18N
        getContentPane().add(txtPrezime, new org.netbeans.lib.awtextra.AbsoluteConstraints(308, 125, 180, -1));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setText("Datum Rođenja");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(308, 200, -1, -1));

        txtPozicija.setFont(new java.awt.Font("Tahoma", 3, 11)); // NOI18N
        getContentPane().add(txtPozicija, new org.netbeans.lib.awtextra.AbsoluteConstraints(308, 174, 180, -1));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setText("Pozicija");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(308, 156, -1, -1));

        txtDatumRodenja.setFont(new java.awt.Font("Tahoma", 3, 11)); // NOI18N
        getContentPane().add(txtDatumRodenja, new org.netbeans.lib.awtextra.AbsoluteConstraints(308, 223, 180, -1));

        btnDodaj.setText("Dodaj");
        btnDodaj.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDodajActionPerformed(evt);
            }
        });
        getContentPane().add(btnDodaj, new org.netbeans.lib.awtextra.AbsoluteConstraints(308, 249, 180, -1));

        btnPromjeni.setText("Promjeni");
        btnPromjeni.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPromjeniActionPerformed(evt);
            }
        });
        getContentPane().add(btnPromjeni, new org.netbeans.lib.awtextra.AbsoluteConstraints(308, 278, 180, -1));

        btnObrisi.setText("Obrisi");
        btnObrisi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnObrisiActionPerformed(evt);
            }
        });
        getContentPane().add(btnObrisi, new org.netbeans.lib.awtextra.AbsoluteConstraints(308, 307, 180, -1));

        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mogus/transferlistaORM/view/igraci.jpg"))); // NOI18N
        jLabel10.setText("jLabel10");
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(-680, -10, 1700, 810));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void lstIgraciValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_lstIgraciValueChanged
        if(evt.getValueIsAdjusting()){
            return;
        }
        
        Igrac i = lstIgraci.getSelectedValue();
        if(i==null){
            return;
        }
        
          ocistiPolja();
          
         
        txtIme.setText(String.valueOf(i.getIme()));
        txtPrezime.setText(String.valueOf(i.getPrezime()));
        txtPozicija.setText(String.valueOf(i.getPozicija()));
    }//GEN-LAST:event_lstIgraciValueChanged

    private void btnDodajActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDodajActionPerformed
        Igrac i = new Igrac();
      
       if(!kontrola(i)){
           return;
       }
        
        try {
            obradaIgrac.spremi(i);
        } catch (TransferListaORMException e) {
            JOptionPane.showConfirmDialog(null, e.getMessage());
            return;
        }
        
        ucitajIgrace();
        
        ocistiPolja();
    }//GEN-LAST:event_btnDodajActionPerformed

    private void btnPromjeniActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPromjeniActionPerformed
        Igrac i = lstIgraci.getSelectedValue();
        
        if(i==null){
            JOptionPane.showConfirmDialog(null, "Prvo odaberite igraca");
        }
        
        
         if(!kontrola(i)){
           return;
       }
        
        try {
            obradaIgrac.spremi(i);
        } catch (TransferListaORMException e) {
            JOptionPane.showConfirmDialog(null, e.getMessage());
            return;
        }
        
        ucitajIgrace();
        
        ocistiPolja();
    }//GEN-LAST:event_btnPromjeniActionPerformed

    private void btnObrisiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnObrisiActionPerformed
        Igrac i = lstIgraci.getSelectedValue();
        
        if(i==null){
            JOptionPane.showConfirmDialog(null, "Prvo odaberite igraca");
        }
       
        try {
            obradaIgrac.obrisi(i);
             ucitajIgrace();
            ocistiPolja();
        } catch (TransferListaORMException ex) {
           JOptionPane.showMessageDialog(null, "Ne mogu obrisati");
        }
    }//GEN-LAST:event_btnObrisiActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDodaj;
    private javax.swing.JButton btnObrisi;
    private javax.swing.JButton btnPromjeni;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JList<Igrac> lstIgraci;
    private javax.swing.JTextField txtDatumRodenja;
    private javax.swing.JTextField txtIme;
    private javax.swing.JTextField txtPozicija;
    private javax.swing.JTextField txtPrezime;
    private javax.swing.JTextField txtSearch;
    // End of variables declaration//GEN-END:variables

    
    
    private void ucitajIgrace() {
        DefaultListModel<Igrac> m = new DefaultListModel<>();
        for(Igrac i : obradaIgrac.getLista()){
            m.addElement(i);
        }
        lstIgraci.setModel(m);
    }

    private void ocistiPolja() {
        txtIme.setText("");
        txtPrezime.setText("");
        txtDatumRodenja.setText("");
        txtPozicija.setText("");
        txtSearch.setText("");
    }

    private boolean kontrola(Igrac i) {
        try {
            i.setIme((txtIme.getText()));
        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, "Ime nije broj");
            return false;
        }
         try {
            i.setPrezime((txtPrezime.getText()));
        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, "Prezime nije broj");
            return false;
        }
         try {
            i.setPozicija((txtPozicija.getText()));
        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, "Pozicija nije unesen");
            return false;
        }
         return true;
    }
}
