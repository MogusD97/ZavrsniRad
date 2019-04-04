/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mogus.transferlistaORM.view;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Locale;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import mogus.transferlistaORM.controller.ObradaKlub;
import mogus.transferlistaORM.model.Klub;
import mogus.transferlistaORM.pomocno.TransferListaORMException;

/**
 *
 * @author domin
 */
public class Klubovi extends javax.swing.JFrame {
    private ObradaKlub obradaKlub;
    private DecimalFormat format;
    
    public Klubovi() {
        initComponents();
        obradaKlub = new ObradaKlub();
     
        NumberFormat nf = NumberFormat.getInstance(
                new Locale("hr")
        );
        format = (DecimalFormat) nf;
        format.applyPattern("#,###.00");
        
        ucitajKlubove();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtSearch = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        lstKlubovi = new javax.swing.JList<>();
        jLabel1 = new javax.swing.JLabel();
        txtNaziv = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtMjesto = new javax.swing.JTextField();
        btnDodaj = new javax.swing.JButton();
        btnPromjeni = new javax.swing.JButton();
        btnObrisi = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(510, 294));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtSearch.setFont(new java.awt.Font("Tahoma", 3, 11)); // NOI18N
        txtSearch.setText("Search");
        getContentPane().add(txtSearch, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 26, 267, -1));

        lstKlubovi.setFont(new java.awt.Font("Tahoma", 3, 11)); // NOI18N
        lstKlubovi.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                lstKluboviValueChanged(evt);
            }
        });
        jScrollPane1.setViewportView(lstKlubovi);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 64, 267, 210));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("Naziv");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(295, 64, -1, -1));

        txtNaziv.setFont(new java.awt.Font("Tahoma", 3, 11)); // NOI18N
        getContentPane().add(txtNaziv, new org.netbeans.lib.awtextra.AbsoluteConstraints(297, 87, 190, -1));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("Mjesto");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(295, 125, -1, -1));

        txtMjesto.setFont(new java.awt.Font("Tahoma", 3, 11)); // NOI18N
        getContentPane().add(txtMjesto, new org.netbeans.lib.awtextra.AbsoluteConstraints(295, 153, 192, -1));

        btnDodaj.setText("Dodaj");
        btnDodaj.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDodajActionPerformed(evt);
            }
        });
        getContentPane().add(btnDodaj, new org.netbeans.lib.awtextra.AbsoluteConstraints(295, 184, 192, -1));

        btnPromjeni.setText("Promjeni");
        btnPromjeni.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPromjeniActionPerformed(evt);
            }
        });
        getContentPane().add(btnPromjeni, new org.netbeans.lib.awtextra.AbsoluteConstraints(295, 218, 192, -1));

        btnObrisi.setText("Obrisi");
        btnObrisi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnObrisiActionPerformed(evt);
            }
        });
        getContentPane().add(btnObrisi, new org.netbeans.lib.awtextra.AbsoluteConstraints(295, 251, 192, -1));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mogus/transferlistaORM/view/klubovi.jpg"))); // NOI18N
        jLabel3.setText("jLabel3");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(-50, 0, 570, 310));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void lstKluboviValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_lstKluboviValueChanged
        if(evt.getValueIsAdjusting()){
            return;
        }
        
        Klub k = lstKlubovi.getSelectedValue();
        if(k==null){
            return;
        }
        
          ocistiPolja();
        
        txtNaziv.setText(String.valueOf(k.getNaziv()));
        txtMjesto.setText(String.valueOf(k.getMjesto()));
    }//GEN-LAST:event_lstKluboviValueChanged

    private void btnDodajActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDodajActionPerformed
        Klub k = new Klub();
      
       if(!kontrola(k)){
           return;
       }
        
        try {
            obradaKlub.spremi(k);
        } catch (TransferListaORMException e) {
            JOptionPane.showConfirmDialog(null, e.getMessage());
            return;
        }
        
        ucitajKlubove();
        
        ocistiPolja();
    }//GEN-LAST:event_btnDodajActionPerformed

    private void btnPromjeniActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPromjeniActionPerformed
        Klub k = lstKlubovi.getSelectedValue();
        
        if(k==null){
            JOptionPane.showConfirmDialog(null, "Prvo odaberite smjer");
        }
        
        
         if(!kontrola(k)){
           return;
       }
        
        try {
            obradaKlub.spremi(k);
        } catch (TransferListaORMException e) {
            JOptionPane.showConfirmDialog(null, e.getMessage());
            return;
        }
        
        ucitajKlubove();
        
        ocistiPolja();
    }//GEN-LAST:event_btnPromjeniActionPerformed

    private void btnObrisiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnObrisiActionPerformed
        Klub k = lstKlubovi.getSelectedValue();
        
        if(k==null){
            JOptionPane.showConfirmDialog(null, "Prvo odaberite klub");
        }
       
        try {
            obradaKlub.obrisi(k);
             ucitajKlubove();
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
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JList<Klub> lstKlubovi;
    private javax.swing.JTextField txtMjesto;
    private javax.swing.JTextField txtNaziv;
    private javax.swing.JTextField txtSearch;
    // End of variables declaration//GEN-END:variables

    private void ucitajKlubove() {
        DefaultListModel<Klub> m = new DefaultListModel<>();
        for(Klub k : obradaKlub.getLista()){
            m.addElement(k);
        }
        lstKlubovi.setModel(m);
    }

    private void ocistiPolja() {
        txtNaziv.setText("");
        txtMjesto.setText("");
        txtSearch.setText("");
    }

    private boolean kontrola(Klub k) {
        try {
            k.setNaziv((txtNaziv.getText()));
        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, "Naziv nije broj");
            return false;
        }
         try {
            k.setMjesto((txtMjesto.getText()));
        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, "Mjesto nije broj");
            return false;
        }
    
            return true;
    }
}
