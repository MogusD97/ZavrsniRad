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
import mogus.transferlistaORM.controller.ObradaLiga;
import mogus.transferlistaORM.model.Liga;
import mogus.transferlistaORM.pomocno.TransferListaORMException;

/**
 *
 * @author domin
 */
public class Lige extends javax.swing.JFrame {
    private ObradaLiga obradaLiga;
    private DecimalFormat format;

    public Lige() {
        initComponents();
        obradaLiga = new ObradaLiga();
     
        NumberFormat nf = NumberFormat.getInstance(
                new Locale("hr")
        );
        format = (DecimalFormat) nf;
        format.applyPattern("#,###.00");
        
        ucitajLige();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        lstLige = new javax.swing.JList<>();
        txtSearch = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        txtNaziv = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtDrzava = new javax.swing.JTextField();
        btnDodaj = new javax.swing.JButton();
        btnObrisi = new javax.swing.JButton();
        btnPromjeni = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(510, 294));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lstLige.setFont(new java.awt.Font("Tahoma", 3, 11)); // NOI18N
        lstLige.setToolTipText("");
        lstLige.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                lstLigeValueChanged(evt);
            }
        });
        jScrollPane1.setViewportView(lstLige);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 56, 306, 215));

        txtSearch.setFont(new java.awt.Font("Tahoma", 3, 11)); // NOI18N
        txtSearch.setText("Search");
        getContentPane().add(txtSearch, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 25, 306, -1));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("Naziv");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(334, 56, -1, -1));

        txtNaziv.setFont(new java.awt.Font("Tahoma", 3, 11)); // NOI18N
        getContentPane().add(txtNaziv, new org.netbeans.lib.awtextra.AbsoluteConstraints(334, 74, 150, -1));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("Drzava");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(334, 105, -1, -1));

        txtDrzava.setFont(new java.awt.Font("Tahoma", 3, 11)); // NOI18N
        getContentPane().add(txtDrzava, new org.netbeans.lib.awtextra.AbsoluteConstraints(334, 128, 150, -1));

        btnDodaj.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnDodaj.setText("Dodaj");
        btnDodaj.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDodajActionPerformed(evt);
            }
        });
        getContentPane().add(btnDodaj, new org.netbeans.lib.awtextra.AbsoluteConstraints(334, 166, 150, -1));

        btnObrisi.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnObrisi.setText("Obrisi");
        btnObrisi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnObrisiActionPerformed(evt);
            }
        });
        getContentPane().add(btnObrisi, new org.netbeans.lib.awtextra.AbsoluteConstraints(334, 248, 150, -1));

        btnPromjeni.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnPromjeni.setText("Promjeni");
        btnPromjeni.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPromjeniActionPerformed(evt);
            }
        });
        getContentPane().add(btnPromjeni, new org.netbeans.lib.awtextra.AbsoluteConstraints(334, 207, 150, -1));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mogus/transferlistaORM/view/lige.jpg"))); // NOI18N
        jLabel3.setText("jLabel3");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(-6, 0, 520, 300));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void lstLigeValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_lstLigeValueChanged
        if(evt.getValueIsAdjusting()){
            return;
        }
        
        Liga l = lstLige.getSelectedValue();
        if(l==null){
            return;
        }
        
          ocistiPolja();
        
        txtNaziv.setText(String.valueOf(l.getNaziv()));
        txtDrzava.setText(String.valueOf(l.getDrzava()));
    }//GEN-LAST:event_lstLigeValueChanged

    private void btnDodajActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDodajActionPerformed
        Liga l = new Liga();
      
       if(!kontrola(l)){
           return;
       }
        
        try {
            obradaLiga.spremi(l);
        } catch (TransferListaORMException e) {
            JOptionPane.showConfirmDialog(null, e.getMessage());
            return;
        }
        
        ucitajLige();
        
        ocistiPolja();
    }//GEN-LAST:event_btnDodajActionPerformed

    private void btnPromjeniActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPromjeniActionPerformed
        Liga l = lstLige.getSelectedValue();
        
        if(l==null){
            JOptionPane.showConfirmDialog(null, "Prvo odaberite smjer");
        }
        
        
         if(!kontrola(l)){
           return;
       }
        
        try {
            obradaLiga.spremi(l);
        } catch (TransferListaORMException e) {
            JOptionPane.showConfirmDialog(null, e.getMessage());
            return;
        }
        
        ucitajLige();
        
        ocistiPolja();
    }//GEN-LAST:event_btnPromjeniActionPerformed

    private void btnObrisiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnObrisiActionPerformed
        Liga l = lstLige.getSelectedValue();
        
        if(l==null){
            JOptionPane.showConfirmDialog(null, "Prvo odaberite smjer");
        }
       
        try {
            obradaLiga.obrisi(l);
             ucitajLige();
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
    private javax.swing.JList<Liga> lstLige;
    private javax.swing.JTextField txtDrzava;
    private javax.swing.JTextField txtNaziv;
    private javax.swing.JTextField txtSearch;
    // End of variables declaration//GEN-END:variables

    private void ucitajLige() {
        DefaultListModel<Liga> m = new DefaultListModel<>();
        for(Liga l : obradaLiga.getLista()){
            m.addElement(l);
        }
        lstLige.setModel(m);
    }

    private void ocistiPolja() {
        txtNaziv.setText("");
        txtDrzava.setText("");
        txtSearch.setText("");
    }

    private boolean kontrola(Liga l) {
        try {
            l.setNaziv((txtNaziv.getText()));
        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, "Naziv nije broj");
            return false;
        }
         try {
            l.setDrzava((txtDrzava.getText()));
        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, "Drzava nije broj");
            return false;
        }
    
            return true;
    }
}
