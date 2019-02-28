/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mogusd.View;


import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Locale;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import mogusd.Controller.ObradaLiga;
import mogusd.Model.Liga;
import mogusd.Utility.TransferListaException;

/**
 *
 * @author domin
 */
public class Lige extends javax.swing.JFrame {
    private ObradaLiga obradaLiga;
    private DecimalFormat format;
    /**
     * Creates new form TransferLista
     */
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
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtNaziv = new javax.swing.JTextField();
        txtDrzava = new javax.swing.JTextField();
        btnDodaj = new javax.swing.JButton();
        btnPromjeni = new javax.swing.JButton();
        btnObrisi = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        lstLige.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                lstLigeValueChanged(evt);
            }
        });
        jScrollPane1.setViewportView(lstLige);

        jLabel1.setText("Naziv");

        jLabel2.setText("Drzava");

        btnDodaj.setText("Dodaj");
        btnDodaj.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDodajActionPerformed(evt);
            }
        });

        btnPromjeni.setText("Promjeni");
        btnPromjeni.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPromjeniActionPerformed(evt);
            }
        });

        btnObrisi.setText("Obrisi");
        btnObrisi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnObrisiActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(86, 86, 86)
                .addComponent(btnDodaj)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(89, 89, 89)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnPromjeni)
                        .addGap(37, 37, 37)
                        .addComponent(btnObrisi))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtNaziv, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 63, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(txtDrzava, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(103, 103, 103))
            .addComponent(jScrollPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNaziv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtDrzava, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnDodaj)
                    .addComponent(btnPromjeni)
                    .addComponent(btnObrisi))
                .addGap(0, 28, Short.MAX_VALUE))
        );

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
        
        txtNaziv.setText(l.getNaziv());
        txtDrzava.setText(l.getDrzava());
    }//GEN-LAST:event_lstLigeValueChanged

    private void btnDodajActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDodajActionPerformed
        Liga l = new Liga();
      
       if(!kontrola(l)){
           return;
       }
        
        try {
            obradaLiga.create(l);
        } catch (TransferListaException e) {
            JOptionPane.showConfirmDialog(null, e.getPoruka());
            return;
        }
        
        ucitajLige();
        
        ocistiPolja();
    }//GEN-LAST:event_btnDodajActionPerformed

    private void btnPromjeniActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPromjeniActionPerformed
        Liga l = lstLige.getSelectedValue();
        
        if(l==null){
            JOptionPane.showConfirmDialog(null, "Prvo odaberite ligu");
        }
        
        
         if(!kontrola(l)){
           return;
       }
        
        try {
            obradaLiga.update(l);
        } catch (TransferListaException e) {
            JOptionPane.showConfirmDialog(null, e.getPoruka());
            return;
        }
        
        ucitajLige();
        
        ocistiPolja();
    }//GEN-LAST:event_btnPromjeniActionPerformed

    private void btnObrisiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnObrisiActionPerformed
        Liga l = lstLige.getSelectedValue();
        
        if(l==null){
            JOptionPane.showConfirmDialog(null, "Prvo odaberite ligu");
        }
        
        if(obradaLiga.delete(l)){
            ucitajLige();
            ocistiPolja();
        }else{
            JOptionPane.showConfirmDialog(null,"Liga nije obrisan jer ima grupe");
        }
    }//GEN-LAST:event_btnObrisiActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDodaj;
    private javax.swing.JButton btnObrisi;
    private javax.swing.JButton btnPromjeni;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JList<Liga> lstLige;
    private javax.swing.JTextField txtDrzava;
    private javax.swing.JTextField txtNaziv;
    // End of variables declaration//GEN-END:variables

    private void ucitajLige(){
       DefaultListModel<Liga> m = new DefaultListModel<>();
        for(Liga l : obradaLiga.read()){
          // System.out.println(l.getNaziv());
            m.addElement(l);
        }
        lstLige.setModel(m);
    }

    private void ocistiPolja() {
       txtNaziv.setText("");
       txtDrzava.setText("");
    }

    private boolean kontrola(Liga l) {
         l.setNaziv(txtNaziv.getText());
         l.setDrzava(txtDrzava.getText());
         
         try {
            l.setDrzava(txtDrzava.getText());
        } catch (Exception e) {
        }
        
        return true;
    }
}
